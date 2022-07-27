package leetcode.arrays;

import GFG.sorting.Utils;

public class CountOnes {

    public static void main(String[] args) {
        Utils.print(solve(0,0,0,0,1,1,1,1,1));
        Utils.print(solve(0,0,0,0,0,0,0,1,1));
        Utils.print(solve(0,0,0,0,0,0,0,0,0));

        Utils.print(solve(1,1,1,1,1,1,1,1,1));
    }

    public static int solve(int... ar) {
        if(ar[0] == 1) return ar.length;
        if(ar[ar.length - 1] == 0) return 0;

        int l = 0, r = ar.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if(ar[mid] == 0) {
                l = mid + 1;
            } else if(mid != 0 && ar[mid - 1] == 1) {
                r = mid - 1;
            } else {
                return ar.length - mid;
            }
        }
        return 0;
    }
}
