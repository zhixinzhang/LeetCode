package company.Houzz.HouzzOther;
import java.util.GregorianCalendar;

/**
 * Created by norafang on 8/14/17.
 */
public class Calendar {
    int year;
    int month;
    int day;
    static final int[] MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final int[] LEAP_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public Calendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static void main(String[] args) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, 2, 1);
        Calendar calendar = new Calendar(2000, 2, 1);
        int[] days = {0, 10, 31, 365, 366, 1000, 3000};
        for (int i = 0; i < days.length; i++) {
            calendar.addDay(days[i]);
            gregorianCalendar.add(java.util.Calendar.DAY_OF_YEAR, days[i]);
            compareResult(calendar, gregorianCalendar);
        }


    }
    public static void compareResult(Calendar calendar, GregorianCalendar gregorianCalendar) {
        System.out.printf("Current Calendar Date: %d/%d/%d\n", calendar.month, calendar.day, calendar.year);
        System.out.printf("Current GregorianCalendar Date: %d/%d/%d\n", gregorianCalendar.get(java.util.Calendar.MONTH),
                gregorianCalendar.get(java.util.Calendar.DAY_OF_MONTH), gregorianCalendar.get(java.util.Calendar.YEAR));
    }
    public void addDay(int days) {
        int currentDays = days;
        // Add year
        while (currentDays > 365) {
            if (isLeapYear(year) && month == 2 && day == 29) {
                day--;
                currentDays++;
            }
            if ((isLeapYear(year) && month < 3 && day < 29) || (isLeapYear(year + 1) && month > 2)) {
                year++;
                currentDays -= 366;
            } else {
                year++;
                currentDays -= 365;
            }
        }
        int daysToEndOfYear = getDaysTillEnd();
        if (daysToEndOfYear < currentDays) {
            year++;
            month = 1;
            day = 1;
            currentDays = currentDays - daysToEndOfYear - 1;
        }
        // Add month
        // Add to the end of the month
        if (isLeapYear(year) && currentDays > 31) {
            currentDays = currentDays - (LEAP_MONTH[month - 1] - day + 1);
            day = 1;
            month++;
            while (currentDays > 31) {
                currentDays = currentDays - LEAP_MONTH[month - 1];
                month++;
            }
        }
        if (!isLeapYear(year) && currentDays > 31) {
            currentDays = currentDays - (MONTH[month - 1] - day + 1);
            day = 1;
            month++;
            while (currentDays > 31) {
                currentDays = currentDays - MONTH[month - 1];
                month++;
            }
        }
        // Add days
        if (isLeapYear(year)) {
            if (currentDays + day > LEAP_MONTH[month - 1]) {
                day = currentDays - (LEAP_MONTH[month - 1] - day);
                month++;
            } else {
                day += currentDays;
            }
        } else {
            if (currentDays + day>= MONTH[month - 1]) {
                day = currentDays - (MONTH[month - 1] - day);
                month++;
            } else {
                day += currentDays;
            }
        }

    }

    private int getDaysTillEnd() {
        int days = 0;
        int curmonth = month;
        if (isLeapYear(year)) {
            days = days + LEAP_MONTH[month - 1] - day;
            while (curmonth < 12) {
                days += LEAP_MONTH[curmonth];
                curmonth++;
            }
        } else {
            days = days + MONTH[month - 1] - day;
            while (curmonth < 12) {
                days += MONTH[curmonth];
                curmonth++;
            }
        }
        return days;
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

}
