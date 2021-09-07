package util;

public interface Queue<E> extends Collection<E> {
    E remove();
    E poll();
    boolean offer(E e);
    E peek();
    E element();
}
