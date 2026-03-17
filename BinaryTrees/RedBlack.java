package BinaryTrees;

import BinaryTrees.TreeNode.Color;

/**
 * Implementation of RBT
 *
 * @author
 * @version
 */
public class RedBlack<T extends Comparable<T>> {
    public TreeNode<T> root;

    /**
     * This method insert a node recursively into the tree starting from the root
     * node
     *
     * @param data the data to be added to the tree
     */
    public void insert(T data) {
        this.root = this.insert(data, root);
        this.root.color = Color.BLACK; // enforcing the root to be black
    }

    private TreeNode<T> insert(T data, TreeNode<T> node) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = this.insert(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            node.right = this.insert(data, node.right);
        }

        return this.balance(node);
    }

    private TreeNode<T> balance(TreeNode<T> node) {
        if (this.isRed(node.right) && !this.isRed(node.left)) {
            node = this.rotateLeft(node);
        }

        if (node.left != null && this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateRight(node);
        }

        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColor(node);
        }

        return node;

    }

    private boolean isRed(TreeNode<T> node) {
        return (node != null && node.color == Color.RED);
    }

    private TreeNode<T> rotateLeft(TreeNode<T> node) {
        TreeNode<T> rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        rightChild.color = node.color;
        node.color = Color.RED;

        return rightChild;
    }

    private TreeNode<T> rotateRight(TreeNode<T> node) {
        TreeNode<T> leftChild = node.left;

        node.left = leftChild.right;
        leftChild.right = node;

        leftChild.color = node.color;
        node.color = Color.RED;

        return leftChild;
    }

    // Both children red
    private void flipColor(TreeNode<T> node) {
        node.color = Color.RED;
        node.left.color = node.right.color = Color.BLACK;
    }

    /**
     * This method check if a data exists in the tree or not
     */
    public boolean search(T data) {
        return this.search(data, this.root);
    }

    private boolean search(T data, TreeNode<T> node) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.data) < 0) {
            return this.search(data, node.left);
        } else if (data.compareTo(node.data) > 0) {
            return this.search(data, node.right);
        }

        return true;
    }

    /**
     * Implementation of preOrder traversal
     */
    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(TreeNode<T> node) {
        if (node != null) {
            this.visit(node);
            this.preOrder(node.left);
            this.preOrder(node.right);
        }
    }

    /**
     * Implementation of inorder traversal
     */
    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(TreeNode<T> node) {
        if (node != null) {
            this.inOrder(node.left);
            this.visit(node);
            this.inOrder(node.right);
        }
    }

    /**
     * Implementation of post order Traversal
     */
    public void postOrder() {
        this.postOrder(this.root);
    }

    private void postOrder(TreeNode<T> node) {
        if (node != null) {
            this.postOrder(node.left);
            this.postOrder(node.right);
            this.visit(node);
        }
    }

    /**
     * Implementation of levelOrder Traversal
     */
    public void levelOrder() {
        java.util.Queue<TreeNode<T>> treeQueue = new java.util.ArrayDeque<>();
        treeQueue.add(this.root);
        TreeNode<T> current;

        while (treeQueue.peek() != null) {
            current = treeQueue.remove();

            this.visit(current);

            if (current.left != null) {
                treeQueue.add(current.left);
            }
            if (current.right != null) {
                treeQueue.add(current.right);
            }
        }
    }

    private void visit(TreeNode<T> node) {
        String colour = node.color == Color.RED ? "RED" : "BLACK";
        System.out.printf("%s(%s)", node.data, colour);
    }
}