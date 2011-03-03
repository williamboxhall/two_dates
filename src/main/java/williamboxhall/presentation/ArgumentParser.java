package williamboxhall.presentation;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class ArgumentParser {
    public String[] parse(String... arguments) {
        return split(validated(arguments));
    }

    private String validated(String[] arguments) {
        if (isNull(arguments) || !isSingleton(arguments) || !hasOneComma(arguments[0])) {
            throw new IllegalArgumentException(format("Expected single argument containing two comma-separated values, found '%s'", arguments));
        }
        return arguments[0];
    }

    private boolean isNull(String[] strings) {
        return strings == null;
    }

    private boolean isSingleton(String[] arguments) {
        return arguments.length == 1;
    }

    private boolean hasOneComma(String argument) {
        return argument.split(",").length == 2;
    }

    private String[] split(String argument) {
        return eachTrimmed(argument.split(","));
    }

    private String[] eachTrimmed(String... strings) {
        List<String> trimmed = new ArrayList<String>(strings.length);
        for (String string : strings) {
            trimmed.add(string.trim());
        }
        return trimmed.toArray(new String[strings.length]);
    }
}
