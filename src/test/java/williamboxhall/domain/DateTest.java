package williamboxhall.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static williamboxhall.domain.Month.FEBRUARY;

public class DateTest {
    private static final Date TODAY = new Date(1, FEBRUARY, 2003);
    private static final Date TOMORROW = new Date(3, FEBRUARY, 2003);
    private static final Date FEBRUARY_27TH = new Date(27, FEBRUARY, 2010);
    private static final Date MARCH_2ND = new Date(2, Month.MARCH, 2010);
    private static final Date FEBRUARY_1ST = new Date(1, Month.FEBRUARY, 2010);
    private static final Date MARCH_1ST = new Date(1, Month.MARCH, 2010);
    private static final Date JAN_1ST_2001 = new Date(1, Month.JANUARY, 2001);
    private static final Date JAN_1ST_2002 = new Date(1, Month.JANUARY, 2002);

    @Test
    public void toStringShouldRenderHyphenatedDate() {
        assertThat(new Date(1, FEBRUARY, 3).toString(), is("1-2-3"));
    }

    @Test
    public void differentAccordingToDay() {
        assertThat(TODAY.differenceInDaysFrom(TOMORROW), is(2));
    }

    @Test
    public void differentAccordingToMonth() {
        assertThat(FEBRUARY_1ST.differenceInDaysFrom(MARCH_1ST), is(28));
    }

    @Test
    public void differentHonouringMonthLength() {
        assertThat(FEBRUARY_27TH.differenceInDaysFrom(MARCH_2ND), is(3));
    }

    @Test
    public void differentAccordingToYear() {
        assertThat(JAN_1ST_2001.differenceInDaysFrom(JAN_1ST_2002), is(365));
    }
}
