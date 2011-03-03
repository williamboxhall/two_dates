package williamboxhall.domain;

import static java.lang.String.format;

public class DateFactory {
    public Date createWith(int day, int month, int year) {
        return new Date(day, Month.fromNumber(validatedMonth(month)), validatedYear(year));
    }

    private int validatedMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(format("Expected month to fall within range 1-12, found '%s'", month));
        }
        return month;
    }

    private int validatedYear(int year) {
        if (year < 1900 || year > 2010) {
            throw new IllegalArgumentException(format("Expected year to fall within range 1900-2010, found '%s'", year));
        }
        return year;
    }
}
