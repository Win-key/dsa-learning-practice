package GFG.sorting;


import utils.Utils;

// Naive way to solve this problem is
//  that quicksort the array and find the smallest diff between the elements
// that would run in nlog(n) + n
// I think, the additional n traversal can be avoided
//  if we find the min value during the partition process only.
public class MinDiff {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] ar = new int[]{1, 8, 12, 5, 18};
        sort(ar, 0, 4);
        Utils.print(ar);
        Utils.print(min);

        min = Integer.MAX_VALUE;
        ar = new int[]{ 8,15};
        sort(ar, 0, 1);
        Utils.print(ar);
        Utils.print(min);


        min = Integer.MAX_VALUE;
        ar = new int[]{ 8,-1,0,3};
        sort(ar, 0, 3);
        Utils.print(ar);
        Utils.print(min);

        min = Integer.MAX_VALUE;
        ar = new int[]{ 10};
        sort(ar, 0, 0);
        Utils.print(ar);
        Utils.print(min);
    }

    private static void sort(int[] ar, int l, int r) {
        if(l >= r) return;

        int p = partition(ar, l, r);
        sort(ar, l, p - 1);
        sort(ar, p + 1, r);
    }

    private static int partition(int[] ar, int l, int r) {
        int minLocal = Integer.MAX_VALUE;
        int cur = l - 1, p = ar[r];
        for (int i = l; i <= r; i++) {
            if (ar[i] != p) {
                minLocal = Math.min(minLocal, Math.max(ar[i], p) - Math.min(ar[i], p));
            }
            if (ar[i] <= p) {
                Utils.swap(ar, ++cur, i);
            }
        }
        min = Math.min(minLocal, min);
        return cur;
    }

}
