import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class IntBST {
    private IntNode rootNode;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntBST bst = new IntBST();
        while(true) {
            System.out.print("print, gt or insert: ");
            String result = scanner.next();

            if (result.equals("print")) {
                System.out.println("BFS: " + bst.toBFSString());
                System.out.println("DFS: " + bst.toPreorderString());
            } else {
                System.out.print("\nvalue? ");
                int value = scanner.nextInt();

                if (result.equals("gt")) {
                    System.out.println(bst.valuesGreaterThan(value));
                } else if (result.equals("insert")) {
                    bst.insertValue(value);
                }
            }
        }
    }

    public String toBFSString() {
        // TODO: Implement a BFS of a tree using a queue
        return null;
    }

    public String toPreorderString() {
        // TODO: Return a preorder traversal of a tree using recursion. Values of nodes are space-delimited
        // e.g. "5 1 10"

        return null;
    }

    public String toInorderString() {
        // TODO: Return a preorder traversal of a tree using recursion. Values of nodes are space-delimited
        // e.g. "1 5 10"

        return null;
    }

    public List<Integer> valuesGreaterThan(int n) {
        // TODO: Return values that are greater than or equal to n.
        // Do this with the lowest computational complexity you can manage.
    }

    public void insertValue(int value) {
        if (rootNode == null) {
            rootNode = new IntNode(value);
        }
        else {
            IntNode currentNode = rootNode;

            while (currentNode.getValue() != value) {
                if (value > currentNode.getValue()) { // Right child path
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(new IntNode(value));
                    }
                    currentNode = currentNode.getRightChild();
                }
                else { // Left child path
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(new IntNode(value));
                    }
                    currentNode = currentNode.getLeftChild();
                }
            }
        }
    }

    public boolean search(int value) {
        IntNode currentNode = rootNode;

        while(currentNode != null && (currentNode.getValue() != value)) {
            if (value > currentNode.getValue()) { // Continue down the right child path
                currentNode = currentNode.getRightChild();
            }
            else { // Continue down the left child path
                currentNode = currentNode.getLeftChild();
            }
        }
        // If the current node exists and its value is equal to the input, return true, else return false
        return currentNode != null && (currentNode.getValue() == value);
    }
}
