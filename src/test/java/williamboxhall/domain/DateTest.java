package williamboxhall.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static williamboxhall.domain.Month.FEBRUARY;

public class DateTest {
    private static final Date TODAY = new Date(1, FEBRUARY, 2003);
    private static final Date TOMORROW = new Date(2, FEBRUARY, 2003);
    private static final Date FEB_27TH_2010 = new Date(27, FEBRUARY, 2010);
    private static final Date MARCH_2ND = new Date(2, Month.MARCH, 2010);
    private static final Date FEBRUARY_1ST = new Date(1, Month.FEBRUARY, 2010);
    private static final Date MARCH_1ST = new Date(1, Month.MARCH, 2010);
    private static final Date JAN_1ST_2001 = new Date(1, Month.JANUARY, 2001);
    private static final Date JAN_1ST_2002 = new Date(1, Month.JANUARY, 2002);
    private static final Date NOV_1ST_2001 = new Date(1, Month.NOVEMBER, 2001);
    private static final Date DEC_31ST_2001 = new Date(31, Month.DECEMBER, 2001);

    @Test
    public void differentAccordingToDay() {
        assertThat(TODAY.differenceInDaysFrom(TOMORROW), is(1));
    }

    @Test
    public void differentAccordingToMonth() {
        assertThat(FEBRUARY_1ST.differenceInDaysFrom(MARCH_1ST), is(28));
    }

    @Test
    public void differentHonouringMonthLength() {
        assertThat(FEB_27TH_2010.differenceInDaysFrom(MARCH_2ND), is(3));
    }

    @Test
    public void differentAccordingToYear() {
        assertThat(JAN_1ST_2001.differenceInDaysFrom(JAN_1ST_2002), is(365));
    }

    @Test
    public void toStringShouldRenderSpaceDelimitedDate() {
        assertThat(DEC_31ST_2001.toString(), is("31 12 2001"));
    }

    @Test
    public void toStringShouldLeftPadDaysOfOneDigitWithLeadingZero() {
        assertThat(NOV_1ST_2001.toString(), is("01 11 2001"));
    }

    @Test
    public void toStringShouldLeftPadMonthsOfOneDigitWithLeadingZero() {
        assertThat(FEB_27TH_2010.toString(), is("27 02 2010"));
    }

    @Test
    public void differenceIsAbsolute() {
         assertThat(TODAY.differenceInDaysFrom(TOMORROW), is(1));
         assertThat(TOMORROW.differenceInDaysFrom(TODAY), is(1));
    }
}
