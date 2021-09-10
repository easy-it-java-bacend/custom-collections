package util;

public abstract class AbstractTree<E> implements Tree<E> {

    public boolean contains(Object element) {
        return search((E) element);
    }

    public boolean add(E element) {
        return insert(element);
    }

    public boolean remove(Object element) {
        return delete((E) element);
    }

    public int size() {
        return getSize();
    }

    public boolean containsAll(Collection<? extends E> collection) {
        for (E e : this) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        int length = size();
        for (E e : this) {
            add(e);
        }
        return length != size();
    }

    public boolean removeAll(Collection<? extends E> collection) {
        int length = size();
        for (E e : this) {
            if (contains(e)) {
                remove(e);
            }
        }
        return length != size();
    }

    public boolean retainAll(Collection<? extends E> collection) {
        int length = size();
        for (E e : this) {
            if (!contains(e)) {
                remove(e);
            }
        }
        return length != size();
    }

    public Object[] toArray() {
        Object[] elements = new Object[size()];
        int index = 0;

        for (E e : this) {
            elements[index++] = e;
        }
        return elements;
    }
}
