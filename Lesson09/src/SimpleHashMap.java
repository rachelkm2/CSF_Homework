import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Samples for the SimpleHashMap lab
 */
public class SimpleHashMap {
    private class KeyValueTuple {
        public Object value;
        public String key;
    }

    private class KeyValueList {
        private final LinkedList<KeyValueTuple> values = new LinkedList<KeyValueTuple>();
    }

    private KeyValueList[] dataStore;
    private static final int DEFAULT_CAPACITY = 100;

    public SimpleHashMap() {
        this.dataStore = new KeyValueList[DEFAULT_CAPACITY];
    }

    public Object put(String key, Object value) {
        // TODO:
        // * Get the hash value of the key
        // * Insert the key/value tuple in the linked list at the desired index in the data store
        // * If something in that spot already exists, add it at the end of the linked list
        // * Return the value
        return null;
    }

    public Object get(String key) {
        // TODO:
        // * Get the hash value of the key
        // * Look for the desired key in the LinkedList at the appropriate index
        // * Return the value
        return null;
    }

    public Object remove(String key) {
        // TODO:
        // * Get the hash value of the key
        // * Remove the key/value tuple in the linked list at the appropriate index in the data store
        // * Return the value
        return null;
    }

    /*
     * Debugging Helpers
     */

    /**
     * Prints out each bucket in the tree. Use for debugging purposes.
     */
    public void print() {
        for (int i = 0; i < this.dataStore.length; i++) {
            System.out.println("Bin #" + i);
            for (KeyValueTuple keyValueTuple : this.dataStore[i].values) {
                System.out.println("\tKey: " + keyValueTuple.key + ", Value: " + keyValueTuple.value);
            }
        }
    }

    public Collection<String> keySet() {
        ArrayList<String> keys = new ArrayList<String>();
        for (int i = 0; i < this.dataStore.length; i++) {
            if (this.dataStore[i] != null) {
                for (KeyValueTuple keyValueTuple : this.dataStore[i].values) {
                    keys.add(keyValueTuple.key);
                }
            }
        }
        return keys;
    }

    public Collection<Object> valueSet() {
        ArrayList<Object> values = new ArrayList<Object>();
        for (int i = 0; i < this.dataStore.length; i++) {
            if (this.dataStore[i] != null) {
                for (KeyValueTuple keyValueTuple : this.dataStore[i].values) {
                    values.add(keyValueTuple.value);
                }
            }
        }
        return values;
    }
}
