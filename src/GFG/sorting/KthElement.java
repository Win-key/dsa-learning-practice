package GFG.sorting;

import java.util.Arrays;

public class KthElement {

    public static void main(String[] args) {
        int[] ar = new int[]{1, 11, 13, 9, 8, 10, 12, 14, 6, 20};

        int element = smallestSelect(ar, 3);
        System.out.println("3 Smallest = "+element);
        element = largestSelect(ar, 3);
        System.out.println("3 Largest = "+element);

        LomutoQuickSort.sort(ar);
        System.out.println(Arrays.toString(ar));

        ar = new int[]{20, 1, 11, 13, 9, 8, 5, 12, 14, 7, 4, 6, 19};
        element = smallestSelect(ar, 4);
        System.out.println("4 Smallest = "+element);

        element = largestSelect(ar, 5);
        System.out.println("5 Largest = "+element);

        LomutoQuickSort.sort(ar);
        System.out.println(Arrays.toString(ar));
    }

    private static int smallestSelect(int[] ar, int k) {
        int l = 0, r = ar.length - 1;
        if (k > ar.length) throw new IllegalArgumentException("k (" + k + ") is greater the size");
        while (l <= r) {
            int pi = partition(ar, l, r);
            if (k == pi + 1)
                return ar[pi];
            if (k > pi + 1) {
                l = pi + 1;
            } else
                r = pi - 1;
        }
        return -1;
    }

    private static int largestSelect(int[] ar, int k) {
        int l = 0, r = ar.length - 1;
        k = ar.length + 1 - k;
        if (k > ar.length) throw new IllegalArgumentException("k (" + k + ") is greater the size");
        while (l <= r) {
            int pi = partition(ar, l, r);
            if (k == pi + 1)
                return ar[pi];
            if (k > pi + 1) {
                l = pi + 1;
            } else
                r = pi - 1;
        }
        return -1;
    }

    // lomuto partitioning
    private static int partition(int[] ar, int l, int r) {
        int cur = l - 1;
        int pivot = ar[r];
        for (int i = l; i <= r; i++) {
            if (ar[i] <= pivot) {
                Utils.swap(ar, ++cur, i);
            }
        }
        return cur;
    }



}
