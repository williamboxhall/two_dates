package williamboxhall.acceptance;

import williamboxhall.domain.Date;
import williamboxhall.domain.DateFactory;

import java.util.Calendar;

import static java.lang.Math.round;

public class TestDataGenerator {
    public static void main(String... arguments) {
        for (int i = 0; i < 10000; i++) {
            String output = new TestDataGenerator().generate();
            System.out.println(output);
        }
    }

    public String generate() {
        Date first = randomDate();
        Date second = randomDate();
        int difference = difference(first, second);
        return String.format("%s, %s, %s", first.toString(), second.toString(), difference);
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
}

