package williamboxhall.domain;

import static java.lang.Math.abs;

public class Date {
    private final int day;
    private final Month month;
    private final int year;

    Date(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int differenceInDaysFrom(Date second) {
        return abs(dayDifference(second) + monthDifference(second) + yearDifference(second));
    }

    private int dayDifference(Date second) {
        return (second.day - this.day);
    }

    private int monthDifference(Date second) {
        return month.differenceInDaysFrom(second.month);
    }

    private int yearDifference(Date second) {
        return (365 * (second.year - this.year));
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", leftPad(day), leftPad(month.asNumber()), year);
    }

    public int getDay() {
        return day;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    private String leftPad(int value) {
        return String.format((value < 10) ? "0%d" : "%d", value);
    }
}
