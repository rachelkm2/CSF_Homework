import java.util.Random;

public class RandomArray {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 100;
    private static final int RANDOM_ARRAY_SIZE = 50;

    private RandomArray() {
        super();
    }

    /**
     * Returns a randomly generated array of ints of length RANDOM_ARRAY_SIZE
     * @return An array of random ints, between RANDOM_NUMBER_MIN and RANDOM_NUMBER_MAX, of length RANDOM_ARRAY_SIZE
     */
    public static int[] randomArray() {
        int[] array = new int[RANDOM_ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(RANDOM_NUMBER_MAX - RANDOM_NUMBER_MIN + 1) + RANDOM_NUMBER_MIN;
        }

        return array;
    }
}
