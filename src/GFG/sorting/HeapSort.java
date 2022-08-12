package GFG.sorting;

import utils.Utils;

import java.util.function.BiFunction;

public class HeapSort {

    public static void main(String[] args) {
        int[] ar = {9,3,2,10,11,5,3};
        Utils.print(ar);
        sort(ar, SortOrder.DESCENDING);
        Utils.print(ar);
        sort(ar, SortOrder.ASCENDING);
        Utils.print(ar);
    }

    public static void sort(int[] ar) {
        sort(ar, SortOrder.ASCENDING);
    }

    public static void sort(int[] ar, SortOrder o) {
        BiFunction<Integer, Integer, Boolean> bf = (x,y) -> o == SortOrder.ASCENDING ? x > y : x < y;
        buildHeap(ar, bf);
        for (int i = ar.length - 1; i >= 0; i--) {
            Utils.swap(ar, 0, i);
            heapify(ar, 0, i, bf);
        }
    }

    private static void buildHeap(int[] ar, BiFunction<Integer, Integer, Boolean> validate) {
        int n = ar.length, lastParentNode = (n - 2) / 2;
        for (int i = lastParentNode; i >= 0; i--) {
            heapify(ar, i, n, validate);
        }
    }

    private static void heapify(int[] ar, int i, int n, BiFunction<Integer, Integer, Boolean> validate) {
        int large = i, l = (2 * i) + 1, r = (2 * i) + 2;
        if (l < n && validate.apply(ar[l], ar[large])) large = l;
        if (r < n && validate.apply(ar[r], ar[large])) large = r;

        if (large == i) return;

        Utils.swap(ar, i, large);
        heapify(ar, large, n, validate);
    }

    enum SortOrder{
        ASCENDING,DESCENDING
    }
}
