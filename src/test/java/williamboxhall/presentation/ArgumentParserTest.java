package williamboxhall.presentation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ArgumentParserTest {
    @Test(expected = IllegalArgumentException.class)
    public void failsWhenNullArguments() {
        new ArgumentParser().parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenEmptyArguments() {
        new ArgumentParser().parse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenMoreThanOneArgument() {
        new ArgumentParser().parse("foo", "bar");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenNoCommaInArgument() {
        new ArgumentParser().parse("foo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsWhenMoreThanOneCommaInArgument() {
        new ArgumentParser().parse("foo, bar, baz");
    }

    @Test
    public void failureExceptionMessageIsGeneric() {
        try {
            new ArgumentParser().parse(null);
            fail("Expected an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Expected single argument containing two comma-separated values, found 'null'"));
        }
    }

    @Test
    public void parsesToTwoStringsSplitByComma() {
        assertThat(new ArgumentParser().parse("foo, bar"), is(new String[]{"foo", "bar"}));
    }
}
