import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Stores and manages calendar activities in an ArrayList.
 */

public class WeekSchedule {
    private ArrayList<CalendarActivity> activities = new ArrayList<>();

    /**
     * Adds an activity and sorts the activities by time.
     * @param calendarActivity the activity to add
     */

    public void addActivity(CalendarActivity calendarActivity) {

        activities.add(calendarActivity);

        activities.sort(
                Comparator.comparing(CalendarActivity::getTime)
        );

    }

    /**
     * Removes an activity from the calendar.
     * @param calendarActivity the activity to remove
     */
    public void removeActivity(CalendarActivity calendarActivity) {
        activities.remove(calendarActivity);

    }

    /**
     * Checks if an activity exists on the specified date.
     * @param date the date to check
     * @return true if an activity exists, otherwise false
     */
    /*public boolean hasActivityOnDate(LocalDate date) {

        for (CalendarActivity currentActivity : activities) {

            if (currentActivity.getDate().isEqual(date)) {
                return true;
            }
        }
        return false;
    }*/

    //this only returns whether there is an activity on a certain time.
    public boolean hasActivityOnTime(LocalDate date, LocalTime time) {

        for (CalendarActivity currentActivity : activities) {

            if (currentActivity.getDate().isEqual(date) && currentActivity.getTime().equals(time)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of activities in the list.
     * @return the number of activities
     */

    public int getSize() {

        return activities.size();
    }

    /**
     * Takes a date and searches the activities in the ArrayList.
     * Returns a new list containing only the activities
     * that belong to the given date.
     *
     * @param date the date we want to find activities for
     * @return a list of all activities on that date
     */
    public ArrayList<CalendarActivity> getActivitiesForDate(LocalDate date) {
        ArrayList<CalendarActivity> result = new ArrayList<>();

        for (CalendarActivity activity : activities) {
            if (activity.getDate().equals(date)) {
                result.add(activity);
            }
        }

        return result;
    }// this go through all activities and returns activities for a provided date.
}
