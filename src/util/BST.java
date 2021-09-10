package util;

import java.util.Iterator;

public class BST<E extends Comparable<E>> extends AbstractTree<E> implements Tree<E> {

    private TreeNode<E> root;

    private int size;
    public BST() {
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean search(E element) {
        return false;
    }

    @Override
    public boolean insert(E element) {
        if (root == null) {
            root = new TreeNode<>(element);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;

            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.leftChild;
                }
                else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.rightChild;
                }
                else {
                    return false;
                }
            }
            if (element.compareTo(parent.element) < 0) {
                parent.leftChild = new TreeNode<>(element);
            }
            else {
                parent.rightChild = new TreeNode<>(element);
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean delete(E element) {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void postorder() {

    }

    @Override
    public void preorder() {

    }

    @Override
    public void inorder() {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
