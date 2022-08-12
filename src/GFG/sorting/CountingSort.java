package GFG.sorting;

import utils.Utils;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] ar = {9, 11,3, 2, 6, 9, 5, 1,2};
        Utils.print(ar);
        sort(ar);
        Utils.print(ar);
    }

    public static void sort(int[] ar) {
        if(ar == null || ar.length <= 1) return;

        sort(ar, Arrays.stream(ar).max().getAsInt() + 1);
    }

    private static void sort(int[] ar, int k) {
        int[] count = new int[k];
        int[] out = new int[ar.length];
        for (int a : ar)
            count[a]++;
        for (int i = 1; i < k; i++)
            count[i] += count[i -1];
        for (int i = ar.length-1; i >= 0; i--)
            out[--count[ar[i]]] = ar[i];
        System.arraycopy(out, 0, ar, 0, ar.length);
    }

}
