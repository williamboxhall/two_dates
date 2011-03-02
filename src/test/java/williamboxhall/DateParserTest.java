package williamboxhall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DateParserTest {
    @Test
    public void createsADateWithDayMonthAndYear() {
        String date = "01 02 2003";
        assertThat(new DateParser().parse(date).toString(), is("1-2-2003"));
    }

    @Test
    public void failsWhenDateDoesNotMeetExpectedFormat() {

    }
}
