package williamboxhall.presentation;

import williamboxhall.application.DateParser;
import williamboxhall.domain.Date;
import williamboxhall.domain.DateFactory;

import java.io.PrintStream;

public class TwoDates {
    private final PrintStream output;
    private final DateParser dateParser;
    private final DateDifferenceFormatter dateDifferenceFormatter;

    public static void main(String... args) {
        new TwoDates(System.out, new DateParser(new DateFactory()), new DateDifferenceFormatter()).difference(args);
    }

    public TwoDates(PrintStream out, DateParser dateParser, DateDifferenceFormatter dateDifferenceFormatter) {
        this.output = out;
        this.dateParser = dateParser;
        this.dateDifferenceFormatter = dateDifferenceFormatter;
    }

    public void difference(String... arguments) {
        Date first = dateParser.parse(arguments[0]);
        Date second = dateParser.parse(arguments[1]);
        int difference = first.differenceInDaysFrom(second);
        output.println(dateDifferenceFormatter.format(first, second, difference));
    }
}
