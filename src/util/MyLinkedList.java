package util;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> extends AbstractList<E>
        implements List<E>, Deque<E>, Collection<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends E> collection) {
        for (E element : collection) {
            add(element);
        }
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
            addFirst(element);
        } else if (index == size()) { // index = 1 size = 1
           addLast(element);
        } else {
            Node<E> current = index < size() / 2 ?
                    iterateFromHead(index) :
                    iterateFromTail(index);

            Node<E> temp = current.next;
            current.next = new Node<>(element);
            (current.next).next = temp;
            size++;
        }
    }

    private Node<E> iterateFromHead(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node<E> iterateFromTail(int index) {
        Node<E> current = tail;
        for (int i = size() - 1; i > index; i--) {
            current = current.prev;
        }
        return current;
    }

    @Override
    public E get(int index) {
        checkRange(index);
        Node<E> currentNode = isElementBeforeMiddle(index) ? iterateFromHead(index + 1) : iterateFromTail(index - 1);
        return currentNode.element;
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
            Node<E> prevNode = isElementBeforeMiddle(index) ?
                    iterateFromHead(index) :
                    iterateFromTail(index);

            Node<E> currentNode = prevNode.next;
            prevNode.next = currentNode.next;
            return currentNode.element;
        }
    }

    private boolean isElementBeforeMiddle(int index) {
        return index < size() / 2;
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
        ListIterator<E> listIterator = listIterator();
        int indexCounter = size() - 1;
        while (listIterator.hasPrevious()) {
            E e = listIterator.previous();
            if (e.equals(element)) {
                return indexCounter;
            }
            indexCounter--;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIteratorImpl();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    @Override
    public E getFirst() {
        E element = peekFirst();
        if (element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    public E getLast() {
        E element = peekLast();
        if (element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    public E removeFirst() {
        E element = pollFirst();
        if (element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    public E removeLast() {
        E element = pollLast();
        if (element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    public void addLast(E element) {
        offerLast(element);
    }

    @Override
    public void addFirst(E element) {
        offerFirst(element);
    }

    @Override
    public E peekLast() {
        return tail.element;
    }

    @Override
    public E peekFirst() {
        return head.element;
    }

    @Override
    public E pollLast() {
        Node<E> currentNode = tail;
        tail = tail.prev;
        size++;
        return currentNode.element;
    }

    @Override
    public E pollFirst() {
        Node<E> currentNode = head;
        head = head.next;
        size++;
        return currentNode.element;
    }

    @Override
    public boolean offerLast(E element) {
        Node<E> temp = tail;
        tail = new Node<>(element);
        temp.next = tail;
        if (size() == 0) {
            head = tail;
        }
        size++;
        return true; // !
    }

    @Override
    public boolean offerFirst(E element) {
        Node<E> temp = head;
        head = new Node<>(element);
        head.next = temp;
        if (size() == 0) {
            tail = head;
        }
        size++;
        return true; // !
    }

    @Override
    public E remove() {
        E element = poll();
        if (element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public E element() {
        E e = peek();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next; // null
        private Node<E> prev;

        public Node(E element) {
            this.element = element;
        }
    }

    private class ListIteratorImpl implements ListIterator<E> {

        private Node<E> current = tail;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return current != null;
        }

        @Override
        public E previous() {
            E element = current.element;
            current = current.prev;
            return element;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
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
