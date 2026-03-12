package BinaryTrees;

public class redBlack<T extends Comparable<T>> {
    public treeNode root;

    public void insert(T data) {
        treeNode<T> nodeToInsert = new treeNode<>(data);

        this.root = insert(nodeToInsert, this.root);

    }

    private treeNode<T> insert(treeNode<T> nodeToInsert, treeNode<T> node) {

        if (isEmpty()) {
            return nodeToInsert;
        }

        if (nodeToInsert.data.compareTo(node.data) < 0) {
            node.left = insert(nodeToInsert, node.left);
            nodeToInsert.parent = node.parent;
        }
        else if (nodeToInsert.data.compareTo(node.data) > 0) {
            node.right = insert(nodeToInsert, node.right);
            nodeToInsert.parent = node.parent;
        }

        return recolor(nodeToInsert, node);
    }

    private treeNode<T> recolor(treeNode<T> node1, treeNode<T> node2) {
        return null;

    }





    public boolean isEmpty() {
        return null == this.root;
    }

}
