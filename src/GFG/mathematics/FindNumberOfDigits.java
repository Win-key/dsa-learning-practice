package GFG.mathematics;

public class FindNumberOfDigits {

    public static void main(String[] args) {
        System.out.println(ByLogarithmic(1234567890));
    }

    public static int ByLogarithmic(int n) {
        return (int)(Math.log10(n)+1);
    }

}
