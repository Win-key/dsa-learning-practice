package Y2021.GFG.mathematics;

public class Factorial {

    public static void main(String[] args) {
        int a = 20;

        for (int i = 1; i <= a; i++) {
            System.out.println(i+"! = "+ findFactorial(i));
        }

        System.out.println(30+"! = "+ findFactorial(21));
    }

    public static long findFactorial(int n) {
        long x = 1;
        for (int i = 2; i <= n; i++) {
            x *= i;
        }
        return x;
    }

}
