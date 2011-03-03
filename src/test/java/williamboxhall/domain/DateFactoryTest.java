package williamboxhall.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class DateFactoryTest {
    @Test
    public void createsADateWithDayMonthAndYear() {
        assertThat(new DateFactory().createWith(1, 2, 2003).toString(), is("01 02 2003"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenYearLessThan1900() {
        new DateFactory().createWith(1, 2, 1800);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenYearMoreThanThan2010() {
        new DateFactory().createWith(1, 2, 2200);
    }

    @Test
    public void failureExceptionMessageIsGeneric() {
        try {
            new DateFactory().createWith(1, 2, 1800);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected year to be in range 1900-2010, found '1800'"));
        }
    }
}
