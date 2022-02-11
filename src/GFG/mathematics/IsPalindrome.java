package GFG.mathematics;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(78987));
    }

    public static boolean isPalindrome(int n) {
        int x = 0;
        int y = n;
        while (n > 0) {
            x = n%10 + (x * 10);
            n /= 10;
        }

        return x==y;
    }

}
