package test.acceptance;

import main.TwoDates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwoDatesEndToEndTest {
    @Mock
    private PrintStream output;

    @Test
    public void identicalDatesShouldHaveZeroDaysDifference() {
        new TwoDates(output).difference("01 02 2010", "01 02 2010");
        verify(output).println(0);
    }
}
