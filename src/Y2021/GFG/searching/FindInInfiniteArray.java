package Y2021.GFG.searching;

public class FindInInfiniteArray {

    public static void main(String[] args) {
        System.out.println(solve(10, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 100));
        System.out.println(solve(100, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 100));
        System.out.println(solve(99, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 100));
        System.out.println(solve(104, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 100, 101, 104, 110));
        System.out.println(solve(201, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 100, 101, 104, 110));
    }

    private static int solve(int n, int... ar) {
        int l = 0, r = 2, L = ar.length;
        while (l <= r) {
            if (l < r && ar[r] < n) {
                l = r;
                r = r * 2 >= L ? L - 1 : r * 2;
            } else {
                int mid = (l + r) >>> 1;
                if (ar[mid] > n) {
                    r = mid - 1;
                } else if (ar[mid] < n) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

}
