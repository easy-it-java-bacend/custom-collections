package util;

import java.util.Iterator;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private BinaryHeap<E> heap;

    public PriorityQueue() {
        heap = new BinaryHeap<E>();
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return heap.remove();
    }

    @Override
    public boolean offer(E e) {
        heap.add(e);
        return true;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
