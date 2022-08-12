package GFG.matrix;

import utils.Utils;

public class Rotate90Degree {

    public static void main(String[] args) {
        int[][] ar = new int[4][4];
        int t = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ar[i][j] = t++;
            }
        }
        Utils.print(ar);
        rotateAntiClockwise(ar);
        Utils.print(ar);
    }

    public static void rotateAntiClockwise(int[][] mat) {
        int n = mat.length;
        //Transpose.transpose(mat);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Utils.swap(mat, i, j, j, i);
            }
        }
        // column
        for (int i = 0; i < n; i++) {
            // row
            for (int j = 0; j < n / 2; j++) {
                Utils.swap(mat, j, i, n - j - 1, i);
            }
        }
    }

    // naive
    public static void rotateAntiClockwise1(int[][] mat) {
        int n = mat.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = mat[j][n - i - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            mat[i] = temp[i];
        }
    }
}
