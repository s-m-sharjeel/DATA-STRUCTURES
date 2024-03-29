package Labs.Lab11;

public class MinHeapTree <T extends Comparable<T>> {

    T[] heap;
    int size;

    public MinHeapTree(int s) {
        heap = (T[])new Comparable[s];
    }

    public MinHeapTree() {
        heap = (T[])new Comparable[10];
    }

    public T getMin() {

        return heap[0];

    }

    public void siftUp(int index) {

        if (index == 0)
            return;

        if (heap[index].compareTo(heap[(index - 1) / 2]) >= 0)
            return;

        T temp = heap[index];
        heap[index] = heap[(index - 1) / 2];
        heap[(index - 1) / 2] = temp;

        siftUp((index - 1) / 2);

    }

    public void insert(T data) {

        if (isFull()) {
            System.out.println("tree is full!");
            return;
        }

        heap[size] = data;
        siftUp(size);
        size++;

    }

    public boolean isFull() {

        return size == heap.length;

    }

    public void siftDown(int index) {

        if (index >= size)
            return;

        if ((2 * index + 1 < size) && (2 * index + 2 < size) && heap[index].compareTo(heap[2 * index + 1]) > 0 && heap[index].compareTo(heap[2 * index + 2]) > 0) {

            if (heap[2 * index + 1].compareTo(heap[2 * index + 2]) <= 0) {
                T temp = heap[index];
                heap[index] = heap[2 * index + 1];
                heap[2 * index + 1] = temp;
                siftDown(2 * index + 1);
            } else if (heap[2 * index + 1].compareTo(heap[2 * index + 2]) > 0) {
                T temp = heap[index];
                heap[index] = heap[2 * index + 2];
                heap[2 * index + 2] = temp;
                siftDown(2 * index + 2);
            }


        } else if ((2 * index + 1 < size) && heap[index].compareTo(heap[2 * index + 1]) > 0) {
            T temp = heap[index];
            heap[index] = heap[2 * index + 1];
            heap[2 * index + 1] = temp;

            siftDown(2 * index + 1);

        } else if ((2 * index + 2 < size) && heap[index].compareTo(heap[2 * index + 2]) > 0){
            T temp = heap[index];
            heap[index] = heap[2 * index + 2];
            heap[2 * index + 2] = temp;

            siftDown(2 * index + 2);

        }

    }

    public T extractMin() {

        if (isEmpty())
            throw new RuntimeException("Tree is empty!");

        T min = heap[0];
        heap[0] = heap[--size];

        siftDown(0);

        return min;

    }

    public int find(T data) {

        for (int i = 0; i < size; i++) {
            if (heap[i].compareTo(data) == 0)
                return i;
        }

        return -1;

    }

    public void remove(T value) {

        int i = find(value);

        if (i == -1)
            return;

        heap[i] = heap[--size];
        heap[size] = null;

        siftDown(i);

    }

    public void update(T d, T v) {

        int i = find(d);

        if (i == -1)
            return;

        heap[i] = v;

        if (d.compareTo(v) < 0)
            siftDown(i);
        else siftUp(i);

    }

    public boolean isEmpty() {

        return size == 0;

    }

    @Override
    public String toString() {

        String s = "[ ";
        for (int i = 0; i < size; i++) {
            s += heap[i] + " ";
        }
        s += "]";
        return s;

    }

}
