package williamboxhall.domain;

public class Date {
    private final int day;
    private final Month month;
    private final int year;

    // TODO there is nothing to stop this being created with invalid data by another class
    Date(int day, Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int differenceInDaysFrom(Date second) {
        return month.differenceInDaysFrom(second.month) + (second.day - this.day) + (365 * (second.year - this.year));
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d", day, month.asNumber(), year);
    }
}
