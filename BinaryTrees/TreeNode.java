package BinaryTrees;

import java.awt.Color;


public class treeNode<T extends Comparable<T>> {

    public T data;
    public Color color = Color.RED;
    public treeNode<T> left, right;

    public treeNode(T data) {
        this.data = data;

    }

}
