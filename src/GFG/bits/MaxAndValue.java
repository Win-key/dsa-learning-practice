package GFG.bits;

import java.util.Arrays;

public class MaxAndValue {

    public static void main(String[] args) {
        System.out.println("findMaxAnd (4, 8, 12, 16): " + findMaxAnd(4, 8, 12, 16));
        System.out.println("findMaxAnd (4, 8, 16, 2): " + findMaxAnd(4, 8, 16, 2));

        System.out.println("findMaxAnd2 (4): " + findMaxAnd2(4));
        System.out.println("findMaxAnd2 (4, 8, 12, 16): " + findMaxAnd2(4, 8, 12, 16));
        System.out.println("findMaxAnd2 (4, 8, 16, 2): " + findMaxAnd2(4, 8, 16, 2));
        System.out.println("findMaxAnd2 : " + findMaxAnd2(6365,4791,8264,2492,3173,38,3538,8860,8829,872,7281,6988,5857,6591,8342,3971,5353,7666,5512,3070,9518,7362,3084,1352,4113,9301,6507,1639,4668,9365,1490,1033,4155,6105,9876,3680,6142,3413,2539,4970,637,6171,1957,2845,2761,6650,6815,4466,4315,2327,3887,184));
    }

    // O(n log n)
    public static int findMaxAnd(int ... ar) {

        // n log n
        Arrays.sort(ar);
        int res = 0;

        // n
        for (int i = 1; i < ar.length; i++) {
            res = Math.max(res, ar[i-1] & ar[i]);
        }
        return res;
    }

    public static int findMaxAnd2(int ... ar) {
        int max = Arrays.stream(ar).max().getAsInt();
        int msb = getMSB(max), res = 0;
        // log n * n
        // log n
        while (msb > 0) {
            // n
            int cnt = 0, rMSB = res | msb;
            for (int i : ar) {
                cnt += (rMSB & i) == rMSB ? 1 : 0;
                if(cnt == 2) {
                    res = rMSB;
                    break;
                }
            }
            msb >>= 1;
        }

        return res;
    }

    private static int getMSB(int n) {
        int x = 1;
        while (n > 1) {
            n >>= 1;
            x <<= 1;
        }
        return x;
    }
}
