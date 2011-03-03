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
        if (isNull(date) || !isCorrectlyFormatted(date)) {
            throw new IllegalArgumentException(String.format("Expected to be of form '00 00 0000', found '%s'", date));
        }
        return date;
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private boolean isCorrectlyFormatted(String date) {
        return CORRECT_FORMAT.matcher(date).matches();
    }
}
