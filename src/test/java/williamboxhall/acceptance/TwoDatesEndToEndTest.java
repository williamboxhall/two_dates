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
    private static final String FEBRUARY_27TH = "27 02 2010";
    private static final String MARCH_2ND = "02 03 2010";
    private static final String MARCH_2ND_2001 = "02 03 2001";
    private static final String FEBRUARY_27TH_2002 = "27 02 2002";
    private static final String JAN_1ST_2001 = "01 01 2001";
    private static final String JAN_1ST_2002 = "01 01 2002";
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
    public void differenceBetweenDatesInDifferentMonthsShouldTakeInToAccountMonthLength() {
        twoDates().difference(FEBRUARY_27TH, MARCH_2ND);
        verify(output).println(3);
    }

    @Test
    public void differenceBetweenTwoYearsShouldBe365() {
        twoDates().difference(JAN_1ST_2001, JAN_1ST_2002);
        verify(output).println(365);
    }

    @Test
    public void differenceBetweenDatesWithDifferentDaysMonthsAndYearsShouldTakeAllInToConsideration() {
        //twoDates().difference(JAN_31ST_2001, MARCH_1ST_2002);
        //verify(output).println(3);
    }

    @Test
    public void differenceShouldAlwaysBeAbsolute() {
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
