package util;

import java.util.Arrays;

public class ArrayListForAllObjects {

        // Сколько ячеек доступно для использования
        private static final int DEFAULT_CAPACITY = 10;

        // container for data
        private Object[] data; // null

        // Сколько ячеек уже используется
        private int size; // 0

        public ArrayListForAllObjects() {
            size = 0;
            data = new Object[DEFAULT_CAPACITY];
        }

        public void add(int index, Object element) {
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

        public void set(int index, Object element) {
            checkRange(index);
            data[index] = element;
        }

        public void add(Object element) {
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

        public Object get(int index) {
            checkRange(index);
            return data[index];
        }

        private void ensureCapacity() {
            if (size == data.length) {
                data = Arrays.copyOf(data, data.length * 2 + 1);
            }
        }


}
