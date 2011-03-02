package williamboxhall.presentation;

import williamboxhall.application.DateParser;
import williamboxhall.domain.Date;
import williamboxhall.domain.DateFactory;

import java.io.PrintStream;

public class TwoDates {
    private final PrintStream output;
    private final DateParser dateParser;

    public static void main(String... args) {
        new TwoDates(System.out, new DateParser(new DateFactory())).difference(args);
    }

    public TwoDates(PrintStream out, DateParser dateParser) {
        this.output = out;
        this.dateParser = dateParser;
    }

    public void difference(String... arguments) {
        Date first = dateParser.parse(arguments[0]);
        Date second = dateParser.parse(arguments[1]);
        output.println(first.differenceInDaysFrom(second));
    }
}
