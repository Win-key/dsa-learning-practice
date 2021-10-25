package Y2021.GFG.arrays;

public class EquilibriumPoint {

    public static void main(String[] args) {
        System.out.println(solve(1,3,5,2,2));
        System.out.println(solve(2,4,1,2,-1));
        System.out.println(solve(2,-4,2,5));
        System.out.println(solve(1,2,3,6));
        System.out.println(solve(1,2,3,5,6));
    }

    private static int solve(int... ar) {
        for (int i = 1; i < ar.length; i++) {
            ar[i] += ar[i - 1];
        }
        int sum = 0;
        for (int i = ar.length-1; i > 0; i--) {
            if(sum == ar[i-1]) {
                return i;
            }
            sum += (ar[i] - ar[i-1]);
        }
        return -1;
    }

}
