import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Represents a training activity in the calendar.
 * Inherits from CalendarActivity.
 */

public class TrainingActivity extends CalendarActivity{

    /**
     * Creates a training activity with a name, date, and time.
     * @param name the name of the training activity
     * @param date the date of the training activity
     * @param time the time of the training activity
     */

    public TrainingActivity(String name, LocalDate date, LocalTime time){

        super(name,date,time);
    }
    /**
     * Returns blue as the color for training activities.
     * @return the color blue
     */

    @Override

    public Color getColor(){
        return Color.blue;
    }



}
