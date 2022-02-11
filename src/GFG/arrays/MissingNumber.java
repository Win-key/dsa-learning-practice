package GFG.arrays;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(5, 0, -11, 2, -1, -21));
        System.out.println(missingNumber(2, 0, 1));
        System.out.println(missingNumber(1, 1));
        System.out.println(missingNumber(1, 0));
        System.out.println(missingNumber(2, 0, 1));
        System.out.println(missingNumber(2, 1, 1));
        System.out.println(missingNumber(5, 10, 100, 1000, 10000, 100000));
        System.out.println(missingNumber(6, 10, 100, 1000, 10000, 100000, 1));
        System.out.println(missingNumber(49, 25, 31, 6, -50, -21, 1, -8, -16, -1, 10, -49, 14, 14, -7, 22, 5, -39, -17, -8, 6, -10, 46, 9, -14, 8, -40, -22, -4, 47, 25, 44, -26, 6, 0, -25, 35, 3, -31, 21, 5, 30, -26, -31, 46, 17, -6, -47, -20, -21));/**/
        System.out.println(missingNumber(5, 1, 2, 3, 4, 5));
    }

    static int missingNumber(int size, int... arr) {
        // Your code here
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < size; i++) {
            arr[i]--;
        }
        System.out.println(Arrays.toString(arr));
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < size; ) {
            int j = arr[i];
            if (j >= 0 && j < size && prev != j) {
                swap(i, j, arr);
            } else {
                i++;
            }
            prev = j;
        }
        System.out.println(Arrays.toString(arr));
        int index = 0;
        while (index < size) {
            if (arr[index] < 0 || arr[index] != index) {
                return index + 1;
            }
            index++;
        }
        return index + 1;
    }

    static void swap(int i, int j, int[] arr) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

}
