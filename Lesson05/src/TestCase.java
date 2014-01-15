import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestCase {
    private FibSequence fib;

    @Before
    public void setUp()
    {
        this.fib = new FibSequence();
    }

    @Test
    public void testFirstTwo() {
        assertEquals(this.fib.numberAtPosition(1), 0);
        assertEquals(this.fib.numberAtPosition(2), 1);
    }

    @Test
    public void testAFew() {
        for (int i = 1; i < 10; i++) {
            assertEquals(this.fib.numberAtPosition(i) + this.fib.numberAtPosition(i + 1), this.fib.numberAtPosition(i + 2));
        }
    }

    @After
    public void tearDown()
    {}
}
