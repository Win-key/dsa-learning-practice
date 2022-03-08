package GFG.sorting;

import java.util.Arrays;

public class LomutoQuickSort {

    public static void main(String[] args) {
        int[] ar = new int[] {11,9 ,5 ,8 ,10, 12, 14, 1, 20};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));

        ar = new int[] {1, 11,9 ,1 ,8 ,10, 12, 14, 1, 20};
        System.out.println(Arrays.toString(ar));
        sort(ar);
        System.out.println(Arrays.toString(ar));
    }

    public static void sort(int[] ar) {
        sort(ar, 0, ar.length - 1);
    }

    private static void sort(int[] ar, int l, int h) {
        if(l >= h) return;

        int pivot = partition(ar, l, h);
        sort(ar, l, pivot - 1);
        sort(ar, pivot + 1, h);
    }

    private static int partition(int[] ar, int l, int h) {
        int pivot = ar[h], cur = l - 1;
        for(int i = l; i <= h; i++) {
            if(ar[i] <= pivot) {
                swap(ar, ++cur, i);
            }
        }
        return cur;
    }

    private static void swap(int[] ar, int i, int j) {
        if (i == j) return;
        ar[i] += ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }
}
