package Y2021.GFG.searching;

import java.util.Arrays;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        /*solve2(new int[]{10, 20, 30, 40, 50}, new int[]{5, 15, 25, 30, 35, 55, 65, 75, 85});
        solve2(new int[]{5, 15, 25, 30, 35, 55, 60, 65, 75, 85}, new int[]{10, 20, 30, 38, 40, 50, 70});
        solve2(new int[]{1,2,3,4,5,6}, new int[]{7,8,9,10});
        solve2(new int[]{5,6,7,8,9,10,11,12}, new int[]{1,2,3,4});*/
        solve2(new int[]{6,7,8,9,10,11}, new int[]{1,2,3});
    }

    private static void solve(int[] a1, int[] a2) {
        if (a1.length <= a2.length) {
            int[] t = a2;
            a2 = a1;
            a1 = t;
        }
        int n1 = a1.length;
        int n2 = a2.length;
        int r1 = a1.length / 2, l1 = r1 - 1;
        int r2 = ((n1 + n2) / 2) - r1, l2 = r2 - 1;

        while (a1[r1] < a2[l2] || a2[r2] < a1[l1]) {
            r1 += a2[r2] < a1[l1] ? -1 : 1;
            l1 = r1 - 1;
            r2 = ((n1 + n2) / 2) - r1;
            l2 = r2 - 1;
        }
        int l = Math.min(a1[l1], a2[l2]);
        int r = Math.min(a1[r1], a2[r2]);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        if ((n1 + n2) % 2 == 0) {
            System.out.println((l + r) / 2);
        } else {
            System.out.println(l);
        }
    }

    private static void solve2(int[] a1, int[] a2) {
        if (a1.length > a2.length) {
            int[] t = a2;
            a2 = a1;
            a1 = t;
        }
        int n1 = a1.length, n2 = a2.length;
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low + high) >>> 1;
            int cut2 = ((n1 + n2) / 2) - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : a2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : a1[cut1];
            int r2 = cut1 == n2 ? Integer.MAX_VALUE : a2[cut2];
            if(l1 > r2) {
                high = cut1 - 1;
            } else if (l2 > r1) {
                low = cut1 + 1;
            } else {
                if((n1 + n2) % 2 == 0) {
                    System.out.println((Math.max(l1, l2) + Math.min(r1, r2)) / 2);
                } else {
                    System.out.println(Math.min(r1, r2));
                }
                break;
            }
        }

    }


}
