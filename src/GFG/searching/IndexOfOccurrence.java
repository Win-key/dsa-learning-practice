package GFG.searching;

import java.util.Arrays;

public class IndexOfOccurrence {

    public static void main(String[] args) {
        System.out.println(findIndexOfFirstOccurrence(20, 1, 10, 10, 10, 20, 20, 40));
        System.out.println(findIndexOfFirstOccurrence(10, 1, 10, 10, 10, 20, 20, 40));
        System.out.println(findIndexOfFirstOccurrence(15, 10, 20, 30));
        System.out.println(findIndexOfFirstOccurrence(15, 15, 15, 15));

        System.out.println(findIndexOfLastOccurrence(20, 1, 10, 10, 10, 20, 20, 40));
        System.out.println(findIndexOfLastOccurrence(10, 1, 10, 10, 10, 20, 20, 40));
        System.out.println(findIndexOfLastOccurrence(15, 10, 20, 30));
        System.out.println(findIndexOfLastOccurrence(15, 15, 15, 15));
    }

    public static int findIndexOfFirstOccurrence(int x, int... ar) {
        System.out.println(Arrays.toString(ar));
        int l = 0, h = ar.length - 1;
        while (l <= h) {
            int mid = (l + h) >>> 1;
            if (ar[mid] == x) {
                if (mid == 0 || ar[mid - 1] != x) {
                    return mid;
                } else {
                    h = mid - 1;
                }
            } else if (ar[mid] < x) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

    public static int findIndexOfLastOccurrence(int x, int... ar) {
        System.out.println(Arrays.toString(ar));
        int l = 0, h = ar.length - 1;
        while (l <= h) {
            int mid = (l + h) >>> 1;
            if (ar[mid] == x) {
                if (ar.length - 1 == mid || ar[mid + 1] != x) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else if (ar[mid] < x) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}
