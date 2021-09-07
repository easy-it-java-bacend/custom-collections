package util;

import java.util.ListIterator;

public interface List<E> extends Collection<E> {

    void add(int index, E element);
    E get(int index);
    E set(int index, E element);
    E remove(int index);
    int indexOf(E element);
    int lastIndexOf(E element);
    ListIterator<E> listIterator();

}
