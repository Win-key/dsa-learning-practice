package GFG.matrix;

public class BoundaryElements {

    public static void main(String[] args) {
        int[][] ar = new int[4][4];
        int n = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ar[i][j] = n++;
            }
        }
        print(ar);

        ar = new int[2][4];
        n = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                ar[i][j] = n++;
            }
        }
        print(ar);

        ar = new int[1][4];
        ar[0] = new int[]{1,2,3,4};
        print(ar);

        ar = new int[4][1];
        n = 1;
        for (int i = 0; i < 4; i++) {
            ar[i][0] = n++;
        }
        print(ar);

        ar = new int[3][2];
        n = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                ar[i][j] = n++;
            }
        }
        print(ar);

    }

    private static void print(int[][] ar) {
        int n = ar.length - 1, m = ar[0].length - 1;
        if(n == 0) {
            for (int i = 0; i <= m; i++) {
                System.out.print(ar[0][i] + " ");
            }
            System.out.println();
            return;
        }
        if(m == 0) {
            for (int i = 0; i <= n; i++) {
                System.out.print(ar[i][m] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < m; i++) {
            System.out.print(ar[0][i] + " ");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ar[i][m] + " ");
        }
        for (int i = m; i > 0; i--) {
            System.out.print(ar[n][i] + " ");
        }
        for (int i = n; i > 0; i--) {
            System.out.print(ar[i][0] + " ");
        }
        System.out.println();
    }

}
