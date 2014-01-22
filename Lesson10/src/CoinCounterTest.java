import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinCounterTest {
    CoinCounter americanDenominations;
    CoinCounter wonderlandDenominations;
    CoinCounter terribleDenominations;

    @Before
    public void setup() {
        int[] america = {1, 5, 10, 25};
        this.americanDenominations = new CoinCounter(america);

        int[] wonderland = {1, 5, 7, 20};
        this.wonderlandDenominations = new CoinCounter(wonderland);

        int[] terrible = {2, 5, 7, 20};
        this.terribleDenominations = new CoinCounter(terrible);
    }

    @Test
    public void testSimpleNumberOfCoinsRequired() throws Exception {
        assertEquals(0, americanDenominations.simpleNumberOfCoinsRequired(0));
        assertEquals(1, americanDenominations.simpleNumberOfCoinsRequired(1));
        assertEquals(2, americanDenominations.simpleNumberOfCoinsRequired(2));
        assertEquals(3, americanDenominations.simpleNumberOfCoinsRequired(3));
        assertEquals(4, americanDenominations.simpleNumberOfCoinsRequired(4));
        assertEquals(1, americanDenominations.simpleNumberOfCoinsRequired(5));
        assertEquals(2, americanDenominations.simpleNumberOfCoinsRequired(6));
        assertEquals(3, americanDenominations.simpleNumberOfCoinsRequired(7));
        assertEquals(4, americanDenominations.simpleNumberOfCoinsRequired(8));
        assertEquals(5, americanDenominations.simpleNumberOfCoinsRequired(9));
        assertEquals(1, americanDenominations.simpleNumberOfCoinsRequired(10));
        assertEquals(2, americanDenominations.simpleNumberOfCoinsRequired(11));
        assertEquals(3, americanDenominations.simpleNumberOfCoinsRequired(12));
        assertEquals(4, americanDenominations.simpleNumberOfCoinsRequired(13));
        assertEquals(5, americanDenominations.simpleNumberOfCoinsRequired(14));
        assertEquals(2, americanDenominations.simpleNumberOfCoinsRequired(15));
        assertEquals(3, americanDenominations.simpleNumberOfCoinsRequired(16));
        assertEquals(4, americanDenominations.simpleNumberOfCoinsRequired(17));
        assertEquals(5, americanDenominations.simpleNumberOfCoinsRequired(18));
        assertEquals(6, americanDenominations.simpleNumberOfCoinsRequired(19));
        assertEquals(2, americanDenominations.simpleNumberOfCoinsRequired(20));
        assertEquals(5, americanDenominations.simpleNumberOfCoinsRequired(77));
        assertEquals(6, americanDenominations.simpleNumberOfCoinsRequired(82));
        assertEquals(9, americanDenominations.simpleNumberOfCoinsRequired(99));
        assertEquals(4, americanDenominations.simpleNumberOfCoinsRequired(100));
    }

    @Test
    public void testNumberOfCoinsRequired() throws Exception {
        for (int i = 0; i < 100; i++) {
            assertEquals(americanDenominations.numberOfCoinsRequired(i), americanDenominations.simpleNumberOfCoinsRequired(i));
        }
    }

    @Test
    public void testWonderlandDenominations() throws Exception {
        assertEquals(0, wonderlandDenominations.numberOfCoinsRequired(0));
        assertEquals(1, wonderlandDenominations.numberOfCoinsRequired(1));
        assertEquals(2, wonderlandDenominations.numberOfCoinsRequired(2));
        assertEquals(3, wonderlandDenominations.numberOfCoinsRequired(3));
        assertEquals(4, wonderlandDenominations.numberOfCoinsRequired(4));
        assertEquals(1, wonderlandDenominations.numberOfCoinsRequired(5));
        assertEquals(2, wonderlandDenominations.numberOfCoinsRequired(6));
        assertEquals(1, wonderlandDenominations.numberOfCoinsRequired(7));
        assertEquals(2, wonderlandDenominations.numberOfCoinsRequired(8));
        assertEquals(3, wonderlandDenominations.numberOfCoinsRequired(9));
        assertEquals(2, wonderlandDenominations.numberOfCoinsRequired(10));
        assertEquals(3, wonderlandDenominations.numberOfCoinsRequired(11));
        assertEquals(2, wonderlandDenominations.numberOfCoinsRequired(12));
        assertEquals(3, wonderlandDenominations.numberOfCoinsRequired(13));
        assertEquals(2, wonderlandDenominations.numberOfCoinsRequired(14));
        assertEquals(3, wonderlandDenominations.numberOfCoinsRequired(15));
    }

    @Test
    public void testTerribleDenominations() throws Exception {
        assertEquals(0, terribleDenominations.numberOfCoinsRequired(0));
        assertEquals(CoinCounter.CHANGE_NOT_POSSIBLE_FLAG, terribleDenominations.numberOfCoinsRequired(1));
        assertEquals(1, terribleDenominations.numberOfCoinsRequired(2));
        assertEquals(CoinCounter.CHANGE_NOT_POSSIBLE_FLAG, terribleDenominations.numberOfCoinsRequired(3));
        assertEquals(2, terribleDenominations.numberOfCoinsRequired(4));
        assertEquals(1, terribleDenominations.numberOfCoinsRequired(5));
        assertEquals(3, terribleDenominations.numberOfCoinsRequired(6));
        assertEquals(1, terribleDenominations.numberOfCoinsRequired(7));
        assertEquals(4, terribleDenominations.numberOfCoinsRequired(8));
        assertEquals(2, terribleDenominations.numberOfCoinsRequired(9));
        assertEquals(2, terribleDenominations.numberOfCoinsRequired(10));
        assertEquals(3, terribleDenominations.numberOfCoinsRequired(11));
        assertEquals(2, terribleDenominations.numberOfCoinsRequired(12));
        assertEquals(4, terribleDenominations.numberOfCoinsRequired(13));
        assertEquals(2, terribleDenominations.numberOfCoinsRequired(14));
        assertEquals(3, terribleDenominations.numberOfCoinsRequired(15));
    }
}
