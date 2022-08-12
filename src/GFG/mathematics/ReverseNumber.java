package GFG.mathematics;

import utils.Utils;

public class ReverseNumber {


    public static void main(String[] args) {
        Utils.print(solve(9876));
    }

    /**
     * 9876
     *
     * mul = 10
     * 1. tmp = 6, original = 987, mul = 10
     * 2. tmp = 6 * 10 + 7 = 67 , original = 98, mul = 10
     * 3. tmp = 67, original = 98, mul = 10
     *
     * @param input
     * @return 6789
     */

    public static int solve(int input) {
        int temp = 0;
        int divider = 10;

        while (input > 0) {
            temp*= divider;
            temp += (input % divider);
            input /= divider;
        }
        return temp;
    }

}
