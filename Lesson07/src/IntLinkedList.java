import java.util.LinkedList;

public class IntLinkedList {
    private IntListNode firstNode;


    // Comment
    // IntLinkedList stores a list of unique integers
    public IntLinkedList() {
    }

    public void insert(int value) {
        // TODO: Add the integer, or take no action if it's already in the list

        //If first node is null then just go ahead and insert value
        if (firstNode == null){
            firstNode = new IntListNode(value);
        } else {
            //Check to see if linked list contains value already
            if (!this.contains(value)){
                //If not, create a new node and insert value
                IntListNode newNode = new IntListNode(value);
                //Create a link from new node to the first node
                newNode.setNextNode(firstNode);
                //Set the new node as the first node
                firstNode = newNode;
            }
        }

    }

    public boolean contains(int value) {
        // TODO: Print out if the linked list contains the given integer

        //big-O: O(n)

        if (firstNode == null) {
            throw new IllegalArgumentException();
        }
        //Start with the first node
        IntListNode currentNode = firstNode;
        //While the current node has a next node
        while (currentNode.getNextNode() != null){
            //If current node contains value, return true
            if (currentNode.getValue() == value){
                return true;
             }
            //Get the next node
            currentNode = currentNode.getNextNode();
        }
        //Check the value of the last node
        if (currentNode.getValue() == value){
            return true;
        }

        return false;
    }

    public void remove(int value) {
        // TODO: Remove the given integer from the list, or take no action if it's not in the list

        //big-O: O(n)

        if (firstNode == null | firstNode.getNextNode() == null) {
            throw new IllegalArgumentException();
        }
        //If the first node contains the value, set the first node to the next node
        if (firstNode.getValue() == value){
            firstNode = firstNode.getNextNode();
        } else {
            //Go to the next node
            IntListNode currentNode = firstNode.getNextNode();
            IntListNode lastNode = firstNode;
            while (currentNode.getNextNode() != null){
                //If current node contains value
                if (currentNode.getValue() == value){
                    //Set the last node's next node to the current node's next node
                    lastNode.setNextNode(currentNode.getNextNode());
                }
                lastNode = currentNode;
                currentNode = currentNode.getNextNode();
            }
            if (currentNode.getValue() == value){
                lastNode.setNextNode(null);
            }
        }
    }

    public void print() {
        //big-O: O(n)

        IntListNode node = firstNode;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNextNode();
        }
    }
}