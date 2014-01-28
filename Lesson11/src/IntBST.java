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

        // Sample solution
        Queue<IntNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.add(this.rootNode);

        while(!queue.isEmpty()) {
            IntNode node = queue.remove();

            sb.append(" " + node.getValue());

            if (node.getLeftChild() != null) queue.add(node.getLeftChild());
            if (node.getRightChild() != null) queue.add(node.getRightChild());
        }

        return sb.toString().trim();
    }

    public String toPreorderString() {
        // TODO: Return a preorder traversal of a tree using recursion. Values of nodes are space-delimited
        // e.g. "5 1 10"

        // Sample solution
        return toPreorderString(rootNode);
    }

    public String toPreorderString(IntNode node) {
        String string = "" + node.getValue();
        if (node.getLeftChild() != null) string += " " + toPreorderString(node.getLeftChild());
        if (node.getRightChild() != null) string += " " + toPreorderString(node.getRightChild());
        return string;
    }

    public String toInorderString() {
        // TODO: Return a preorder traversal of a tree using recursion. Values of nodes are space-delimited
        // e.g. "1 5 10"

        // Sample solution
        return toInorderString(rootNode);
    }

    public String toInorderString(IntNode node) {
        String string = "";
        if (node.getLeftChild() != null) string += toInorderString(node.getLeftChild());
        string += node.getValue() + " ";
        if (node.getRightChild() != null) string += toInorderString(node.getRightChild());
        return string;
    }

    public List<Integer> valuesGreaterThan(int n) {
        // TODO: Return values that are greater than or equal to n.
        // Do this with the lowest computational complexity you can manage.

        // Sample solution
        return valuesGreaterThan(rootNode, n, new LinkedList<Integer>());
    }

    public List<Integer> valuesGreaterThan(IntNode node, int value, List<Integer> values) {
        List<Integer> list = new LinkedList<>();


        if (node == null)
            return values;

        if (node.getValue() > value)
            values.add(node.getValue());

        valuesGreaterThan(node.getLeftChild(), value, values);
        valuesGreaterThan(node.getRightChild(),value, values);

        return values;
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
