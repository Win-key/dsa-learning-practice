package GFG.arrays;

import java.util.Arrays;

public class ArraySlidingWindow {

    public static void main(String[] args) {
        System.out.println(maxSumOfKConsecutive(3, 1,8,30,-5,20,7));
        System.out.println(sumExistInNonNegativeArray(33, 1, 3, 20,3,5,10));
        System.out.println(sumExistInNonNegativeArray(7, 1, 4, 0,0,3,10,5));
        System.out.println(sumExistInNonNegativeArray(3, 2, 4, 1));

        nbonacci(3, 10);
    }

    private static boolean sumExistInNonNegativeArray(int sum, int... ar) {
        System.out.println(Arrays.toString(ar));
        int currSum = 0;
        for (int i = 0, j = 0; i < ar.length;) {
            if(currSum < sum) {
                currSum += ar[i++];
            } else if(currSum > sum) {
                currSum -= ar[j++];
            } else {
                return true;
            }
        }
        return sum == currSum;
    }

    public static int maxSumOfKConsecutive(int k, int ... ar) {
        System.out.println(Arrays.toString(ar));
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += ar[i];
        }
        max = sum;
        for (int i = 0, j = 0; i < ar.length; i++) {
            sum += (ar[i] - ar[j++]);
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * It's similar to fibonnacci number
     * first n-1 values will be 0's and nth value will be 1
     * for n = 4, m = 8
     * 0 0 0 1 1 2 4 7
     *
     * O(m) time and O(n) space
     * @param n
     * @param m
     */
    public static void nbonacci(int n, int m) {
        int[] mem = new int[n];
        mem[n - 1] = 1;
        StringBuilder sb = new StringBuilder();
        Arrays.stream(mem).forEach(i -> sb.append(",").append(i));
        int sum = 1;
        for (int i = n; i <= m; i++) {
            sb.append(",").append(sum);
            int t = mem[i % n];
            sum = 2 * (mem[i % n] = sum) - t;
        }
        System.out.println(sb.substring(1));
    }

    public static void nbonacciMspace(int n, int m) {
        int[] mem = new int[m+1];
        mem[n-1] = 1;
        int sum = 1;
        for (int i = n; i <=m; i++) {
            mem[i] = sum;
            sum += (mem[i] - mem[i-n]);
        }
        Arrays.stream(mem).forEach(i->System.out.print(i+", "));
    }

}
