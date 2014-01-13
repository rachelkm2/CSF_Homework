
public class IntStack {
    IntListNode firstNode;

    public IntStack() {
    }

    public void push(int value) {
        // TODO: Add a value to the top of the stack


        if (firstNode == null){
            firstNode = new IntListNode(value);
        } else {
            IntListNode newNode = new IntListNode(value);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }

    }

    public int pop() {
        // TODO: Pop the first value off the stack

        //big-O: O(n)

        IntListNode thisNode = firstNode;

        if (firstNode == null) {
            throw new IllegalArgumentException();
        } else {
            IntListNode returnNode = firstNode;
            if (firstNode.getNextNode() != null) {
                firstNode = firstNode.getNextNode();
            } else {
                firstNode = null;
            }
            return  returnNode.getValue();
        }
    }

    public int size() {
        // TODO: Fill out this method

        //big-O: O(n)

       int counter = 1;
       if (firstNode == null){
           throw new IllegalArgumentException();
       }
        IntListNode currentNode = firstNode;
        while (currentNode.getNextNode() != null){
            counter ++;
            currentNode = currentNode.getNextNode();
        }

        return counter;
    }
}
