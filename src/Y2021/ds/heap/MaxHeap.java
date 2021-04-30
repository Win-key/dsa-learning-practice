package Y2021.ds.heap;

import java.util.Arrays;

/**
 * @author Venkatesh Rajendran
 */

public class MaxHeap {

    private int size = 0;
    private int capacity;
    private Integer[] heap;

    public MaxHeap() {
        capacity = 10;
        heap = new Integer[capacity];
    }

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new Integer[capacity];
    }

    public void insert(int data) {
        size++;
        ensureCapacity();
        int index = size - 1;
        heap[index] = data;
        while (getParent(index) != null) {
            if (getParent(index) < data) {
                swap(index, getParentIndex(index));
            }
            index = getParentIndex(index);
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ensureCapacity() {
        if (size > capacity) {
            capacity = 2 * capacity;
            heap = Arrays.copyOf(heap, capacity);
        }
    }

    private int getLastIndex() {
        return size - 1;
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChildIndex(int i) {
        return 2 * (i + 1);
    }

    private int getRightChildIndex(int i) {
        return 2 * (i + 2);
    }

    private Integer getParent(int i) {
        int parentIndex = getParentIndex(i);
        if (parentIndex < 0 || parentIndex == i) {
            return null;
        }
        return heap[parentIndex];
    }

    private Integer getLeftChild(int i) {
        int index = getLeftChildIndex(i);
        if (index < 0) {
            return null;
        }
        return heap[index];
    }

    private Integer getRightChild(int i) {
        int index = getRightChildIndex(i);
        if (index < 0) {
            return null;
        }
        return heap[index];
    }

    public String print() {
        return Arrays.toString(heap);
    }


}
