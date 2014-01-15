import java.util.Scanner;

public class Lab4Samples {

    public static void main(String[] args) {

        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("\nType 'bst' or 'maxheap' to start: ");
        String result = consoleScanner.next();
        if (result.equals("bst")) {
            bst();
        }
        else if (result.equals("maxheap")) {
            maxHeap();
        }
        else {
            System.out.println("Invalid input, bailing");
        }
    }

    public static void bst() {
        IntBST bst = new IntBST();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nType 'insert {number}' or 'find {number} to insert/find into the BST: ");
            String command = consoleScanner.next();
            int value = consoleScanner.nextInt();

            if (command.equals("insert")) {
                bst.insertValue(value);
                bst.bfsRepresentation();
            }
            else if (command.equals("find")) {
                System.out.println("It is " + bst.search(value) + " that " + value + " exists in the BST.");
            }
        }
    }

    public static void maxHeap() {
        IntMaxHeap maxHeap = new IntMaxHeap();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nEnter a number to be entered in the maxheap: ");
            int newInt = consoleScanner.nextInt();

            maxHeap.insertValue(newInt);
            System.out.println("Top value in heap: " + maxHeap.topValue());
            System.out.println("Heap underlying array: " + maxHeap.underlyingArray());
        }
    }
}