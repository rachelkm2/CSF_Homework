
public class TreeIntNode {
    private int value;
    private TreeIntNode rightNode;
    private TreeIntNode leftNode;

    public TreeIntNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeIntNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeIntNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeIntNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeIntNode leftNode) {
        this.leftNode = leftNode;
    }

}