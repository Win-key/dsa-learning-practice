package GFG.sorting;

import java.util.Arrays;

public class HoareQuickSort {

    public static void main(String[] args) {
        int[] ar = new int[] {11,9 ,5 ,8 ,10, 12, 14, 1, 20};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
        ar = new int[] {11,9 ,5 ,8 ,10, 12, 14, 1, 20};
        System.out.println(Arrays.toString(ar));
        sort2(ar, 0, ar.length - 1);
        System.out.println(Arrays.toString(ar));
    }

    public static void sort(int[] ar) {
        sort(ar, 0, ar.length - 1);
    }

    private static void sort(int[] ar, int l, int h) {
        if(l >= h) return;

        int pivot = partition(ar, l, h);
        sort(ar, l, pivot);
        sort(ar, pivot + 1, h);
    }

    private static int partition(int[] ar, int l, int h) {
        int pivot = ar[l], i = l - 1, j = h + 1;
        while (true) {
            do  i++;  while (ar[i] < pivot);
            do  j--;  while (ar[j] > pivot);
            if(i >= j) break;
            swap(ar, i, j);
        }
        return j;
    }

    private static void swap(int[] ar, int i, int j) {
        if (i == j) return;
        ar[i] += ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }

    private static void sort2(int[] ar, int l, int h) {
        while (l < h) {
            int pivot = partition(ar, l, h);
            sort2(ar, l, pivot);
            l = pivot + 1;
        }
    }
}
