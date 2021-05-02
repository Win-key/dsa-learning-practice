package Y2021.ds.heap;

import java.util.Arrays;

public class LargestKthNum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] ar = {1,2,3,4,5};
        buildMaxHeap(ar, 5);
        System.out.println(Arrays.toString(ar));
        
        int k = 3, n = 5;
        for (int i = 0; i < k-1; i++) {
            delete(ar, n-i);
        }
        
        System.out.println("Kth max number : " + ar[0]);
        System.out.println(Arrays.toString(ar));
        
    }
    
    public static void buildMaxHeap(int[] ar, int n) {
        int lastNonLeaf = (n-2)/2;
        for(int i = lastNonLeaf; i >= 0; i--) {
            heapify(ar, i, n);
        }
    }
    
    public static int delete(int[] ar, int n) {
        swap(0, --n, ar);
        heapify(ar, 0, n);
        return ar[n];
    }
    
    public static void heapify(int[] ar, int i, int n) {
        int l = (2*i) + 1;
        int r = (2*i) + 2;
        int large = i;
        
        if(l < n && ar[l] > ar[large]) {
            large = l;
        }
        if(r < n && ar[r] > ar[large]) {
            large = r;
        }
        
        if(large != i) {
            swap(i, large, ar);
            heapify(ar, large, n);
        }
    }
    
    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

}
