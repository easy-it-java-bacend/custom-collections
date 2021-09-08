package util;


class BinaryHeap<E extends Comparable<E>> {

    private List<E> list;

    BinaryHeap() {
        list = new MyArrayList<>();
    }

    BinaryHeap(E[] objects) {
        list = new MyArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public void add(E element) {
        list.add(element);

        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {

            int parentIndex = (currentIndex - 1) / 2;
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) {
//                Collections.swap(queue, currentIndex, parentIndex);
                swap(list, currentIndex, parentIndex);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    private void swap(List<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public E remove() {
        if (list.size() == 0) {
            return null;
        }
        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChild = currentIndex * 2 + 1;
            int rightChild = currentIndex * 2 + 2;

            if (leftChild >= list.size()) {
                break;
            }

            int minIndex = leftChild;

            if (rightChild < list.size()) {
                if (list.get(rightChild).compareTo(list.get(minIndex)) < 0) {
                    minIndex = rightChild;
                }
            }

            if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
                swap(list, currentIndex, minIndex);
                currentIndex = minIndex;
            } else {
                break;
            }
        }
        return removedObject;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
