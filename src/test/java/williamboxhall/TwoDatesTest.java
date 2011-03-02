package williamboxhall;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwoDatesTest {
    private static final String FIRST = "foo";
    private static final String SECOND = "bar";
    @Mock
    private PrintStream output;
    @Mock
    private DateParser dateParser;

    @Test
    @Ignore
    public void createsADateForEachOfTheTwoArgumentsViaParser() {
        new TwoDates(output).difference(FIRST, SECOND);
        verify(dateParser).parse(FIRST);
        verify(dateParser).parse(SECOND);
    }

    @Test
    @Ignore
    public void comparesTheTwoDates() {

    }

    @Test
    @Ignore
    public void printsTheResult() {
    }
}
