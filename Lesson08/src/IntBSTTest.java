import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntBSTTest {
    @Test
    public void testInsertValue() throws Exception {
        IntBST bst = new IntBST();
        assertEquals(bst.bfsRepresentation(), "");

        bst.insertValue(5);
        assertEquals(bst.bfsRepresentation(), "5");
        bst.insertValue(10);
        assertEquals(bst.bfsRepresentation(), "5 10");
        bst.insertValue(1);
        assertEquals(bst.bfsRepresentation(), "5 1 10");
        bst.insertValue(2);
        assertEquals(bst.bfsRepresentation(), "5 1 10 2");
        bst.insertValue(7);
        assertEquals(bst.bfsRepresentation(), "5 1 10 2 7");
        bst.insertValue(10);
        assertEquals(bst.bfsRepresentation(), "5 1 10 2 7");
        bst.insertValue(11);
        assertEquals(bst.bfsRepresentation(), "5 1 10 2 7 11");
        bst.insertValue(0);
        assertEquals(bst.bfsRepresentation(), "5 1 10 0 2 7 11");
        bst.insertValue(9);
        assertEquals(bst.bfsRepresentation(), "5 1 10 0 2 7 11 9");
    }

    @Test
    public void testSearch() throws Exception {
        IntBST bst = new IntBST();

        int[] array = new int[10];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            bst.insertValue(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            assertTrue(bst.search(array[i]));
        }

        for (int i = 101; i < 200; i++) {
            assertFalse(bst.search(i));
        }
    }
}