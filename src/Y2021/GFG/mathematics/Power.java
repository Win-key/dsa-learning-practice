package Y2021.GFG.mathematics;

public class Power {

    public static void main(String[] args) {
        System.out.println(power(2, 8));
        System.out.println(power(3, 8));
        System.out.println(power(3, 7));
        System.out.println(power(3, 9));
        System.out.println(power(3, 13));
        System.out.println(power(3, 16));

        System.out.println("powerIterative :: ");
        System.out.println(powerIterative(2, 8));
        System.out.println(powerIterative(3, 8));
        System.out.println(powerIterative(3, 7));
        System.out.println(powerIterative(3, 9));
        System.out.println(powerIterative(3, 13));
        System.out.println(powerIterative(3, 16));
        System.out.println(powerIterative(2, 12));
    }


    // T(n/2) = log n

    /**
     * if (n % 2 == 0 )
     *     pow = pow(x, n/2) * pow(x, n/2);
     * else
     *     pow = pow(x, n-1) * x
     * @param x
     * @param n
     * @return
     */
    public static long power(int x, int n) {
        if(n <= 0) {
            return 1;
        }

        if(n % 2 == 0) {
            long val = power(x, n/2);
            return val * val;
        } else {
            return power(x, n - 1) * x;
        }
    }

    public static long powerIterative(int x, int n) {
        long res = 1;

        while (n > 0) {
            if((n & 1) == 1) {
                res *= x;
            }
            n >>= 1;
            x *= x;
        }

        return res;
    }

}
