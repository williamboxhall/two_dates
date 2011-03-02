package williamboxhall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DateParserTest {
    private static final String NULL = null;
    private static final String EMPTY = "";
    private static final String WHITESPACE = " ";
    private static final String NON_SPACE_DELIMITED = "01-02-2003";
    private static final String TWO_NUMBERS = "02 2003";
    private static final String FOUR_NUMBERS = "01 02 03 2003";
    private static final String NON_NUMERIC = "aa bb cccc";
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
        String date = "01 02 2003";
        assertThat(new DateParser().parse(date).toString(), is("1-2-2003"));
    }

    @Test
    public void failsWhenDateStringIsNull() {

    }

    @Test
    public void failsWhenDateStringIsEmpty() {

    }

    @Test
    public void failsWhenDateStringIsBlank() {

    }

    @Test
    public void failsWhenNumbersNotDividedBySpaces() {

    }

    public void failsWhenLessThanThreeNumbers() {
    }
}
