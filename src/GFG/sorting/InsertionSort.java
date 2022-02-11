package GFG.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String... args) {
        System.out.println(Arrays.toString(sort(88, 2, 3, 4, 66, 33, 1)));
        System.out.println(Arrays.toString(sort(1, 21, 88, 2, 6, 3, 11)));
        System.out.println(Arrays.toString(sort(1, 67, 45, 1, 2, 6, 3, 11)));
    }

    private static int[] sort(int... ar) {
        for (int i = 1; i < ar.length; i++) {
            int v = ar[i];
            int j = i - 1;
            for (; j >= 0 && ar[j] > v; j--) {
                ar[j + 1] = ar[j];
            }
            ar[j+1] = v;
        }
        return ar;
    }

}
