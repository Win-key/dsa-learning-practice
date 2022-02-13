package GFG.sorting;

import java.util.Arrays;

/**
 * This video introduces us to the Partition method of Quick Sort.
 * This partitioning method is a naive way of approach towards partitioning an array.
 */
public class PartitioningArray {

    public static void main(String[] args) {
        naive(4, 2, 7, 8, 3, 7);
        lomutoAlgo(4, 3, 2, 7, 8, 7);
        hoareAlgo(3, 2, 7, 8, 7);
        hoareAlgo(11,7 ,8 ,9 ,10, 12, 14, 1, 20);
    }

    public static void naive(int p, int... ar) {
        int[] t1 = new int[ar.length];
        int[] t2 = new int[ar.length];
        int i = 0, j = 0, index = -1;
        for (int k = 0; k < ar.length; k++) {
            if (ar[k] <= ar[p]) {
                t1[i++] = ar[k];
            } else
                t2[j++] = ar[k];
            if (k == p) {
                index = i - 1;
            }
        }
        int k = 0;
        for (; k < i; k++)
            ar[k] = t1[k];
        j += k;
        for (; k < j; k++)
            ar[k] = t2[j - k - 1];

        System.out.println(Arrays.toString(ar));
        System.out.println("Pivot pos : " + index);
    }

    /**
     * This algorithm considers that the last (or first) element is always the pivot element
     *
     * @param ar
     */
    public static void lomutoAlgo(int p, int... ar) {
        // move the pivot to last position
        int i = -1, j = 0, pivot = ar[p];
        swap(ar, p, ar.length - 1);
        for (; j < ar.length; j++) {
            if (ar[j] <= pivot || j == ar.length - 1) {
                swap(ar, ++i, j);
            }
        }
        //swap(ar, ++i, ar.length - 1);

        System.out.println("Lomuto " + Arrays.toString(ar));
        System.out.println("Lomuto Pivot pos : " + i);
    }

    /**
     * Typically this algorithm takes first element as pivot value
     * It keeps two point front and end
     * front checks for lesser than pivot
     * end checks for greater than pivot
     * <p>
     * when they fail the stop and swap the values
     * <p>
     * when front <= end, returns end
     * <p>
     * <p>
     *
     * In the end, left is lesser than or equal to pivot
     *  or
     * right is greater than or equal to pivot
     *
     * But I think, We can pick any element within the array
     *
     * @param ar
     */
    public static void hoareAlgo(int... ar) {
        int i = -1, j = ar.length;
        int pivot = ar[0];
        while (true) {
            do { i++; } while (ar[i] < pivot);
            do { j--; } while (ar[j] > pivot);
            if(i >= j) {
                System.out.println("Hoare's : " +Arrays.toString(ar));
                System.out.println("Hoare's Pivot pos : " + j);
                return;
            }
            swap(ar, i, j);
        }
    }


    private static void swap(int[] ar, int i, int j) {
        if (i == j) return;
        ar[i] += ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }

}
