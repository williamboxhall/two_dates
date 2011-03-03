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

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenMonthLessThanOne() {
        new DateFactory().createWith(1, 0, 2010).toString();
    }

    @Test
    public void passesWhenMonthIsOne() {
        assertThat(new DateFactory().createWith(31, 1, 2010).toString(), is("31 01 2010"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenMonthMoreThanThirteen() {
        new DateFactory().createWith(1, 0, 2010).toString();
    }

    @Test
    public void passesWhenMonthIsTwelve() {
        assertThat(new DateFactory().createWith(31, 12, 2010).toString(), is("31 12 2010"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenDayLessThanOne() {
        new DateFactory().createWith(0, 1, 2010).toString();
    }

    @Test
    public void passesWhenFirstOfMonth() {
         assertThat(new DateFactory().createWith(1, 12, 2010).toString(), is("01 12 2010"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenDayLargerThanAppropriateGivenMonthOne() {
        new DateFactory().createWith(31, 2, 2010).toString();
    }

    @Test
    public void passesWhenLastOfMonth() {
         assertThat(new DateFactory().createWith(28, 2, 2010).toString(), is("28 02 2010"));
    }

    @Test
    public void yearFailureExceptionMessageIsGeneric() {
        try {
            new DateFactory().createWith(1, 2, 1800);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected year to fall within range 1900-2010, found '1800'"));
        }
    }

    @Test
    public void monthFailureExceptionMessageIsGeneric() {
        try {
            new DateFactory().createWith(1, 0, 2010);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected month to fall within range 1-12, found '0'"));
        }
    }


    @Test
    public void dayFailureExceptionMessageIsGeneric() {
        try {
            new DateFactory().createWith(31, 2, 2010);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected day to fall within the range specified by month FEBRUARY (1-28), " +
                    "found '31'"));
        }
    }
}
