package Y2021.GFG.mathematics;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static void main(String[] args) {
        System.out.println(getPrimeFactors(10));
        System.out.println(getPrimeFactors(12));
        System.out.println(getPrimeFactors(13));
        System.out.println(getPrimeFactors(315));
        System.out.println(getPrimeFactors(450));
    }

    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> primes = new ArrayList<>();
        n = getPrimesForDiv(n, primes, 2);
        n = getPrimesForDiv(n, primes, 3);

        for(int i = 1; i * i <= n; i++) {
            n = getPrimesForDiv(n, primes, (6 * i ) - 1);
            n = getPrimesForDiv(n, primes, (6 * i ) + 1);
        }

        if(n > 3) {
            primes.add(n);
        }

        return primes;
    }

    private static int getPrimesForDiv(int n, List<Integer> primes, int div) {
        while (n % div == 0){
            primes.add(div);
            n /= div;
        }
        return n;
    }

}
