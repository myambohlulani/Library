package BinaryTrees;

import java.awt.Color;

public class redBlack<T extends Comparable<T>> {

    public treeNode<T> root;

    public void insert(T data) {

        this.root = this.insert(data, root);

    }

    private treeNode<T> insert(T data, treeNode<T> node) {
        if (node == null) {
            return new treeNode<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = this.insert(data, node.left);
        }
        else if (data.compareTo(node.data) > 0) {
            node.right = this.insert(data, node.right);
        }

        return this.balance(node);
    }

    private treeNode<T> balance(treeNode<T> node) {

        if (this.isRed(node.right) && !this.isRed(node.left)) {
            node = this.rotateLeft(node);
        }

        if (this.isRed(node.left) && this.isRed(node.left.left)) {
            node = this.rotateRight(node);
        }

        if (this.isRed(node.left) && this.isRed(node.right)) {
            this.flipColor(node);
        }

        return node;

    }

    private boolean isRed(treeNode<T> node) {
        return (node != null && node.color == Color.RED);
    }

    private treeNode<T> rotateLeft(treeNode<T> node) {

        treeNode<T> rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        rightChild.color = node.color;
        node.color = Color.RED;

        return rightChild;
    }

    private treeNode<T> rotateRight(treeNode<T> node) {

        treeNode<T> leftChild = node.left;

        node.left = leftChild.right;
        leftChild.right = node;

        leftChild.color = node.color;
        node.color = Color.RED;

        return leftChild;
    }

    // Both children red
    private void flipColor(treeNode<T> node) {

        node.color = Color.RED;
        node.left.color = node.right.color = Color.BLACK;
    }

    public boolean search(T data) {

        return this.search(data, this.root);
    }

    private boolean search(T data, treeNode<T> node) {
        if (node == null || this.isEmpty()) {
            return false;
        }

        if (data.compareTo(node.data) < 0) {
            return this.search(data, node.left);
        }
        else if (data.compareTo(node.data) > 0) {
            return this.search(data, node.right);
        }

        return true;
    }

    public boolean isEmpty() {
        return null == this.root;
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    private void preOrder(treeNode<T> node) {
        if (node != null) {
            this.visit(node);
            this.preOrder(node.left);
            this.preOrder(node.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    private void inOrder(treeNode<T> node) {

        if (node != null) {
            this.inOrder(node.left);
            this.visit(node);
            this.inOrder(node.right);
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

    private void postOrder(treeNode<T> node) {
        if (node != null) {
            this.postOrder(node.left);
            this.postOrder(node.right);
            this.visit(node);
        }
    }

    public void levelOrder() {

        java.util.Queue<treeNode<T>> treeQueue = new java.util.ArrayDeque<>();
        treeQueue.add(this.root);
        treeNode<T> current;

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

    private void visit(treeNode<T> node) {

        System.out.println(node.color);
    }

}