package williamboxhall.application;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import williamboxhall.domain.Date;
import williamboxhall.domain.DateFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Theories.class)
public class DateParserTest {
    private static final String NULL = null;
    private static final String EMPTY = "";
    private static final String WHITESPACE = " ";
    private static final String NON_SPACE_DELIMITED = "00-00-0000";
    private static final String TWO_NUMBERS = "00 0000";
    private static final String FOUR_NUMBERS = "00 00 00 0000";
    private static final String NON_NUMERIC = "aa bb cccc";
    private static final String SHORT_DAY = "0 00 0000";
    private static final String LONG_DAY = "000 00 0000";
    private static final String SHORT_MONTH = "00 0 0000";
    private static final String LONG_MONTH = "00 000 0000";
    private static final String SHORT_YEAR = "00 00 000";
    private static final String LONG_YEAR = "00 00 00000";
    @DataPoints
    @SuppressWarnings("unused")
    public static final String[] INVALID_ACCORDING_TO_FORMAT_DATES = {NULL, EMPTY, WHITESPACE, NON_SPACE_DELIMITED,
            TWO_NUMBERS, FOUR_NUMBERS, NON_NUMERIC, SHORT_DAY, LONG_DAY, SHORT_MONTH, LONG_MONTH, SHORT_YEAR, LONG_YEAR};

    @Test
    public void createsADateWithDayMonthAndYear() {
        String dateString = "01 02 2003";
        Date date = mock(Date.class);
        DateFactory dateFactory = mock(DateFactory.class);
        when(dateFactory.createWith(1, 2, 2003)).thenReturn(date);
        assertThat(new DateParser(dateFactory).parse(dateString), is(date));
    }

    @Theory
    public void failsWhenDateStringIsInvalidAccordingToRequiredFormat(String invalid) {
        try {
            new DateParser(mock(DateFactory.class)).parse(invalid);
            fail(String.format("'%s' should have failed to parse", invalid));
        } catch (IllegalArgumentException e) {
            // expected. It's a shame you can't use @Test(expected = IllegalArgumentException.class) in
            // conjunction with @Theory
        }
    }

    @Test
    public void failureExceptionMessageIsGeneric() {
        try {
            new DateParser(null).parse(null);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected to be of form '00 00 0000', found 'null'"));
        }
    }
}
