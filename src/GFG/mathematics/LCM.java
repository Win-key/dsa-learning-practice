package GFG.mathematics;

public class LCM {

    public static void main(String[] args) {
        System.out.println("LCM of 4, 6 = "+ findLcm(4, 6));
        System.out.println("LCM of 3, 7 = "+ findLcm(3, 7));

        System.out.println("With formula");
        System.out.println("LCM of 4, 6 = "+ findLcm(4, 6));
        System.out.println("LCM of 3, 7 = "+ findLcm(3, 7));
    }

    public static int findLcm(int a, int b) {
        int lcm = 1;
        int divisor = 1;

        while (a != 1 && b != 1 && divisor <= Math.min(a, b)) {
            if (a % divisor == 0 && b % divisor == 0) {
                lcm *= divisor;
                a /= divisor;
                b /= divisor;
            }
            divisor++;
        }

        return lcm * a * b;
    }

    /**
     * a * b = gcd(a, b) * lcm(a, b)
     *
     * lcm(a, b) = (a * b)/gcd(a, b);
     * @param a
     * @param b
     * @return
     */
    public int lcmByFormulea (int a , int b) {
        return (a * b)/HCFtoFindLargestTile.gcdWithEuclidin(a, b);
    }

}
