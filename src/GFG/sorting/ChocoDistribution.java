package GFG.sorting;


import java.util.Arrays;

// This video discusses the famous Chocolate Distribution Problem based on a few rules.
public class ChocoDistribution {

    public static void main(String[] args) {
        minDiff(new int[]{7, 3, 2, 4, 9, 12, 56}, 3);
        minDiff(new int[]{3, 4, 1, 9, 56, 7, 9, 12}, 5);
    }

    // ar is the array of chocolate packets with the chocolate counts
    // m is the number of children
    private static void minDiff(int[] ar, int m) {
        System.out.println(Arrays.toString(ar));
        HoareQuickSort.sort(ar);
        int min = ar[m - 1] - ar[0];

        for (int i = 1; i < ar.length - m + 1; i++) {
            min = Math.min(min, ar[m + i - 1] - ar[i]);
        }

        System.out.println("min : " + min);
    }

}
