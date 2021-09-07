package util;

public interface Deque<E> extends Queue<E> {
    E getFirst();
    E getLast();
    E removeFirst();
    E removeLast();
    void addLast(E element);
    void addFirst(E element);
    E peekLast();
    E peekFirst();
    E pollLast();
    E pollFirst();
    boolean offerLast(E element);
    boolean offerFirst(E element);
    // дописать методы из документации
}
