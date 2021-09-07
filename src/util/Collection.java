package util;

public interface Collection<E> extends Iterable<E> {

    boolean add(E e);
    boolean addAll(Collection<? extends E> collection);
    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<? extends E> collection);
    boolean isEmpty();
    boolean remove(Object o);
    boolean removeAll(Collection<? extends E> collection);
    boolean retainAll(Collection<? extends E> collection);
    int size();
    Object[] toArray();

}
