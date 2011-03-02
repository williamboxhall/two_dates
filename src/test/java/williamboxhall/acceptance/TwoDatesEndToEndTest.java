package williamboxhall.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import williamboxhall.application.DateParser;
import williamboxhall.domain.DateFactory;
import williamboxhall.presentation.TwoDates;

import java.io.PrintStream;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwoDatesEndToEndTest {
    private static final String DATE = "01 02 2010";
    private static final String DAY_AFTER = "02 02 2010";
    private static final String WEEK_AFTER = "08 02 2010";
    @Mock
    private PrintStream output;

    @Test
    public void identicalDatesShouldHaveZeroDaysDifference() {
        twoDates().difference(DATE, DATE);
        verify(output).println(0);
    }

    @Test
    public void datesOneDayApartShouldHaveOneDayDifference() {
        twoDates().difference(DATE, DAY_AFTER);
        verify(output).println(1);
    }

    @Test
    public void datesMultipleDaysApartShouldHaveMultipleDaysDifference() {
        twoDates().difference(DATE, WEEK_AFTER);
        verify(output).println(7);
    }

    @Test
    public void datesTwoMonthsApartShouldTakeInToAccountMonthLength() {
        twoDates().difference(DATE, DAY_AFTER);
        verify(output).println(1);
    }

    @Test
    public void differenceShouldAlwaysBeModulus() {
        twoDates().difference(DATE, DAY_AFTER);
        verify(output).println(1);
        twoDates().difference(DAY_AFTER, DATE);
        verify(output).println(1);
    }

    @Test
    public void failsWhenTwoArgumentsAreNotProvided() {
        fail("Not yet implemented");
    }

    @Test
    public void failsWhenIncorrectDateFormat() {
        fail("Not yet implemented");
    }

    @Test
    public void failsWhenYearLessThan1900() {
        fail("Not yet implemented");
    }

    @Test
    public void failsWhenYearGreaterThan2010() {
        fail("Not yet implemented");
    }

    private TwoDates twoDates() {
        return new TwoDates(output, new DateParser(new DateFactory()));
    }
}
