package williamboxhall.presentation.acceptance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import williamboxhall.application.DateParser;
import williamboxhall.domain.DateFactory;
import williamboxhall.presentation.ArgumentParser;
import williamboxhall.presentation.DateDifferenceFormatter;
import williamboxhall.presentation.TwoDates;

import java.io.PrintStream;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TwoDatesEndToEndTest {
    private static final DateDifferenceFormatter FORMATTER = new DateDifferenceFormatter();
    private static final DateDifferenceDataGenerator GENERATOR = new DateDifferenceDataGenerator();
    private static final String DATE = "01 02 2010";
    private static final String DAY_AFTER = "02 02 2010";
    private static final String WEEK_AFTER = "08 02 2010";
    private static final String FEBRUARY_27TH = "27 02 2010";
    private static final String MARCH_2ND = "02 03 2010";
    private static final String MARCH_2ND_2001 = "02 03 2001";
    private static final String FEBRUARY_27TH_2002 = "27 02 2002";
    private static final String JAN_1ST_2001 = "01 01 2001";
    private static final String JAN_1ST_2002 = "01 01 2002";
    private static final String MARCH_1ST_2002 = "01 03 2002";
    @Mock
    private PrintStream output;

    @Test
    public void outputShouldBeCommaSeparatedInputOutputDifference() {
        twoDates().difference(inputFormatted(DATE, DAY_AFTER));
        verify(output).println("01 02 2010, 02 02 2010, 1");
    }

    @Test
    public void identicalDatesShouldHaveZeroDaysDifference() {
        twoDates().difference(inputFormatted(DATE, DATE));
        verify(output).println(outputFormatted(DATE, DATE, 0));
    }

    @Test
    public void datesOneDayApartShouldHaveOneDayDifference() {
        twoDates().difference(inputFormatted(DATE, DAY_AFTER));
        verify(output).println(outputFormatted(DATE, DAY_AFTER, 1));
    }

    @Test
    public void datesMultipleDaysApartShouldHaveMultipleDaysDifference() {
        twoDates().difference(inputFormatted(DATE, WEEK_AFTER));
        verify(output).println(outputFormatted(DATE, WEEK_AFTER, 7));
    }

    @Test
    public void differenceBetweenDatesInDifferentMonthsShouldTakeInToAccountMonthLength() {
        twoDates().difference(inputFormatted(FEBRUARY_27TH, MARCH_2ND));
        verify(output).println(outputFormatted(FEBRUARY_27TH, MARCH_2ND, 3));
    }

    @Test
    public void differenceBetweenTwoYearsShouldBe365() {
        twoDates().difference(inputFormatted(JAN_1ST_2001, JAN_1ST_2002));
        verify(output).println(outputFormatted(JAN_1ST_2001, JAN_1ST_2002, 365));
    }

    @Test
    public void differenceBetweenDatesWithDifferentDaysMonthsAndYearsShouldTakeAllInToConsideration() {
        twoDates().difference(inputFormatted(JAN_1ST_2001, MARCH_1ST_2002));
        verify(output).println(outputFormatted(JAN_1ST_2001, MARCH_1ST_2002, 365 + 31 + 28));
    }

    @Test
    public void differenceShouldAlwaysBeAbsolute() {
        twoDates().difference(inputFormatted(DATE, DAY_AFTER));
        verify(output).println(outputFormatted(DATE, DAY_AFTER, 1));
        twoDates().difference(inputFormatted(DAY_AFTER, DATE));
        verify(output).println(outputFormatted(DAY_AFTER, DATE, 1));
    }

    @Test
    public void failsWhenTwoArgumentsAreNotProvided() {
        try {
            twoDates().difference("foo");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected single argument containing two comma-separated values, found 'foo'"));
        }
    }

    @Test
    public void failsWhenIncorrectDateFormat() {
        try {
            twoDates().difference("foo, bar");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected to be of form '00 00 0000', found 'foo'"));
        }
    }

    @Test
    public void failsWhenYearNotWithinConstraintRange() {
        try {
            twoDates().difference("01 02 2003, 01 02 1000");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected year to fall within range 1900-2010, found '1000'"));
        }
    }

    @Test
    public void differenceShouldBeCorrectFor1000RandomlyGeneratedDates() {
        for (int i = 0; i < 1000; i++) {
            String expectedOutput = GENERATOR.generate();
            String first = firstDateFrom(expectedOutput);
            String second = secondDateFrom(expectedOutput);

            PrintStream output = mock(PrintStream.class);
            twoDates(output).difference(inputFormatted(first, second));
            verify(output).println(expectedOutput);
        }
    }

    private String firstDateFrom(String expectedOutput) {
        return dateAtIndexFrom(0, expectedOutput);
    }

    private String secondDateFrom(String expectedOutput) {
        return dateAtIndexFrom(1, expectedOutput);
    }

    private String dateAtIndexFrom(int index, String expectedOutput) {
        return expectedOutput.split(",")[index].trim();
    }

    private TwoDates twoDates() {
        return twoDates(output);
    }

    private TwoDates twoDates(PrintStream printStream) {
        return new TwoDates(printStream, new ArgumentParser(), new DateParser(new DateFactory()), FORMATTER);
    }

    private String inputFormatted(String first, String second) {
        return format("%s, %s", first, second);
    }

    private String outputFormatted(String first, String second, int difference) {
        return format("%s, %s, %d", first, second, difference);
    }
}
