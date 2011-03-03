package williamboxhall.domain;

import static java.lang.String.format;
import static williamboxhall.domain.Month.fromNumber;

public class DateFactory {
    public Date createWith(int day, int numbericalMonth, int year) {
        Month month = fromNumber(validatedMonth(numbericalMonth));
        return new Date(validatedDayInMonth(day, month), month, validatedYear(year));
    }

    private int validatedMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(format("Expected month to fall within range 1-12, found '%s'", month));
        }
        return month;
    }

    private int validatedDayInMonth(int day, Month month) {
         if (day < 1 || day > month.length()) {
             throw new IllegalArgumentException(format("Expected day to fall within the range specified by month %s " +
                     "(1-%d), found '%d'", month, month.length(), day));
         }
        return day;
    }

    private int validatedYear(int year) {
        if (year < 1900 || year > 2010) {
            throw new IllegalArgumentException(format("Expected year to fall within range 1900-2010, found '%s'", year));
        }
        return year;
    }
}
