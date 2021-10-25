package Y2021.GFG.searching;

public class CountOccurrenceOfXinSortedAr {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{10, 20, 20, 20, 30, 30}, 0, 5, 20));
        System.out.println(solve(new int[]{10, 20, 20, 20, 30, 30}, 0, 5, 30));
        System.out.println(solve(new int[]{10, 20, 20, 20, 30, 30}, 0, 5, 10));
        System.out.println(solve(new int[]{10, 10, 10, 10, 10}, 0, 4, 10));
        System.out.println(solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 9, 10));

        System.out.println(solve2(new int[]{10, 20, 20, 20, 30, 30},20));
        System.out.println(solve2(new int[]{10, 20, 20, 20, 30, 30}, 30));
        System.out.println(solve2(new int[]{10, 20, 20, 20, 30, 30}, 10));
        System.out.println(solve2(new int[]{10, 10, 10, 10, 10}, 10));
        System.out.println(solve2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));

        System.out.println(count1sinBinary(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        System.out.println(count1sinBinary( 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        System.out.println(count1sinBinary( 0, 0, 0, 0, 1, 1, 1, 1, 1, 1));
        System.out.println(count1sinBinary( 0, 0, 0, 0));

    }


    private static int count1sinBinary(int ... ar) {
        int first = IndexOfOccurrence.findIndexOfFirstOccurrence(1, ar);
        return first < 0 ? 0 : ar.length - first;
    }

    private static int solve2(int[] ar, int x){
        int first = IndexOfOccurrence.findIndexOfFirstOccurrence(x, ar);
        if(first < 0) {
            return first;
        }
        return IndexOfOccurrence.findIndexOfLastOccurrence(x, ar) - first + 1;
    }

    // worst case it takes O(n) to visit all elements and count the occurrences
    private static int solve(int[] ar, int l, int r, int x) {
        int res = 0;
        if (l > r) {
            return res;
        }
        int mid = (l + r) >>> 1;
        if (ar[mid] > x) {
            return solve(ar, l, mid - 1, x);
        } else if (ar[mid] < x) {
            return solve(ar, mid + 1, r, x);
        } else {
            res++;
            if (mid + 1 < ar.length && ar[mid + 1] == x)
                res += solve(ar, mid + 1, r, x);
            if (mid - 1 > -1 && ar[mid - 1] == x)
                res += solve(ar, l, mid - 1, x);
        }
        return res;
    }

}
