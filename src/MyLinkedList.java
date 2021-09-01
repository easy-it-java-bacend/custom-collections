import java.util.Iterator;

public class MyLinkedList<E> extends AbstractList<E>
        implements List<E>, Collection<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public MyLinkedList() {
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void add(int index, E element) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node<E> temp = current.next;
        current.next = new Node<>(element);
        (current.next).next = temp;
        size++;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public int lastIndexOf(E element) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next; // null

        public Node(E element) {
            this.element = element;
        }
    }
}
