package GFG.searching;

public class SqrRoot {

    public static void main(String[] args) {
        System.out.println(findSqrRoot(1));
        System.out.println(findSqrRoot(4));
        System.out.println(findSqrRoot(14));
        System.out.println(findSqrRoot(25));
        System.out.println(findSqrRoot(26));
        System.out.println(findSqrRoot(50));
        System.out.println(findSqrRoot(100));
        System.out.println(findSqrRoot(120));
        System.out.println(findSqrRoot(121));
        System.out.println(findSqrRoot(144));
        System.out.println(findSqrRoot(145));
        System.out.println(findSqrRoot(158));
    }

    private static int findSqrRoot(int num) {
        System.out.print(num + " : ");
        int start = 1, end = num;
        while (start < end) {
            int mid = (start + end) >>> 1, sqr = mid * mid;
            if (start == mid || sqr == num) {
                return mid;
            } else if (sqr < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
