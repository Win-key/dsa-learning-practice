package GFG.matrix;

import GFG.sorting.Utils;

public class Transpose {

    public static void main(String[] args) {
        int[][] ar = new int[4][4];
        int t = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ar[i][j] = t++;
            }
        }

        Utils.print(ar);

        transpose(ar);

        Utils.print(ar);

        ar = new int[2][2];
        ar[0] = new int[] {1,1};
        ar[1] = new int[] {2,2};

        Utils.print(ar);
        transpose(ar);
        Utils.print(ar);

    }

    // this is the better way..
    // If we look at the matrix, the diagonal will never be changed.
    // and the elements above the diagonal ar[i][j] will be swapped to ar[j][i]
    public static void transpose(int[][] ar) {
        int n = ar.length;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                Utils.swap(ar, i, j, j, i);
    }

    // I have taken first element in each row and traversed from bottom to top from left
    // then top to bottom from right.
    public static void transpose2(int[][] ar) {
        int n = ar.length - 1;
        for (int i = 0; i <= n; i++) {
            int i1 = i, j1 = 0, i2 = 0, j2 = i;
            while (i1 > i2 && j1 < j2) {
                Utils.swap(ar, i1--, j1++, i2++, j2--);
            }
        }
        for (int i = n; i > 0; i--) {
            int i1 = i, j1 = n, i2 = n, j2 = i;
            while (i1 < i2 && j1 > j2) {
                Utils.swap(ar, i1++, j1--, i2--, j2++);
            }
        }
    }

}
