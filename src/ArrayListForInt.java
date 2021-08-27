import java.util.Arrays;

public class ArrayListForInt {

    // Сколько ячеек доступно для использования
    private static final int DEFAULT_CAPACITY = 10;

    // container for data
    private int[] data; // null

    // Сколько ячеек уже используется
    private int size; // 0

    public ArrayListForInt() {
        size = 0;
        data = new int[DEFAULT_CAPACITY];
    }

    public void add(int index, int element) {
        checkRangeAdd(index);
        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public int size() {
        return size;
    }

    public void set(int index, int element) {
        checkRange(index);
        data[index] = element;
    }

    public void add(int element) {
        add(size, element);
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

    public int get(int index) {
        checkRange(index);
        return data[index];
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2 + 1);
        }
    }
}
