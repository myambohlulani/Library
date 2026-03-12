package BinaryTrees;

import java.awt.Color;


public class treeNode<T extends Comparable<T>> {

    public T data;
    public Color color = Color.RED;
    public treeNode<T> left;
    public treeNode<T> right;
    public treeNode<T> parent;

    public treeNode(T data) {
        this.data = data;

    }

    public treeNode(T data, treeNode<T> parent) {
        this.data = data;
        this.parent = parent;

    }

}
