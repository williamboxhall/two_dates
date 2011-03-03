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

    @Test
    public void passesWhenStartOfYear1900() {
        assertThat(new DateFactory().createWith(1, 1, 1900).toString(), is("01 01 1900"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenYearMoreThanThan2010() {
        new DateFactory().createWith(1, 2, 2200);
    }

    @Test
    public void passesWhenEndOfYear2010() {
        assertThat(new DateFactory().createWith(31, 12, 2010).toString(), is("31 12 2010"));
    }

    @Test
    public void failureExceptionMessageIsGeneric() {
        try {
            new DateFactory().createWith(1, 2, 1800);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected year to fall within range 1900-2010, found '1800'"));
        }
    }
}
