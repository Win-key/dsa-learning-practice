package GFG.searching;

import java.util.Arrays;

public class FindTripletSum {

    public static void main(String[] args) {
        System.out.println(solve(32, 2, 3, 4, 8, 9, 20, 40));
    }

    private static boolean solve(int x, int... ar) {
        System.out.println(Arrays.toString(ar));
        for (int i = 0; i < ar.length; i++) {
            int temp = x - ar[i];
            int left = i+1, right = ar.length - 1;

            while (left < right) {
                int sum = ar[left] + ar[right];
                if (sum == temp) {
                    System.out.println(ar[i] + ":" + ar[left] + ':' + ar[right] + '=' + (ar[i] + sum));
                    return true;
                } else if (sum > temp) {
                    --right;
                } else {
                    ++left;
                }
            }
        }

        return false;
    }
}