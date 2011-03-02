package williamboxhall.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateTest {
    @Test
    public void toStringShouldRenderHyphenatedDate() {
        assertThat(new Date(1, 2, 3).toString(), is("1-2-3"));
    }
}
