package GFG.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(88,2,3,4,66,33,1)));
        System.out.println(Arrays.toString(sort(1,2,3,77,99,22,33,11)));
    }

    // select an index and pick the right element for the index
    private static int[] sort(int ... ar) {
        for (int itr = 0; itr < ar.length - 1; itr++) {
            int index = itr;
            for (int i = itr+1; i < ar.length; i++) {
                if(ar[i] < ar[index])
                    index = i;
            }
            if(index != itr) {
                swap(index, itr, ar);
            }
        }
        return ar;
    }

    private static void swap(int i, int j, int...ar) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

}
