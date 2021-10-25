package Y2021.GFG.searching;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(10, 1, 2, 3, 4, 5, 6, 10, 11, 12));
        System.out.println(binarySearchRec(10, 0, 8, 1, 2, 3, 4, 5, 6, 10, 11, 12));
    }

    public static int binarySearchRec(int x, int start, int end, int... ar) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >>> 1;
        if (ar[mid] > x) {
            end = mid - 1;
        } else if (ar[mid] < x) {
            start = mid + 1;
        } else {
            return mid;
        }
        return binarySearchRec(x, start, end, ar);
    }

    public static int binarySearch(int x, int... ar) {

        int start = 0, end = ar.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (ar[mid] > x) {
                end = mid - 1;
            } else if (ar[mid] < x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
