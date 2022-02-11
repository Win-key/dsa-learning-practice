package archived.ds.heap;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

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
    
    public MaxHeap(Integer[] ar, int n) {
        capacity = ar.length;
        heap = ar;
        size = n;
        int lastNotLeave = getParentIndex(n-1);
        for(int i = lastNotLeave; i >= 0 ; i--) {
            heapify(i);
        }
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
    
    public Integer delete() {
    	Integer delete = heap[0];
    	swap(0, getLastIndex());
    	size--;
    	heapify(0);
    	return delete;
    }
    
    
    private void heapify(int i) {
        int largeIndex = i;
        int left = getLeftChildIndex(i);
        int right = getRightChildIndex(i);
        
        if (right < size && heap[right] > heap[largeIndex]) {
            largeIndex = right;
        }
        if(left < size &&  heap[left] > heap[largeIndex]) {
            largeIndex = left;
        }
        
        if(largeIndex != i) {
            swap(largeIndex, i);
            heapify(largeIndex);
        }
    }
    
    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
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
    
    private int getLast() {
        return heap[getLastIndex()];
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private static int getLeftChildIndex(int i) {
        return (2 * i) + 1;
    }

    private static int getRightChildIndex(int i) {
        return (2 * i) + 2;
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
        if (index < 0 || i >= size) {
            return null;
        }
        return heap[index];
    }

    private Integer getRightChild(int i) {
        int index = getRightChildIndex(i);
        if (index < 0 || i >= size) {
            return null;
        }
        return heap[index];
    }

    public String print() {
        Optional<String> reduce = IntStream.range(0, size).mapToObj(i-> heap[i] + "").reduce((a, b)->a+","+b);
        return reduce.orElse("");
    }
    
    public String printRaw() {
        
        return Arrays.toString(heap);
    }


}
