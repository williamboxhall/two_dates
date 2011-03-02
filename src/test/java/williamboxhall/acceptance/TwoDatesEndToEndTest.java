package williamboxhall.acceptance;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import williamboxhall.DateParser;
import williamboxhall.TwoDates;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwoDatesEndToEndTest {
    private static final String DATE = "01 02 2010";
    private static final String DAY_AFTER = "02 02 2010";
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
    @Ignore
    public void differenceShouldAlwaysBeModulus() {
        twoDates().difference(DATE, DAY_AFTER);
        verify(output).println(1);
        twoDates().difference(DAY_AFTER, DATE);
        verify(output).println(1);
    }

    @Test
    @Ignore
    public void failsWhenTwoArgumentsAreNotProvided() {
    }

    private TwoDates twoDates() {
        return new TwoDates(output, new DateParser());
    }
}
