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
        assertEquals(0, americanDenominations.recursiveNumberOfCoinsRequired(0));
        assertEquals(1, americanDenominations.recursiveNumberOfCoinsRequired(1));
        assertEquals(2, americanDenominations.recursiveNumberOfCoinsRequired(2));
        assertEquals(3, americanDenominations.recursiveNumberOfCoinsRequired(3));
        assertEquals(4, americanDenominations.recursiveNumberOfCoinsRequired(4));
        assertEquals(1, americanDenominations.recursiveNumberOfCoinsRequired(5));
        assertEquals(2, americanDenominations.recursiveNumberOfCoinsRequired(6));
        assertEquals(3, americanDenominations.recursiveNumberOfCoinsRequired(7));
        assertEquals(4, americanDenominations.recursiveNumberOfCoinsRequired(8));
        assertEquals(5, americanDenominations.recursiveNumberOfCoinsRequired(9));
        assertEquals(1, americanDenominations.recursiveNumberOfCoinsRequired(10));
        assertEquals(2, americanDenominations.recursiveNumberOfCoinsRequired(11));
        assertEquals(3, americanDenominations.recursiveNumberOfCoinsRequired(12));
        assertEquals(4, americanDenominations.recursiveNumberOfCoinsRequired(13));
        assertEquals(5, americanDenominations.recursiveNumberOfCoinsRequired(14));
        assertEquals(2, americanDenominations.recursiveNumberOfCoinsRequired(15));
        assertEquals(3, americanDenominations.recursiveNumberOfCoinsRequired(16));
        assertEquals(4, americanDenominations.recursiveNumberOfCoinsRequired(17));
        assertEquals(5, americanDenominations.recursiveNumberOfCoinsRequired(18));
        assertEquals(6, americanDenominations.recursiveNumberOfCoinsRequired(19));
        assertEquals(2, americanDenominations.recursiveNumberOfCoinsRequired(20));
        //assertEquals(5, americanDenominations.recursiveNumberOfCoinsRequired(77));
        //assertEquals(6, americanDenominations.recursiveNumberOfCoinsRequired(82));
        //assertEquals(9, americanDenominations.recursiveNumberOfCoinsRequired(99));
        //assertEquals(4, americanDenominations.recursiveNumberOfCoinsRequired(100));
    }

    @Test
    public void testWonderlandDenominations() throws Exception {
        assertEquals(0, wonderlandDenominations.recursiveNumberOfCoinsRequired(0));
        assertEquals(1, wonderlandDenominations.recursiveNumberOfCoinsRequired(1));
        assertEquals(2, wonderlandDenominations.recursiveNumberOfCoinsRequired(2));
        assertEquals(3, wonderlandDenominations.recursiveNumberOfCoinsRequired(3));
        assertEquals(4, wonderlandDenominations.recursiveNumberOfCoinsRequired(4));
        assertEquals(1, wonderlandDenominations.recursiveNumberOfCoinsRequired(5));
        assertEquals(2, wonderlandDenominations.recursiveNumberOfCoinsRequired(6));
        assertEquals(1, wonderlandDenominations.recursiveNumberOfCoinsRequired(7));
        assertEquals(2, wonderlandDenominations.recursiveNumberOfCoinsRequired(8));
        assertEquals(3, wonderlandDenominations.recursiveNumberOfCoinsRequired(9));
        assertEquals(2, wonderlandDenominations.recursiveNumberOfCoinsRequired(10));
        assertEquals(3, wonderlandDenominations.recursiveNumberOfCoinsRequired(11));
        assertEquals(2, wonderlandDenominations.recursiveNumberOfCoinsRequired(12));
        assertEquals(3, wonderlandDenominations.recursiveNumberOfCoinsRequired(13));
        assertEquals(2, wonderlandDenominations.recursiveNumberOfCoinsRequired(14));
        assertEquals(3, wonderlandDenominations.recursiveNumberOfCoinsRequired(15));
    }

    @Test
    public void testTerribleDenominations() throws Exception {
        assertEquals(0, terribleDenominations.recursiveNumberOfCoinsRequired(0));
        assertEquals(CoinCounter.CHANGE_NOT_POSSIBLE_FLAG, terribleDenominations.recursiveNumberOfCoinsRequired(1));
        assertEquals(1, terribleDenominations.recursiveNumberOfCoinsRequired(2));
        assertEquals(CoinCounter.CHANGE_NOT_POSSIBLE_FLAG, terribleDenominations.recursiveNumberOfCoinsRequired(3));
        assertEquals(2, terribleDenominations.recursiveNumberOfCoinsRequired(4));
        assertEquals(1, terribleDenominations.recursiveNumberOfCoinsRequired(5));
        assertEquals(3, terribleDenominations.recursiveNumberOfCoinsRequired(6));
        assertEquals(1, terribleDenominations.recursiveNumberOfCoinsRequired(7));
        assertEquals(4, terribleDenominations.recursiveNumberOfCoinsRequired(8));
        assertEquals(2, terribleDenominations.recursiveNumberOfCoinsRequired(9));
        assertEquals(2, terribleDenominations.recursiveNumberOfCoinsRequired(10));
        assertEquals(3, terribleDenominations.recursiveNumberOfCoinsRequired(11));
        assertEquals(2, terribleDenominations.recursiveNumberOfCoinsRequired(12));
        assertEquals(4, terribleDenominations.recursiveNumberOfCoinsRequired(13));
        assertEquals(2, terribleDenominations.recursiveNumberOfCoinsRequired(14));
        assertEquals(3, terribleDenominations.recursiveNumberOfCoinsRequired(15));
    }
}
