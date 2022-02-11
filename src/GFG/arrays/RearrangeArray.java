package GFG.arrays;

import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {
        arrange(5, 4, 0, 2, 1, 3);
    }

    private static void arrange(int n, long... ar) {
        System.out.println(Arrays.toString(ar));
        // your code here
        for (int i = 0; i < n; i++) {
            ar[i] += (ar[(int) (ar[i] % (long) n)] % (long) n) * n;
        }
        for (int i = 0; i < n; i++) {
            ar[i] /= n;
        }
        System.out.println(Arrays.toString(ar));
    }

}
