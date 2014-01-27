import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class FibSequenceTest {
    @Test
    public void testFibNumber() throws Exception {
        FibSequence fib = new FibSequence();
        assertEquals(0, fib.fibNumber(0));
        assertEquals(1, fib.fibNumber(1));
        assertEquals(1, fib.fibNumber(2));
        assertEquals(2, fib.fibNumber(3));
        assertEquals(3, fib.fibNumber(4));
        assertEquals(5, fib.fibNumber(5));
        assertEquals(8, fib.fibNumber(6));
        assertEquals(13, fib.fibNumber(7));
        assertEquals(21, fib.fibNumber(8));
        assertEquals(34, fib.fibNumber(9));
    }
}
