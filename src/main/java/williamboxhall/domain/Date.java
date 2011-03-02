package williamboxhall.domain;

public class Date {
    private final int day;
    private final int month;
    private final int year;

    // TODO there is nothing to stop this being created with invalid data by another class
    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int differenceInDaysFrom(Date second) {
        return second.day - this.day;
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d", day, month, year);
    }
}
