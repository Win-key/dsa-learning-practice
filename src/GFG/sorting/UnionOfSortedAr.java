package GFG.sorting;

/**
 * Union of two sorted arrays
 * This video discusses a problem taking two sorted arrays and printing the union of the two arrays.
 *
 */

public class UnionOfSortedAr {

    public static void main(String[] args) {
        solve(new int[]{3, 5, 8}, new int[]{2, 8, 9, 10, 15});
        solve(new int[]{2, 3, 3, 3, 4, 4}, new int[]{4, 4});
    }

    private static void solve(int[] a,int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++; continue;
            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++; continue;
            }
            if(a[i] < b[j] || (a[i] == b[j] && ++j == j ))
                System.out.print(a[i++] + " ");
            else
                System.out.print(b[j++] + " ");
        }
        while (i < a.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++; continue;
            }
            System.out.print(a[i++] + " ");
        }
        while (j < b.length) {
            if (j > 0 && b[j] == b[j - 1]) {
                j++; continue;
            }
            System.out.print(b[j++] + " ");
        }
        System.out.println();
    }


}
