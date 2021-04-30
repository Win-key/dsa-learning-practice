package Y2021.ds.heap;

public class MaxHeapMain {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.insert(1);
        maxHeap.insert(10);
        maxHeap.insert(100);
        maxHeap.insert(1000);
        maxHeap.insert(10000);

//        maxHeap.insert(100000);
//        maxHeap.insert(1000000);
//        maxHeap.insert(10000000);

        System.out.println(maxHeap.print());
    }

}
