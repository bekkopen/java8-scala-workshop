package example;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExampleJavaTest extends TestCase {

    @Test
    public void testDoubleNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> doubled = ExampleJava.doubleNumbers(numbers);
        assertThat("Should double all values in a list", doubled, is(Arrays.asList(2,4,6)));
    }
}
