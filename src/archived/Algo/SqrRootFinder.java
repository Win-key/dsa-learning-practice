package archived.Algo;

public class SqrRootFinder {

    public static void main(String[] args) {
        int sqrt = mySqrt(2147395599);
        System.out.println(sqrt);
    }

    public static int mySqrt(int x) {
        int start = 0, end = x;
        while(start <= end) {
            int mid = (start + end)/2;
            long sqr = (long) mid * mid;
            if(sqr == x || start+1 == end){
                return mid;
            }else if(sqr > x) {
                end = mid;
            }else {
                start = mid;
            }
        }
        return 0;
    }

}
