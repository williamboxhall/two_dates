package williamboxhall.presentation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import williamboxhall.application.DateParser;
import williamboxhall.domain.Date;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TwoDatesTest {
    private static final String COMBINED_ARGS = "foo";
    private static final String FIRST = "bar";
    private static final String SECOND = "baz";
    private static final String[] DATE_ARGUMENTS = {FIRST, SECOND};
    @Mock
    private PrintStream output;
    @Mock
    private DateParser dateParser;
    @Mock
    private Date first;
    @Mock
    private Date second;
    @Mock
    private DateDifferenceFormatter dateDifferenceFormatter;
    @Mock
    private ArgumentParser argumentParser;

    @Test
    public void interpretsTheSingleArgumentInToTwoSeparateDateArgumentsViaArgumentParser() {
        when(argumentParser.parse(COMBINED_ARGS)).thenReturn(DATE_ARGUMENTS);
        when(dateParser.parse(FIRST)).thenReturn(first);
        new TwoDates(output, argumentParser, dateParser, dateDifferenceFormatter).difference(COMBINED_ARGS);
        verify(argumentParser).parse(COMBINED_ARGS);
    }

    @Test
    public void createsADateForEachOfTheTwoArgumentsViaParser() {
        when(argumentParser.parse(COMBINED_ARGS)).thenReturn(DATE_ARGUMENTS);
        when(dateParser.parse(FIRST)).thenReturn(first);
        new TwoDates(output, argumentParser, dateParser, dateDifferenceFormatter).difference(COMBINED_ARGS);

        verify(dateParser).parse(FIRST);
        verify(dateParser).parse(SECOND);
    }

    @Test
    public void comparesTheTwoDates() {
        when(argumentParser.parse(COMBINED_ARGS)).thenReturn(DATE_ARGUMENTS);
        when(dateParser.parse(FIRST)).thenReturn(first);
        when(dateParser.parse(SECOND)).thenReturn(second);

        new TwoDates(output, argumentParser, dateParser, dateDifferenceFormatter).difference(COMBINED_ARGS);

        verify(first).differenceInDaysFrom(second);
    }

    @Test
    public void printsTheResultViaFormatter() {
        int difference = 42;
        String result = "foo";
        when(argumentParser.parse(COMBINED_ARGS)).thenReturn(DATE_ARGUMENTS);
        when(dateParser.parse(FIRST)).thenReturn(first);
        when(dateParser.parse(SECOND)).thenReturn(second);
        when(first.differenceInDaysFrom(second)).thenReturn(difference);
        when(dateDifferenceFormatter.format(first, second, difference)).thenReturn(result);

        new TwoDates(output, argumentParser, dateParser, dateDifferenceFormatter).difference(COMBINED_ARGS);

        verify(output).println(result);
    }
}
