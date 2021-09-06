import java.util.Iterator;

public class MyLinkedList<E> extends AbstractList<E>
        implements List<E>, Deque<E>, Collection<E> {

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
    public boolean remove(Object o) {
        int index = indexOf((E) o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            Node<E> temp = head;
            head = new Node<>(element);
            head.next = temp;
        } else if (index == size() - 1) {
            Node<E> temp = tail;
            tail = new Node<>(element);
            temp.next = tail;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(element);
            (current.next).next = temp;
            size++;
        }
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
        checkRange(index);
        if (index == 0) {
          return removeFirst();
        }
        else if (index == size() - 1) {
            return removeLast();
        } else {
            Node<E> prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }
            Node<E> currentNode = prevNode.next;
            prevNode.next = currentNode.next;
            return currentNode.element;
        }
    }

    @Override
    public int indexOf(E element) {
        Iterator<E> iterator = iterator();
        int indexCounter = 0;
        while (iterator.hasNext()) {
            E e = iterator.next();
            if (e.equals(element)) {
                return indexCounter;
            }
            indexCounter++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public E getFirst() {
        //homework
        return null;
    }

    @Override
    public E getLast() {
        //homework
        return null;
    }

    @Override
    public E removeFirst() {
        Node<E> currentNode = head;
        head = head.next;
        return currentNode.element;
    }

    @Override
    public E removeLast() {
        Node<E> prevNode = head;
        for (int i = 0; i < size() - 2; i++) {
            prevNode = prevNode.next;
        }
        Node<E> currentNode = tail;
        tail = prevNode;
        tail.next = null;
        size--;
        return currentNode.element;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next; // null
        private Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }

    private class IteratorImpl implements Iterator<E> {

        private Node<E> currentNode = head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E temp = currentNode.element;
            currentNode = currentNode.next;
            return temp;
        }
    }

}
