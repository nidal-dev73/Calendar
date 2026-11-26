import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Creates and displays the calendar window using Swing.
 * Shows the current week from Monday to Sunday.
 * Highlights today's date.
 * Allows the user to create and delete activities.
 * Uses WeekSchedule to store and manage activities.
 */

public class CalendarGUI {
    private final WeekSchedule schedule = new WeekSchedule();

    /**
     * Creates the calendar window and its components.
     * Calculates the dates for the current week.
     * Adds buttons and input fields for managing activities.
     */

    CalendarGUI() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel dayNamesPanel = new JPanel();
        dayNamesPanel.setLayout(new GridLayout(1, 7));
        frame.add(dayNamesPanel, BorderLayout.NORTH);

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        for (int i = 0; i < days.length; i++) {
            String day = days[i];
            JLabel label = new JLabel(day);
            label.setHorizontalAlignment(JLabel.CENTER);
            dayNamesPanel.add(label);
        }

        JPanel weekPanel = new JPanel();
        weekPanel.setLayout(new GridLayout(1, 7));//

        LocalDate today = LocalDate.now();
        LocalDate monday = today.minusDays(today.getDayOfWeek().getValue() - 1);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE d MMMM", Locale.forLanguageTag("sv-SE"));
        for (int i = 0; i < 7; i++) {
            LocalDate date = monday.plusDays(i);

            JPanel singleDayPanel = new JPanel(); //en column
            singleDayPanel.setLayout(new BoxLayout(singleDayPanel, BoxLayout.Y_AXIS));
            singleDayPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

            if (date.isEqual(today)) {
                singleDayPanel.setBackground(new Color(220, 255, 220));
            }

            JLabel label = new JLabel(dateFormat.format(date));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            singleDayPanel.add(label);

            JPanel dayActivities = new JPanel();
            dayActivities.setLayout(new BoxLayout(dayActivities, BoxLayout.Y_AXIS));
            dayActivities.setOpaque(false);

            singleDayPanel.add(dayActivities);

            singleDayPanel.add(Box.createVerticalGlue());

            JComboBox<String> box = new JComboBox<>();
           box.setMaximumSize(new Dimension(150, 30));
            box.addItem("general");
            box.addItem("training");
            box.addItem("meeting");
            singleDayPanel.add(box);

            JTextField timingField = new JTextField();
           timingField.setMaximumSize(new Dimension(150, 30));
            timingField.setAlignmentX(Component.CENTER_ALIGNMENT);
            singleDayPanel.add(timingField);


            JTextField textField = new JTextField();
           textField.setMaximumSize(new Dimension(150, 30));
            textField.setAlignmentX(Component.CENTER_ALIGNMENT);
            singleDayPanel.add(textField);


            JButton button = new JButton("create");
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
           button.setMaximumSize(new Dimension(150, 30));

            weekPanel.add(singleDayPanel);


/*
 * Handles clicks on the Create button.
 * Reads the activity name, time, and selected type.
 * Creates an activity and displays it on the selected date.
 * @param e the button click event
 */

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String activityName = textField.getText();

                    String time = timingField.getText();
                    try {
                        LocalTime startTime = LocalTime.parse(time);
                       
                        CalendarActivity activity;
                        String userChoice;

                        userChoice=box.getSelectedItem().toString();

                        if(userChoice.equals("training")){
                            activity=new TrainingActivity(activityName, date, startTime);
                        } else if (userChoice.equals("meeting")) {
                            activity=new MeetingActivity(activityName, date, startTime);
                        }
                        else{
                            activity=new CalendarActivity(activityName, date, startTime);
                        }

                        if (activityName.isBlank()) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Enter activity name!",
                                    "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                       else if (schedule.hasActivityOnTime(date, startTime))
                        {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "choose different time!",
                                    "Warning",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            schedule.addActivity(activity);

                            JPanel oneActivityPanel = new JPanel();
                            oneActivityPanel.setOpaque(false);


                            JLabel label2 = new JLabel(activityName + "" + startTime);

                            oneActivityPanel.add(label2);

                            JButton delete = new JButton("delete");
                            oneActivityPanel.add(delete);

                            dayActivities.add(oneActivityPanel);

                            dayActivities.removeAll();

                            for (CalendarActivity a : schedule.getActivitiesForDate(date)) {

                                JPanel panel = new JPanel();
                                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                                panel.setOpaque(true);
                                panel.setBackground(a.getColor());
                                panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));

                                JLabel lbl = new JLabel(
                                        a.getName() + " " + a.getTime()
                                );
                                lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

                                JButton deleteButton = new JButton("delete");
                                deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                                panel.add(lbl);
                                panel.add(deleteButton);

                                dayActivities.add(panel);

                                deleteButton.addActionListener(event -> {
                                    schedule.removeActivity(a);

                                    dayActivities.remove(panel);

                                    dayActivities.revalidate();
                                    dayActivities.repaint();
                                });
                            }
                            dayActivities.revalidate();
                            dayActivities.repaint();

                            delete.addActionListener(actionEvent -> {

                                schedule.removeActivity(activity);
                                dayActivities.remove(oneActivityPanel);
                                singleDayPanel.revalidate();
                                singleDayPanel.repaint();
                            });

                        }
                    } catch (DateTimeException error) {
                        JOptionPane.showMessageDialog(
                               null,
                                "Incorrect time format. Enter time like 14:30",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }

                    textField.setText("");
                    timingField.setText("");
                }
            });

            singleDayPanel.add(button);
        }

        frame.add(weekPanel, BorderLayout.CENTER);




        frame.setVisible(true);
    }

}