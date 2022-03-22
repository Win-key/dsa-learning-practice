package GFG.sorting;

import java.util.Arrays;

// Apply counting sort on the digits starting from right to left.
public class RadixSort {

    public static void main(String[] args) {
        int[] ar = {9, 11,3, 2, 69087, 9, 5, 1,2222, 342};
        Utils.print(ar);
        sort(ar);
        Utils.print(ar);
    }

    public static void sort(int[] ar) {
        int max = Arrays.stream(ar).max().getAsInt();
        for (int div = 1; max/div > 0; div *= 10) {
            countSort(ar, div, ar.length);
        }
    }

    private static void countSort(int[] ar, int div, int n) {
        int[] count = new int[10], out = new int[n];
        for (int a : ar)
            count[(a / div) % 10]++;
        for (int i = 1; i < n; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--)
            out[--count[(ar[i] / div) % 10]] = ar[i];
        for (int i = 0; i < n; i++)
            ar[i] = out[i];
    }

}
