import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SortTest {
    private static final int RANDOM_TESTS_NUMBER = 100;
    private final int[] fixedArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private final int[] fixedFunkyArray = {0, 9, 9, 8, 2, -1, 5, 32, 3, 42, 1, 1, 0};

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1])
                return false;
        }
        return true;
    }

    @Test
    public void testInsertionSort() throws Exception {
        int[] fixedArrayCopy = Arrays.copyOf(this.fixedArray, this.fixedArray.length);
        int[] funkyArrayCopy = Arrays.copyOf(this.fixedFunkyArray, this.fixedFunkyArray.length);
        Sort.insertionSort(fixedArrayCopy);
        assertTrue(isSorted(fixedArrayCopy));

        Sort.insertionSort(funkyArrayCopy);
        assertTrue(isSorted(funkyArrayCopy));
    }

    @Test
    public void testInsertionSortRandom() throws Exception {
        for (int i = 0; i < RANDOM_TESTS_NUMBER; i++) {
            int[] randomArray = RandomArray.randomArray();

            int[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);

            // Sort with a known working sort, and compare to our sort
            Arrays.sort(randomArrayCopy);
            Sort.insertionSort(randomArray);
            assertArrayEquals(randomArray, randomArrayCopy);
        }
    }

    @Test
    public void testRecursiveMergeSort() throws Exception {
        int[] fixedArrayCopy = Arrays.copyOf(this.fixedArray, this.fixedArray.length);
        int[] funkyArrayCopy = Arrays.copyOf(this.fixedFunkyArray, this.fixedFunkyArray.length);
        fixedArrayCopy = Sort.recursiveMergeSort(fixedArrayCopy);
        assertTrue(isSorted(fixedArrayCopy));

        funkyArrayCopy = Sort.recursiveMergeSort(funkyArrayCopy);
        assertTrue(isSorted(funkyArrayCopy));
    }


    @Test
    public void testRecursiveMergeSortRandom() throws Exception {
        for (int i = 0; i < RANDOM_TESTS_NUMBER; i++) {
            int[] randomArray = RandomArray.randomArray();

            int[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);

            // Sort with a known working sort, and compare to our sort
            Arrays.sort(randomArrayCopy);
            randomArray = Sort.recursiveMergeSort(randomArray);
            assertArrayEquals(randomArray, randomArrayCopy);
        }
    }
}
