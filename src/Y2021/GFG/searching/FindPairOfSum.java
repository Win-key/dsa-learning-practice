package Y2021.GFG.searching;

import java.util.Arrays;

public class FindPairOfSum {

    public static void main(String[] args) {
        System.out.println(solve(17, 2, 5, 8, 12, 30));
    }

    private static boolean solve(int x , int... ar) {
        System.out.println(Arrays.toString(ar));
        int left = 0, right = ar.length - 1;
        while (left < right) {
            int sum = ar[left] + ar[right];
            if(sum == x) {
                return true;
            } else if(sum < x) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

}
