import org.junit.Test;
import org.junit.Before;

import java.util.Collection;

import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private SimpleHashMap hashMap;

    @Before
    public void setUp()
    {
        this.hashMap = new SimpleHashMap();
    }

    @Test
    public void testPutOne() throws Exception {
        // Tests if put returns the object that it was given
        String key = new String("This is a test!");
        String value = new String("Test!");
        Object o = this.hashMap.put(key, value);
        assertEquals(o, value);
        assertTrue(this.hashMap.keySet().contains(key));
        assertTrue(this.hashMap.valueSet().contains(value));
    }

    @Test
    public void testPutTwo() {
        String keyOne = new String("KeyOne");
        String keyTwo = new String("KeyTwo");
        String valueOne = new String("ValueOne");
        String valueTwo = new String("ValueTwo");
        Object o = this.hashMap.put(keyOne, valueOne);
        assertEquals(o, valueOne);

        o = this.hashMap.put(keyTwo, valueTwo);
        assertEquals(o, valueTwo);

        Collection<String> keySet = this.hashMap.keySet();
        assertTrue(keySet.contains(keyOne));
        assertTrue(keySet.contains(keyTwo));

        Collection<Object> valueSet = this.hashMap.valueSet();
        assertTrue(valueSet.contains(valueOne));
        assertTrue(valueSet.contains(valueTwo));
    }

    @Test
    public void testGet() throws Exception {
        String keyOne = new String("KeyOne");
        String keyTwo = new String("KeyTwo");
        String valueOne = new String("ValueOne");
        String valueTwo = new String("ValueTwo");
        this.hashMap.put(keyOne, valueOne);
        this.hashMap.put(keyTwo, valueTwo);

        assertEquals(this.hashMap.get(keyOne), valueOne);
        assertEquals(this.hashMap.get(keyTwo), valueTwo);
        assertEquals(this.hashMap.get("foo"), null);
    }

    @Test
    public void testRemove() throws Exception {
        String keyOne = new String("KeyOne");
        String keyTwo = new String("KeyTwo");
        String valueOne = new String("ValueOne");
        String valueTwo = new String("ValueTwo");
        this.hashMap.put(keyOne, valueOne);
        this.hashMap.put(keyTwo, valueTwo);

        Object o = this.hashMap.remove(keyOne);
        assertEquals(o, valueOne);
        assertTrue(!this.hashMap.keySet().contains(keyOne));
        assertTrue(!this.hashMap.valueSet().contains(valueOne));
        assertEquals(this.hashMap.valueSet().size(), 1);
        assertEquals(this.hashMap.keySet().size(), 1);

        o = this.hashMap.remove(keyTwo);
        assertEquals(o, valueTwo);
        assertTrue(!this.hashMap.keySet().contains(keyTwo));
        assertTrue(!this.hashMap.valueSet().contains(valueTwo));
        assertEquals(this.hashMap.valueSet().size(), 0);
        assertEquals(this.hashMap.keySet().size(), 0);

        this.hashMap.remove("foo");
        assertEquals(this.hashMap.keySet().size(), 0);
    }
}
