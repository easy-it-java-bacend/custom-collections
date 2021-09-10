package util;

public class TreeNode<E> {

    E element;
    TreeNode<E> leftChild;
    TreeNode<E> rightChild;

    public TreeNode(E element) {
        this.element = element;
    }
}
