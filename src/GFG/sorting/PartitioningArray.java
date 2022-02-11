package GFG.sorting;

import java.util.Arrays;

/**
 *
 * This video introduces us to the Partition method of Quick Sort.
 * This partitioning method is a naive way of approach towards partitioning an array.
 *
 */
public class PartitioningArray {

    public static void main(String[] args) {
        naive(4, 2,7,8,3,7);
    }

    public static void naive(int p, int... ar) {
        int[] t = new int[ar.length];
        int i = 0, j = ar.length - 1, index = -1;
        for (int k = 0; k < ar.length; k++) {
            if(ar[k] <= ar[p]) {
                t[i++] = ar[k];
            } else
                t[j--] = ar[k];
            if(k == p) {
                index = i - 1;
            }
        }
        for (int k = 0; k < ar.length; k++)
            ar[k] = t[k];

        System.out.println(Arrays.toString(ar));
        System.out.println("Pivot pos : " + index);
    }

}
