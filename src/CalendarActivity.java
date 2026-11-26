import java.time.*;
import java.awt.Color;

/**
 * Represents an activity in the calendar
 */

public class CalendarActivity {

    private String name;
    private LocalDate date;
    private LocalTime time;

    /**
     * Creates a new activity with a name, date, and time
     */

    CalendarActivity(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    /**
     * Creates a new activity with a name and date.
     */
    CalendarActivity(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    /**
     * Returns activity's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns activity's date.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns activity's time.
     */

    public LocalTime getTime() {
        return time;
    }
    /**
     * Returns the default color for a general activity.
     */
    public Color getColor(){
        return Color.gray;
    }
}
