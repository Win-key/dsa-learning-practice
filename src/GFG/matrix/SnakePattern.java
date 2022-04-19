package GFG.matrix;

public class SnakePattern {

    public static void main(String[] args) {
        int[][] ar = new int[5][5];
        int n = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ar[i][j] = n++;
            }
        }
        print(ar);
    }

    public static void print(int[][] ar) {
        int n = ar.length-1, init = 0, dir = 1;
        for (int i = 0; i <= n; i++) {

            for (int j = init;
                 dir == 1 ? j <= n : j >= 0;
                 j += dir) {
                System.out.print(ar[i][j] + " ");
            }

            dir *= -1;
            init = dir == 1 ? 0 : n;
        }
    }

}
