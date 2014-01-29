import java.util.Arrays;
import java.util.Scanner;

public class LabExercises {

    public static void main(String[] args) {
        performSearch();
    }

    private static void performSearch() {
        while (true) {
            int[] array = RandomArray.randomArray();

            // TODO: Uncomment these when writing your own sort
            //Sort.insertionSort(array);
            //Sort.recursiveMergeSort(array);

            // TODO: Comment this out when you write your own sort
            Arrays.sort(array);

            System.out.println("Array Contents:");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }

            System.out.println("\nSearch for number: ");
            Scanner scanner = new Scanner(System.in);

            if (Search.binarySearch(array, scanner.nextInt()))
                System.out.println("Found it!");
            else
                System.out.println("Didn't find it!");
        }
    }
}
