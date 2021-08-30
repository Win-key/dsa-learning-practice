package Y2021.GFG.recursion;

public class JosephusProblem {

    public static void main(String[] args) {
        System.out.println("solve 7, 3: " + solve(7, 3));
        System.out.println("solve 5, 3: " + solve(5, 3));
        System.out.println("solve 4, 3: " + solve(4, 3));
        System.out.println("solve 3, 3: " + solve(3, 3));
        System.out.println("solve 2, 3: " + solve(2, 3));
        System.out.println("solve 4, 2: " + solve(4, 2));
        System.out.println("solve 3, 2: " + solve(3, 2));
        System.out.println("solve 5, 2: " + solve(5, 2));
    }

    public static int solve(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k + solve(n - 1, k)) % n;
    }

}
