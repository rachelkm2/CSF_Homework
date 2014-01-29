import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Sort {

    /**
     * Sorts given array using the insertionSort technique
     * @param array The array of ints to sort
     */
    public static void insertionSort(int[] array) {
        // TODO: Perform an insertion sort on the array
        throw new NotImplementedException();
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Helper method that merges two sorted arrays together
     * @param left Left sorted array
     * @param right Right sorted array
     * @return The sorted, merged result
     */
    private static int[] merge(int[] left, int[] right) {
        // TODO: Write a helper method which merges two already-sorted arrays into a combined, sorted array
        throw new NotImplementedException();
    }

    /**
     * Sorts given array using a recursiveMergeSort technique
     * @param array The array of ints to sort, ascending
     *
     */
    public static int[] recursiveMergeSort(int[] array) {
        // TODO: Implement merge sort
        throw new NotImplementedException();
    }
}
