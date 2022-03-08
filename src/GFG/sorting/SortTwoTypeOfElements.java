package GFG.sorting;


/**
 * This video discusses a famous interview problem in which you need to segregate an array of elements containing two types of elements. The types are:
 * <p>
 * Segregate negative and positive elements.
 * Segregate even and odd elements.
 * Sort a binary array.
 */
public class SortTwoTypeOfElements {

    public static void main(String[] args) {
        int[] ar = {1, 4, 8, -1, 4, -6, 6, -4};
        Utils.print(ar);
        solve(ar);
        Utils.print(ar);
    }

    private static void solve(int... ar) {
        int pivot = partition(ar, 0, ar.length - 1, 0);
        sort(ar, 0, pivot - 1);
        sort(ar, pivot, ar.length - 1);
    }

    // Partition the ar so that neg elements moved to left and positive to right
    private static int partition(int[] ar, int l, int r, int pivot) {
        int i = l - 1, j = r + 1;
        while (true) {
            do i++; while (ar[i] < pivot);
            do j--; while (ar[j] > pivot);

            if (i >= j) return i;
            Utils.swap(ar, i, j);
        }
    }

    private static void sort(int[] ar, int l, int r) {
        if (l >= r) return;

        // 5 - 10
        // 0.36
        // 3.6 +
        int ran = (int) (Math.random() * (r - l + 1)) + l;
        int pivot = partition(ar, l, r, ar[ran]);
        sort(ar, l, pivot - 1);
        sort(ar, pivot, r);
    }
}
