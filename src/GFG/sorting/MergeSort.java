package GFG.sorting;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        sort(6,4,5,10,7,2);
        sort(87,48,1,83,112,98,32,21,11,10,23,48);
    }

    public static void sort(int... ar) {
        System.out.println(Arrays.toString(ar));
        divide(0, ar.length - 1, ar);
        System.out.println(Arrays.toString(ar));
    }

    private static void divide(int left, int right, int... ar) {
        if(left == right) {
            return;
        }
        int mid = (left + right) >>> 1;
        divide(left, mid, ar);
        divide(mid+1, right, ar);
        merge(left, mid, right, ar);
    }

    private static void merge(int left, int mid, int right, int... ar) {
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        // 6 | 4,5
        int k = 0;
        while (i <= mid && j <= right) {
            if(ar[i] > ar[j]) {
                temp[k++] = ar[j++];
            } else {
                temp[k++] = ar[i++];
            }
        }
        if(i <= mid) {
            while (i <= mid) {
                temp[k++] = ar[i++];
            }
        }
        if(j <= right) {
            while (j <= right) {
                temp[k++] = ar[j++];
            }
        }
        k = 0;
        for (int l = left; l <= right; l++) {
            ar[l] = temp[k++];
        }
    }

}
