package williamboxhall.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateFactoryTest {
    // For now, not using these. The requirements don't actually state that the date needs to be valid,
    // apart from the YEAR.
    private static final String YEAR_BEFORE_1900 = "01 02 1899";
    private static final String YEAR_AFTER_2010 = "01 02 2011";
    private static final String LONG_JANUARY = "32 01 2011";
    private static final String LONG_FEBRUARY = "30 02 2011";
    private static final String LONG_MARCH = "32 03 2011";
    private static final String LONG_APRIL = "31 04 2011";
    private static final String LONG_MAY = "32 02 2011";
    private static final String LONG_JUNE = "31 02 2011";
    private static final String LONG_JULY = "32 02 2011";
    private static final String LONG_AUGUST = "32 02 2011";
    private static final String LONG_SEPTEMBER = "31 02 2011";
    private static final String LONG_OCTOBER = "32 02 2011";
    private static final String LONG_NOVEMBER = "31 02 2011";
    private static final String LONG_DECEMBER = "32 02 2011";

    @Test
    public void createsADateWithDayMonthAndYear() {
        assertThat(new DateFactory().createWith(1, 2, 2003).toString(), is("01 02 2003"));
    }
}
