package GFG.sorting;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

// When elements in a range are uniformly distributed, we can go for the bucket sort.
public class BucketSort {

    public static void main(String[] args) {
        int[] ar = {17,3,99,33,62,34,55,1};
        sort(ar, 5);
        Utils.print(ar);
    }

    // todo need to find a way to decide the number of buckets needed for the input.
    //      for example, if if decide to use 10% of count as buckets, it will work for 100, 1000.
    //      For higher number of elements it wont work as each buckets are sorted based on Insertion sorting.
    //      Insertion sort choose for lower number of elements as it's an in-place algo.
    //      but not chosen for larger range as the time complx is n^2
    //      So I take number of buckets as input.
    public static void sort(int[] ar, int k) {
        int max = Arrays.stream(ar).max().getAsInt() + 1;
        var buckets = new ArrayList<ArrayList<Integer>>(k);
        for (int i = 0; i < k; i++)
            buckets.add(new ArrayList<>());

        // add elements to bucket
        for (int a : ar) {
            int bucketIndex = (k * a) / max;
            buckets.get(bucketIndex).add(a);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            // Collections.sort() might be use merge sort
            insertionSort(bucket);
            for (int a : bucket)
                ar[index++] = a;
        }
    }

    // keep a pivot element
    // pivot and left are already sorted
    // right to the pivot needs to be sorted.
    // I intentionally take ArrayList as input
    // Other list impl may not be good for insertion sort since it makes index based swaps
    // For ex, For LinkedList index finding is O(n)
    private static void insertionSort(ArrayList<Integer> ar) {
        for (int i = 1; i < ar.size(); i++) {
            int pivot = ar.get(i);
            int j = i - 1;
            while (j >= 0 && pivot < ar.get(j))
                ar.set(j+1, ar.get(j--));
            ar.set(j+1, pivot);
        }
    }



}
