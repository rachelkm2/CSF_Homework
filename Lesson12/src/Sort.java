import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Sort {
    private Sort() {
        super();
    }

    /**
     * Sorts given array using the insertionSort technique
     * @param array The array of ints to sort
     */
    public static void insertionSort(int[] array) {
        // TODO: Perform an insertion sort on the array
        // Instructor soln
        for (int i = 0; i < array.length; i++) {
            int valueToInsert = array[i];
            int holeIndex = i;

            while (holeIndex > 0 && valueToInsert < array[holeIndex - 1]) {
                array[holeIndex] = array[holeIndex - 1];
                holeIndex--;
            }
            array[holeIndex] = valueToInsert;
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Sorts given array using a recursiveMergeSort technique
     * @param array The array of ints to sort, ascending
     *
     */
    public static int[] recursiveMergeSort(int[] array) {
        // Instructor sample soln:
        if (array.length <= 1)
            return array;

        int middleIndex = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, middleIndex);
        int[] right = Arrays.copyOfRange(array, middleIndex, array.length);

        left = recursiveMergeSort(left);
        right = recursiveMergeSort(right);

        return merge(left, right);
    }

    /**
     * Helper method that merges two sorted arrays together
     * @param left Left sorted array
     * @param right Right sorted array
     * @return The sorted, merged result
     */
    private static int[] merge(int[] left, int[] right) {
        int[] mergedList = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < mergedList.length; i++) {
            if (leftIndex < left.length && (
                    rightIndex >= right.length ||
                         left[leftIndex] < right[rightIndex])) {
                 mergedList[i] = left[leftIndex];
                 leftIndex++;
            }
            else {
                mergedList[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return mergedList;
    }
}
