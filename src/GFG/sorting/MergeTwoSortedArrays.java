package GFG.sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{100,129,170,190,200,229,270, 300, 321}, new int[]{1,99,111,222})));
        System.out.println(Arrays.toString(merge(new int[]{1,99,111,222}, new int[]{100,129,170,190,200,229,270, 300, 321})));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] ab = new int[a.length + b.length];
        int i = 0, j = 0, itr = 0;
        while (i<a.length && j < b.length) {
            if(a[i] <= b[j])
                ab[itr++] = a[i++];
            else
                ab[itr++] = b[j++];
        }
        if(i<a.length) {
            while (i < a.length)
                ab[itr++] = a[i++];
        }
        if(j<b.length) {
            while (j < b.length)
                ab[itr++] = b[j++];
        }
        return ab;
    }
}