import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E>
        implements List<E>, Collection<E> {

    private int size;

    private E[] data;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        for (E e : collection) {
            this.add(e);
        }
        return false;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[size()];
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (o.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends E> collection) {
        for (E e : collection) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

    public void trimToSize() {
        data = Arrays.copyOf(data, size());
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean remove(Object o) {
        int index = this.indexOf((E) o);
        if (index == -1) {
            return false;
        }
        for (int i = index; i + 1 < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean removeAll(Collection<? extends E> collection) {
        int prevSize = size;
        for (E e : collection) {
            this.remove(e);
        }
        return prevSize != size;
    }

    @Override
    public boolean retainAll(Collection<? extends E> collection) {
        int prevSize = size;
        for (E e : collection) {
            if (!this.contains(e)) {
                this.remove(e);
            }
        }
        return prevSize != size;
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
        checkRangeAdd(index);
        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    private void checkRangeAdd(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("For index = " + index + ", size = " + size);
        }
    }

    private void checkRange(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("For index = " + index + ", size = " + size);
        }
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2 + 1);
        }
    }

    @Override
    public E get(int index) {
        checkRange(index);
        return data[index];
    }

    @Override
    public E set(int index, E element) {
        checkRange(index);
        E temp = data[index];
        data[index] = element;
        return temp;
    }

    @Override
    public E remove(int index) {
        checkRange(index);

        E e = data[index];
        for (int i = index; i + 1 < size(); i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return e;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i > 0; i--) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size(); i++) {
            result.append(data[i]);
            if (i < size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            return data[currentIndex++];
        }
    }
}
