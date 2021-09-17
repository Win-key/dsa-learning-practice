package Y2021.GFG.arrays;

import java.util.stream.IntStream;

public class PrefixSumPractices {
    public static void main(String[] args) {
        int[] ar = {2, 8, 3, 9, 6, 5, 4};
        IntStream.range(1, ar.length).forEach(i -> ar[i] += ar[i-1]);
        System.out.println(getQueryResult(0,2, ar));
        System.out.println(getQueryResult(1,3, ar));
        System.out.println(getQueryResult(2,6, ar));
    }

    private static int getQueryResult(int x, int y, int[] ar) {
        if(x > y) {
            return 0;
        } else if(x == 0 || y == 0) {
            return ar[y];
        }
        return ar[y] - ar[x-1];
    }

}
