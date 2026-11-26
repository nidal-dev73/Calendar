import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Represents a meeting activity in the calendar.
 * Inherits from CalendarActivity.
 */

public class MeetingActivity extends CalendarActivity {

    /**
     * Creates a meeting activity with a name, date, and time.
     * @param name the name of the meeting
     * @param date the date of the meeting
     * @param time the time of the meeting
     */

    public MeetingActivity(String name, LocalDate date, LocalTime time) {
        super(name, date,time);

    }

    @Override
    /**
     * Returns yellow as the color for meeting activities.
     * @return the color yellow
     */
    public Color getColor(){
        return Color.yellow;
    }
}
