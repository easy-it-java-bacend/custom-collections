package util;

public interface Tree<E> extends Collection<E> {

    boolean search(E element);
    boolean insert(E element);
    boolean delete(E element);
    int getSize();
    void postorder();
    void preorder();
    void inorder();


}
