package williamboxhall;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwoDatesTest {
    private static final String FIRST = "foo";
    private static final String SECOND = "bar";
    @Mock
    private PrintStream output;
    @Mock
    private DateParser dateParser;
    @Mock
    private Date first;
    @Mock
    private Date second;

    @Test
    public void createsADateForEachOfTheTwoArgumentsViaParser() {
        when(dateParser.parse(FIRST)).thenReturn(first);
        new TwoDates(output, dateParser).difference(FIRST, SECOND);
        verify(dateParser).parse(FIRST);
        verify(dateParser).parse(SECOND);
    }

    @Test
    public void comparesTheTwoDates() {
        when(dateParser.parse(FIRST)).thenReturn(first);
        when(dateParser.parse(SECOND)).thenReturn(second);

        new TwoDates(output, dateParser).difference(FIRST, SECOND);

        verify(first).differenceInDaysFrom(second);
    }

    @Test
    @Ignore
    public void printsTheResult() {
        
    }
}
