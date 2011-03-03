package williamboxhall.domain;

import static java.lang.String.format;

public class DateFactory {
    public Date createWith(int day, int month, int year) {
        return new Date(day, Month.fromNumber(month), validatedYear(year));
    }

    private int validatedYear(int year) {
        if (year < 1900 || year > 2010 ) {
            throw new IllegalArgumentException(format("Expected year to fall within range 1900-2010, found '%s'", year));
        }
        return year;
    }
}
