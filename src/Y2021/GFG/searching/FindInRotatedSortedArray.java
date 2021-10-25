package Y2021.GFG.searching;

public class FindInRotatedSortedArray {

    public static void main(String[] args) {
        int i = find(10, 0, 6, 100, 200, 500, 1000, 2000, 10, 20);
        System.out.println(i);

        i = find(20, 0, 6, 100, 200, 500, 1000, 2000, 10, 20);
        System.out.println(i);

        i = find(200, 0, 6, 100, 200, 500, 1000, 2000, 10, 20);
        System.out.println(i);

        i = find(500, 0, 6, 100, 200, 500, 1000, 2000, 10, 20);
        System.out.println(i);

        i = find(1, 0, 6, 2, 3, 4, 5, 6, 7, 1);
        System.out.println(i);

        i = find(100, 0, 6, 2, 3, 4, 5, 6, 7, 1);
        System.out.println(i);

        i = find(500, 0, 6,  1000, 2000, 10, 20, 100, 200, 500);
        System.out.println(i);

        i = find(1000, 0, 6,  1000, 2000, 10, 20, 100, 200, 500);
        System.out.println(i);

        i = find(50, 0, 6,  100, 200, 300, 400, 20, 30, 40);
        System.out.println(i);

        i = find(40, 0, 6,  100, 200, 300, 400, 20, 30, 40);
        System.out.println(i);
    }

    private static int find2(int x, int l, int r, int... ar) {
        if(l > r) {
            return -1;
        }
        int mid = (l + r) >>> 1;
        if (ar[mid] == x) {
            return mid;
        }
        if (ar[mid] >= ar[l] && x <= ar[mid] && x >= ar[l]) {
            return BinarySearch.binarySearchRec(x, l, mid, ar);
        }
        return find2(x, mid + 1, r, ar);
    }

    private static int find(int x, int l, int r, int... ar) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (ar[mid] == x) {
                return mid;
            }
            if (ar[mid] >= ar[l]) {
                if(x <= ar[mid] && x >= ar[l]) {
                    // return BinarySearch.binarySearchRec(x, l, mid-1, ar);
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (x >= ar[mid] && x <= ar[r]) {
                    l = mid + 1;
                    // return BinarySearch.binarySearchRec(x, mid+1, r, ar);
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
