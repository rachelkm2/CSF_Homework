import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTest {
    private static final int RANDOM_TESTS_NUMBER = 100;
    private final int[] fixedArray = {1, 2, 3, 4, 6, 6, 7, 8, 9, 10};
    private final int[] fixedFunkyArray = {-1, 0, 0, 1, 1, 2, 3, 5, 8, 9, 9, 32, 42};
    private final int[] smallArray = {1};

    @Test
    public void testEmpty() throws Exception {
        int[] empty = {};
        assertFalse(Search.binarySearch(empty, 1));
    }

    @Test
    public void testSmall() throws Exception {
        assertTrue(Search.binarySearch(smallArray, 1));
        assertFalse(Search.binarySearch(smallArray, 2));
    }

    @Test
    public void testFixed() throws Exception {
        for (int i : fixedArray) {
            assertTrue(Search.binarySearch(fixedArray, i));
        }

        assertFalse(Search.binarySearch(fixedArray, 11));
        assertFalse(Search.binarySearch(fixedArray, 0));
        assertFalse(Search.binarySearch(fixedArray, -1));
        assertFalse(Search.binarySearch(fixedArray, 5));

    }

    public void testFunky() throws Exception {
        for (int i : fixedFunkyArray) {
            assertTrue(Search.binarySearch(fixedFunkyArray, i));
        }

        assertFalse(Search.binarySearch(fixedFunkyArray, -2));
        assertFalse(Search.binarySearch(fixedFunkyArray, 43));
        assertFalse(Search.binarySearch(fixedFunkyArray, 4));
    }

    public void testRandom() throws Exception {
        int[] array = RandomArray.randomArray();
        Arrays.sort(array);

        for (int i : array) {
            assertTrue(Search.binarySearch(array, i));
        }
    }
}
