package GFG.sorting;

import java.util.Arrays;

public class MergeFunction {

    public static void main(String[] args) {
        int[] ar = new int[] {10, 15, 20,40,8,11,55};
        merge(0, 3, 6, ar);
        System.out.println(Arrays.toString(ar));
    }

    public static int[] merge(int low, int mid , int high, int ... ar) {
        int[] b = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high)
            if(ar[i] <= ar[j]) {
                b[k++] = ar[i++];
            } else {
                b[k++] = ar[j++];
            }

        while (i <= mid)
            b[k++] = ar[i++];
        while (j <= high)
            b[k++] = ar[j++];

        for (int l = low, z = 0; l <= high; l++, z++)
            ar[l] = b[z];

        return ar;
    }

}
