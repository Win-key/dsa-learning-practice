package GFG.matrix;

import utils.Utils;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] ar = new int[3][4];
        int t = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                ar[i][j] = t++;
            }
        }

        Utils.print(ar);

        print(ar);
        Utils.print("\n");
        ar = new int[1][4];
        ar[0] = new int[]{1,2,3,4};
        Utils.print(ar);
        print(ar);
    }

    public static void print(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int t = 0, b = m - 1, l = 0, r = n - 1;

        while (t <= b && l <= r ) {
            for (int i = l; i <= r; i++) {
                System.out.print(mat[t][i] + " ");
            } t++;
            for (int i = t; i <= b; i++) {
                System.out.print(mat[i][r] + " ");
            } r--;
            if(t <= b) {
                for (int i = r; i >= l; i--) {
                    System.out.print(mat[b][i] + " ");
                } b--;
            }
            if(l <= r) {
                for (int i = b; i >= t; i--) {
                    System.out.print(mat[i][l] + " ");
                } l++;
            }
        }
    }

}
