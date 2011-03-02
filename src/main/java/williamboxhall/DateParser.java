package williamboxhall;

import static java.lang.Integer.valueOf;

public class DateParser {
    Date parse(String date) {
        String[] fragments = date.split(" ");
        return new Date(valueOf(fragments[0]), valueOf(fragments[1]), valueOf(fragments[2]));
    }
}
