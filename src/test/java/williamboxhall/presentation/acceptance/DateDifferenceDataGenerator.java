package williamboxhall.presentation.acceptance;

import williamboxhall.domain.Date;
import williamboxhall.domain.DateFactory;
import williamboxhall.presentation.DateDifferenceFormatter;

import java.util.Calendar;

import static java.lang.Math.round;

public class DateDifferenceDataGenerator {
    public String generate() {
        Date first = randomDate();
        Date second = randomDate();
        int difference = difference(first, second);
        return format(first, second, difference);
    }

    private Date randomDate() {
        return new DateFactory().createWith(randomDay(), randomMonth(), randomNonLeapYear());
    }

    private int difference(Date first, Date second) {
        long firstInMillisSince1900 = millisSince1900(first);
        long secondInMillisSince1900 = millisSince1900(second);
        double difference = firstInMillisSince1900 - secondInMillisSince1900;
        double differenceInDays = round(difference / (24 * 60 * 60 * 1000));
        return Math.abs(Double.valueOf(differenceInDays).intValue());
    }

    private long millisSince1900(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonth().asNumber(), date.getDay());
        return calendar.getTimeInMillis();
    }

    private int randomDay() {
        return randomBetweenInclusive(1, 28);
    }

    private int randomMonth() {
        return randomBetweenInclusive(1, 12);
    }

    private int randomNonLeapYear() {
        return randomBetweenInclusive(2005, 2007);
    }

    private int randomBetweenInclusive(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private String format(Date first, Date second, int difference) {
        return new DateDifferenceFormatter().format(first, second, difference);
    }
}

