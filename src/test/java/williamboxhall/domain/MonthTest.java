package williamboxhall.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MonthTest {
    @Test
    public void numericalValueIsOrdinalPlusOne() {
        assertThat(Month.MARCH.asNumber(), is(3));
    }

    @Test
    public void resolvableByNumber() {
        assertThat(Month.fromNumber(3), is(Month.MARCH));
    }

    @Test
    public void differenceBetweenIdenticalMonthsShouldBeZero() {
        assertThat(Month.DECEMBER.differenceInDaysFrom(Month.DECEMBER), is(0));
    }

    @Test
    public void differenceShouldBeTakenFromFirstOfEarlierToFirstOfLaterMonth() {
        assertThat(Month.NOVEMBER.differenceInDaysFrom(Month.DECEMBER), is(Month.NOVEMBER.length()));
    }

    @Test
    public void differenceFromMonthShouldBeNegativeIfEarlierInYear() {
        assertThat(Month.DECEMBER.differenceInDaysFrom(Month.NOVEMBER), is(-Month.NOVEMBER.length()));
    }

    @Test
    public void differenceFromMonthShouldBePositiveIfLaterInYear() {
        assertThat(Month.NOVEMBER.differenceInDaysFrom(Month.DECEMBER), is(Month.NOVEMBER.length()));
    }
}
