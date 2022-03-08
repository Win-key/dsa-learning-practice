package GFG.sorting;

import java.util.Arrays;

public class Utils {

    public static void swap(int[] ar, int i, int j) {
        if (i == j) return;
        ar[i] += ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }

    public static void print(int ... ar) {
        System.out.println(Arrays.toString(ar));
    }

    public static void print(Object o) {
        System.out.println(o);
    }


}
