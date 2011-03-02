package williamboxhall.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateTest {
    private static final Date TODAY = new Date(1, 2, 2003);
    private static final Date TOMORROW = new Date(3, 2, 2003);

    @Test
    public void toStringShouldRenderHyphenatedDate() {
        assertThat(new Date(1, 2, 3).toString(), is("1-2-3"));
    }

    @Test
    public void differentAccordingToDay() {
        assertThat(TODAY.differenceInDaysFrom(TOMORROW), is(2));
    }
}
