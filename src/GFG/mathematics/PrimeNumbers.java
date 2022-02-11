package GFG.mathematics;

public class PrimeNumbers {


    public static void main(String[] args) {
        System.out.println("checkPrimeNumber of 1 = " + checkPrimeNumber(1));
        System.out.println("checkPrimeNumber of 19 = " + checkPrimeNumber(19));
        System.out.println("checkPrimeNumber of 20 = " + checkPrimeNumber(20));
        System.out.println("checkPrimeNumber of 23 = " + checkPrimeNumber(23));
        System.out.println("checkPrimeNumber of 65 = " + checkPrimeNumber(65));
        System.out.println("checkPrimeNumber of 289 = " + checkPrimeNumber(289));
        System.out.println("checkPrimeNumber of 1031 = " + checkPrimeNumber(1031));
        System.out.println("checkPrimeNumber of 1223 = " + checkPrimeNumber(1223));
        System.out.println("checkPrimeNumber of 1222 = " + checkPrimeNumber(1222));
        System.out.println("checkPrimeNumber of 1217 = " + checkPrimeNumber(1217));
        System.out.println("checkPrimeNumber of 2729 = " + checkPrimeNumber(2729));
        System.out.println("checkPrimeNumber of 2728 = " + checkPrimeNumber(2728));
    }

    public static boolean checkPrimeNumber(int num) {
        if (num == 2 || num == 3)
            return true;
        if(num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        //  5 to sqrt(num) -> i * i <= num
        for (int i = 5; i * i <= num; i += 6) {
            if(num % i == 0 || num % (i+2) == 0) {
                return false;
            }
        }

        return true;
    }
}
