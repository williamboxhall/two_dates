package williamboxhall.presentation;

import williamboxhall.domain.Date;

public class DateDifferenceFormatter {
    public String format(Date first, Date second, int difference) {
        return String.format("%s, %s, %d", first, second, difference);
    }
}
