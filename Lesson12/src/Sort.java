import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Sort {

    /**
     * Sorts given array using the insertionSort technique
     * @param array The array of ints to sort
     */
    public static void insertionSort(int[] array) {
        // TODO: Perform an insertion sort on the array

        if (array.length > 1){
            for (int i = 1; i < array.length; i++){
                for (int j = i - 1; j >= 0; j-- ){
                    if (array[j+1] < array [j]){
                        swap(array, j, j+1);
                    }
                }

            }
        }


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
