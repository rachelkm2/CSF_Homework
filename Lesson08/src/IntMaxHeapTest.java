import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntMaxHeapTest {
    @Test
    public void testInsertValue() throws Exception {
        IntMaxHeap heap = new IntMaxHeap();
        int[] array = new int[1000];

        Random random = new Random();
        int maxValue = -1;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            heap.insertValue(array[i]);

            int newMaxValue = heap.topValue();
            assertTrue(newMaxValue >= maxValue);
        }
    }

    @Test
    public void testUnderlyingArray() {
        IntMaxHeap heap = new IntMaxHeap();
        heap.insertValue(4);
        heap.insertValue(10);
        heap.insertValue(30);
        heap.insertValue(50);
        heap.insertValue(35);
        heap.insertValue(0);
        heap.insertValue(10);
        assertEquals(heap.underlyingArray(), "50 35 10 4 30 0 10");
    }
}