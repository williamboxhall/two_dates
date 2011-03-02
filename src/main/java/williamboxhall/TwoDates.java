package williamboxhall;

import java.io.PrintStream;

public class TwoDates {
    private final PrintStream output;
    private final DateParser dateParser;

    public static void main(String... args) {
        new TwoDates(System.out, new DateParser()).difference(args);
    }

    public TwoDates(PrintStream out, DateParser dateParser) {
        this.output = out;
        this.dateParser = dateParser;
    }

    public void difference(String... arguments) {
        dateParser.parse(arguments[0]);
        dateParser.parse(arguments[1]);
        output.println(0);
    }
}
