package williamboxhall.acceptance;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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
        new TwoDates(output).difference(DATE, DATE);
        verify(output).println(0);
    }

    @Test
    @Ignore
    public void datesOneDayApartShouldHaveOneDayDifference() {
        new TwoDates(output).difference(DATE, DAY_AFTER);
        verify(output).println(1);
    }

    @Test
    @Ignore
    public void differenceShouldAlwaysBeModulus() {
        new TwoDates(output).difference(DATE, DAY_AFTER);
        verify(output).println(1);
        new TwoDates(output).difference(DAY_AFTER, DATE);
        verify(output).println(1);
    }
}
