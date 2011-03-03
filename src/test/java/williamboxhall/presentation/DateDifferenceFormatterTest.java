package williamboxhall.presentation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import williamboxhall.domain.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DateDifferenceFormatterTest {
    private static final int DIFFERENCE = 66;
    @Mock
    private Date first;
    @Mock
    private Date second;

    @Test
    public void formatsToCommaSeparatedString() {
        assertThat(new DateDifferenceFormatter().format(first, second, DIFFERENCE), is("first, second, 66"));
    }
}
