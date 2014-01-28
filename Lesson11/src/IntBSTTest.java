import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class IntBSTTest {
    private IntBST bst;
    private int[] numbers = {5, 1, 3, 2, 10, 7, 9, 8, 0};

    @Before
    public void setup() {
        bst = new IntBST();
        for (int i : numbers) {
            bst.insertValue(i);
        }
    }

    @Test
    public void testToBFSString() throws Exception {
        assertEquals(bst.toBFSString(),"5 1 10 0 3 7 2 9 8");
    }

    @Test
    public void testToPreorderString() throws Exception {
        assertEquals(bst.toPreorderString().trim(),"5 1 0 3 2 10 7 9 8");
    }

    @Test
    public void testToInorderString() throws Exception {
        assertEquals(bst.toInorderString().trim(),"0 1 2 3 5 7 8 9 10");
    }

    @Test
    public void testValuesGreaterThan() throws Exception {
        List<Integer> list = bst.valuesGreaterThan(5);
        for (int i : numbers) {
            if (i > 5) {
                assertTrue(list.contains(i));
            }
            else {
                assertFalse(list.contains(i));
            }
        }

        list = bst.valuesGreaterThan(10);
        for (int i : numbers) {
            if (i > 10) {
                assertTrue(list.contains(i));
            }
            else {
                assertFalse(list.contains(i));
            }
        }

        list = bst.valuesGreaterThan(2);
        for (int i : numbers) {
            if (i > 2) {
                assertTrue(list.contains(i));
            }
            else {
                assertFalse(list.contains(i));
            }
        }
    }
}
