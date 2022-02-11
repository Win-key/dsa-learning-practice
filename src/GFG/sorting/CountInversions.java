package GFG.sorting;

/**
 * This video discusses the problem of taking an unsorted array and counting the inversions in it.
 * There are two conditions for the  elements to be inverse:
 * <p>
 * arr[i] > arr[j]
 * i < j
 */

public class CountInversions {

    public static void main(String[] args) {
        solve(new int[] { 2, 4, 1, 3, 5});
        solve(new int[] { 10, 20, 30, 40, 50});
        solve(new int[] { 40, 30, 20, 10 });
        solve(new int[] { 40, 30, 20, 10 , 5});
        solve(new int[] { 4, 11, 7, 6, 1, 13, 10});
        solve(new int[] { 2, 5, 8, 11, 3, 6, 9, 13});
    }

    public static void solve(int[] ar) {
        System.out.println(divide(ar, 0, ar.length -1));
    }

    private static int divide(int[] ar, int l, int r) {
        int count = 0;
        if (l == r)
            return count;
        int mid = l + r >>> 1;
        count += divide(ar, l, mid);
        count += divide(ar, mid + 1, r);
        count += merge(ar, l, mid, r);
        return count;
    }

    private static int merge(int[] ar, int l, int mid, int r) {
        int i = l, j = mid + 1, k = 0, count = 0;
        int[] t = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (ar[i] < ar[j])
                t[k++] = ar[i++];
            else {
                t[k++] = ar[j++];
                count += (mid - i + 1);
            }
        }
        while (i <= mid)
            t[k++] = ar[i++];
        while (j <= r)
            t[k++] = ar[j++];
        k = 0; i = l;
        while (i <= r)
            ar[i++] = t[k++];
        return count;
    }

}
