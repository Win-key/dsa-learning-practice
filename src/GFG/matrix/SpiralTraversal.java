package GFG.matrix;

import GFG.sorting.Utils;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] ar = new int[9][9];
        int t = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ar[i][j] = t++;
            }
        }

        Utils.print(ar);

        print(ar, 0, 0, 9, 9);

        ar = new int[1][4];
        ar[0] = new int[]{1,2,3,4};
        Utils.print(ar);
        print(ar, 0, 0, 1, 4);
    }
    public static void print(int[][] mat, int i, int j, int n, int m) {
        if (n < 1 || m < 1)
            return;

        if (n == 1) {
            for (int k = j; k < m; k++) {
                System.out.print(mat[0][k] + " ");
            }
            System.out.println();
            return;
        }
        if (m == 1) {
            for (int k = j; k < n; k++) {
                System.out.print(mat[k][0] + " ");
            }
            System.out.println();
            return;
        }

        for (int k = i; k < n - 1; k++) {
            for (int l = j; l < m; l++) {
                if (k == i || l == m - 1)
                    System.out.print(mat[k][l] + " ");
            }
        }

        for (int k = n - 1; k > i; k--) {
            for (int l = m - 1; l >= j; l--) {
                if (k == m - 1 || l == j)
                    System.out.print(mat[k][l] + " ");
            }
        }

        print(mat, i + 1, j + 1, n - 1, m - 1);
    }

}
