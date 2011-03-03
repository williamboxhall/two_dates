package williamboxhall.domain;

public class DateFactory {
    public Date createWith(int day, int month, int year) {
        return new Date(day, Month.fromNumber(month), validatedYear(year));
    }

    private int validatedYear(int year) {
        if (year >= 2010) {
            throw new IllegalArgumentException();
        }
        return year;
    }
}
