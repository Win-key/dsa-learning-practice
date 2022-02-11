package archived.ds.heap;

public class MaxHeapMain {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.insert(1);
        maxHeap.insert(10);
        maxHeap.insert(100);
        maxHeap.insert(1000);
        maxHeap.insert(10000);

        maxHeap.insert(100000);
        maxHeap.insert(1000000);
        maxHeap.insert(10000000);

        System.out.println(maxHeap.print());
        
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.delete());
        System.out.println(maxHeap.delete());
        
        System.out.println(maxHeap.print());
        System.out.println("Sorted : " + maxHeap.printRaw());
        
        maxHeap = new MaxHeap(new Integer[]{1,2,3,4,5}, 5);
        
        System.out.println(maxHeap.print());
    }

}
