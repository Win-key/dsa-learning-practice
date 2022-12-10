package general;

/**
 *
 * Given an integer n, calculate and return the sum of individual digits
 * of that number.
 * For example,
 * if n = 524, then 5 + 2 + 4 = 11. 11 should be returned.
 * If n = 1843, then 1 + 8 + 4 + 3 = 16. 16 should be returned.
 *
 * public static int sumOfDigits(int number) {}
 *
 */

public class SumOfDigits {


    public static int sumOfDigits(int n) {
        int result = 0;
        while (n > 0) {
            result += n%10;
            n /= 10;
        }
        return result;
    }
}
