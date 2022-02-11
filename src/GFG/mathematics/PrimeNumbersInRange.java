package GFG.mathematics;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersInRange {

    public static void main(String[] args) {
        System.out.println(getAllPrimeNumbers(100));
        System.out.println(getAllPrimeNumbers(15));
        System.out.println(sieveEratosthenes(100));
        System.out.println(sieveEratosthenes(15));
    }

    public static List<Integer> getAllPrimeNumbers(int num) {
        List<Integer> primes = new ArrayList<>();
        if(num >= 2) {
            primes.add(2);
        }
        if(num >= 3) {
            primes.add(3);
        }

        for(int i = 5; i <= num; i += 6) {
            if(PrimeNumbers.checkPrimeNumber(i)) {
                primes.add(i);
            }
            if(PrimeNumbers.checkPrimeNumber(i + 2)) {
                primes.add(i + 2);
            }
        }

        return primes;
    }

    public static List<Integer> sieveEratosthenes(int num) {
        List<Integer> primes = new ArrayList<>();
        boolean[] flags = new boolean[num+1];

        for (int i = 2; i <= num; i++) {
            if(!flags[i]) {
                primes.add(i);
                for (int j = i*i; j <= num; j += i) {
                    flags[j] = true;
                }
            }
        }

        return primes;
    }

}
