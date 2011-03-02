package main;

import java.io.PrintStream;

public class TwoDates {
    private final PrintStream output;

    public static void main(String... args) {
        new TwoDates(System.out).difference(args);
    }

    public TwoDates(PrintStream out) {
        this.output = out;
    }

    public void difference(String... arguments) {
        output.println(0);
        new Foo();
    }
}
