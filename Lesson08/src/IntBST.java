import com.apple.jobjc.appkit._NSProgressIndicatorThreadInfoOpaque;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.LinkedList;

public class IntBST {
    private TreeIntNode rootNode;

    public String bfsRepresentation() {
        // TODO: Return a string representation of a breadth-first search of this tree.
        // Nodes are space-delimited, e.g. "1 2 4 5"
        // Hint: Use a queue and, starting with the root node, then enqueue its left and right children.
        // Hint: The StringBuilder class is useful for constructing strings that are constantly appended to
        LinkedList<TreeIntNode> q = new LinkedList<TreeIntNode>();
        StringBuilder result = new StringBuilder();

        if (rootNode != null){
            q.add(rootNode);
            while (!q.isEmpty()){
                TreeIntNode n = q.remove();
                result.append(n.getValue() + " ");
                if (n.getLeftNode() != null){
                    q.add(n.getLeftNode());
                }
                if (n.getRightNode() != null) {
                    q.add(n.getRightNode());
                }
            }

        }

        return result.toString().trim();
    }

    public void insertValue(int value) {
        // TODO: Insert a value into the tree, maintaining the 'binary' property of the tree.

        TreeIntNode newNode = new TreeIntNode(value);

        if (rootNode == null) {
            rootNode = new TreeIntNode(value);
        } else {
            TreeIntNode n = rootNode;
            while (n.getValue() != value){
                if (value < n.getValue()){
                    if (n.getLeftNode() == null){
                        n.setLeftNode(newNode);
                    } else {
                        n = n.getLeftNode();
                    }
                } else if (value > n.getValue()){
                    if (n.getRightNode() == null){
                        n.setRightNode(newNode);
                    } else {
                        n = n.getRightNode();
                    }
                }
            }
        }
    }

    public boolean search(int value) {
        // TODO: Return whether the tree contains a given value
        throw new NotImplementedException();
    }

    public void remove(int value) {
        // TODO: Optional Challenge question
        // To remove, first examine the find the node, then:
        // 1) Node N has no children? Just remove N
        // 2) Node N has one child? Just remove N and replace with the child
        // 3) Node N has two children? A little harder. Either take the in-order successor or predecessor R, swap the values of N and R, then delete R
        throw new NotImplementedException();
    }
}
