package GFG.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        // Arrays toString()
        System.out.println(Arrays.toString(sort(88,2,3,4,66,33,1)));
        System.out.println(Arrays.toString(sort(1,2,3,77,99,22,33,11)));


    }

    private static int[] sort(int...ar) {
        boolean flag = true;
        int cursor = ar.length;
        while (flag) {
            flag = false;
            for (int i = 1; i < cursor; i++) {
                if (ar[i] < ar[i - 1]) {
                    ar[i] = ar[i] + ar[i - 1];
                    ar[i - 1] = ar[i] - ar[i - 1];
                    ar[i] = ar[i] - ar[i - 1];
                    flag = true;
                }
            }
            cursor--;
        }
        return ar;
    }

}
