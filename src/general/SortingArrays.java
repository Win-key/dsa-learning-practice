package general;

import utils.Utils;

/**
 *
 * int arr1[] = {75, 7, 66, 11, 15};
 * int arr2[] = {89,1, 5, 19, 50, 100, 13};
 *
 * int arr3[] = {1,5,7,11,13,15,19,50,66,75,89,100}
 *
 */

public class SortingArrays {

    public static void main(String... arg) {
        int arr1[] = {75, 7, 66, 11, 15};
        int arr2[] = {89,1, 5, 19, 50, 100, 13};

        int[] ar3 = sortUnsortedArrays(arr1, arr2);
        Utils.print(ar3);
    }

    public static int[] sortUnsortedArrays(int[] ar1, int[] ar2) {
        int[] ar3 = new int[ar1.length + ar2.length];
        int k = 0;
        for (int i = 0; i < ar1.length; i++) {
            ar3[k++] = ar1[i];
        }
        for (int i = 0; i < ar2.length; i++) {
            ar3[k++] = ar2[i];
        }

        mergeSort(ar3, 0, ar3.length - 1);

        return ar3;
    }

    public static void mergeSort(int[] ar, int l, int r) {
        if(l >= r) {
            return;
        }
        int mid = l + r >>> 1;
        mergeSort(ar, l, mid);
        mergeSort(ar, mid + 1, r);

        merge(ar, l, mid, r);
    }

    // 1, 10   5, 9
    private static void merge(int[] ar, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while ( i <= mid && j <= r) {
            if(ar[i] <= ar[j]) {
                aux[k++] = ar[i++];
            } else {
                aux[k++] = ar[j++];
            }
        }

        while (i <= mid) {
            aux[k++] = ar[i++];
        }

        while (j <= r) {
            aux[k++] = ar[j++];
        }
        for (int m = 0; m < aux.length; m++) {
            ar[l + m] = aux[m];
        }
    }

}
