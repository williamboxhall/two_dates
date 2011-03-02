package williamboxhall.application;

import williamboxhall.domain.Date;
import williamboxhall.domain.DateFactory;

import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;

public class DateParser {
    private static final Pattern CORRECT_FORMAT = Pattern.compile("\\d\\d \\d\\d \\d\\d\\d\\d");
    private final DateFactory dateFactory;

    public DateParser(DateFactory dateFactory) {
        this.dateFactory = dateFactory;
    }

    public Date parse(String date) {
        String[] fragments = validated(date).split(" ");
        return dateFactory.createWith(valueOf(fragments[0]), valueOf(fragments[1]), valueOf(fragments[2]));
    }

    private String validated(String date) {
        if (isNull(date) || isNotCorrectlyFormatted(date)) {
            throw new IllegalArgumentException("date");
        }
        return date;
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private boolean isNotCorrectlyFormatted(String date) {
        return !CORRECT_FORMAT.matcher(date).matches();
    }
}
