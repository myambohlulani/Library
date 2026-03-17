package BinaryTrees;

/**
 * Implementation of RBT Node
 *
 * @author
 * @version
 */
public class TreeNode<T extends Comparable<T>> {
    public T data;
    public Color color;
    public TreeNode<T> left, right;

    public TreeNode(T data) {
        this.data = data;
        this.color = Color.RED;
    }

    enum Color {
        RED, BLACK
    }

    @Override
    public String toString() {
        return "node={data=[" + this.data + "], color=[" + this.color + "]}";
    }
}
