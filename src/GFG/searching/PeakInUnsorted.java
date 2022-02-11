package GFG.searching;

import java.util.Arrays;

public class PeakInUnsorted {

    public static void main(String[] args) {
        System.out.println(find(5, 20, 40, 30, 6, 70));
        System.out.println(find(15, 20, 25, 30, 6, 70, 80, 65, 90));
    }

    private static int find(int... ar) {
        System.out.println(Arrays.toString(ar));
        int l = 0, r = ar.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if ((mid == 0 || ar[mid - 1] <= ar[mid]) && (mid == ar.length - 1 || ar[mid + 1] <= ar[mid])) {
                return ar[mid];
            } else if (mid > 0 && ar[mid - 1] >= ar[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
