ro# Project Calendar
## JDK Version

This project was developed using **Microsoft OpenJDK 25.0.4**.

## How to Run the Program

1. Open the project in IntelliJ IDEA.
2. Make sure Microsoft OpenJDK 25.0.4 is selected as the Project SDK.
3. Open `Main.java`.
4. Click *Run* to start the calendar application.
## Project Classes

The project consists of six classes:

### Main
Starts the program by creating an object of the `CalendarGUI` class.

### CalendarGUI
Creates the graphical user interface using Java Swing. It displays the current week, highlights today's date, and allows users to add and delete activities. It also checks user input and displays warning messages when needed.

### CalendarActivity
Represents a general calendar activity. Each activity has a name, date, and time. This class is also the parent class of `TrainingActivity` and `MeetingActivity`.

### TrainingActivity
Inherits from `CalendarActivity` and represents a training activity. It overrides the `getColor()` method to display training activities in blue.

### MeetingActivity
Inherits from `CalendarActivity` and represents a meeting activity. It overrides the `getColor()` method to display meeting activities in yellow.

### WeekSchedule
Stores and manages activities using an `ArrayList`. It contains methods to add, remove, and retrieve activities. It also sorts activities by time and checks whether a selected time is already occupied.

## Requirements

| Requirement | Class | Implementation |
|---|---|---|
| G-F1 | CalendarGUI | Creates a Swing window displaying the current week from Monday to Sunday |
| G-F2 | CalendarGUI | Uses `LocalDate` to calculate the dates of the current week |
| G-F3 | CalendarGUI | Highlights today's date using a different background color |
| G-F4 | CalendarGUI, WeekSchedule | Allows users to create activities and displays them on the selected date |
| G-F5 | WeekSchedule, CalendarGUI | Supports multiple activities on the same day |
| G-F6 | WeekSchedule, CalendarGUI | Removes activities when the Delete button is clicked |
| G-F7 | CalendarGUI | Validates user input and displays warning messages |
| G-K1 | Main | Starts the application by creating a `CalendarGUI` object |
| G-K2 | CalendarGUI, WeekSchedule, CalendarActivity | Separates the graphical interface, activity storage, and activity data |
| G-K3 | CalendarActivity, WeekSchedule, CalendarGUI | Uses private instance variables and methods to access or manage data |
| G-K4 | WeekSchedule | Stores activities in an `ArrayList` |
| G-K5 | WeekSchedule | Methods such as `hasActivityOnTime()` accept parameters and return values |
| G-K6 | CalendarGUI | Uses `ActionListener` to handle button clicks |
| G-K7 | All classes | Uses Java naming conventions and consistent indentation |
| G-K8 | All classes | Uses Javadoc comments to describe classes and public methods |
| G-K9 | Main, CalendarGUI | The application compiles and runs successfully |
| G-R1 | README.md | Explains how to run the application and specifies the JDK version |
| G-R2 | README.md | Describes each class and its responsibility |
| G-R3 | README.md | Provides this requirements table |

## Additional Features

| Feature | Class | Implementation |
|---|---|---|
| Activity time | CalendarActivity, CalendarGUI | Uses `LocalTime` to assign a time to each activity |
| Time sorting | WeekSchedule | Sorts activities chronologically using `Comparator.comparing()` |
| Activity types | CalendarActivity, TrainingActivity, MeetingActivity | Uses inheritance and overridden `getColor()` methods to display activity types in different colors |
| Time conflict validation | WeekSchedule, CalendarGUI | Prevents two activities from being added at the same time on the same date |
| Error handling | CalendarGUI | Uses `try/catch` and `JOptionPane` to handle invalid time input |

## Reflection
During this project, I learned more about object-oriented programming in Java, creating a graphical user interface using Swing, and how different classes work together.

### Challenges and Solutions
One of the biggest challenges was sorting activities by time. At first, I struggled to understand how to organize activities stored in an ArrayList. After learning how `Comparator.comparing()` works, I understood how to sort activities in chronological order.

Another challenge was the layout of the Delete button. Initially, everything worked well, but after modifying the code, the button was not displayed correctly in a smaller window. I tried several changes to the panel layout and size, but some made the design worse. It took considerable time, testing, and AI assistance to fix the problem. I learned that small GUI changes can affect the layout and that troubleshooting requires patience.

I initially used `System.out.println()` to display error messages in the console. After receiving advice from AI, I learned to use `JOptionPane.showMessageDialog()` to display warnings directly in the calendar window, making the application more user-friendly.

### What I Learned
I practiced using Swing components such as `JFrame`, `JPanel`, `JButton`, and `JTextField`, along with `ActionListener` to handle button clicks.

I learned about inheritance by creating `TrainingActivity` and `MeetingActivity` as subclasses of `CalendarActivity`. These classes share common properties but use different colors.

I also practiced validating user input. The program displays warnings for invalid times, empty activity names, and time slots that are already occupied.

### Future Improvements
If I had more time, I would add Previous Week and Next Week buttons, allowing users to navigate between weeks instead of viewing only the current week.

Overall, this project improved my understanding of Java and how to combine classes, lists, and graphical components to build a working application.

### Design choices

I chose to divide the program into several classes to make the code easier to understand, maintain, and develop. I used inheritance to represent different types of activities, such as training and meetings.

I also separated the graphical user interface from the management of activities to give each class a clear responsibility.

### Future development – Monthly view

The program could be extended to display an entire month instead of just one week. This would require handling different numbers of days in each month and arranging the dates in a calendar grid.

Navigation buttons could also be added to allow users to switch between previous and upcoming months.
