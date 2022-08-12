package general;

import utils.Utils;

public class RamanujMatrix {

    public static void main(String[] args) {
        solve(3);
        solve(5);
    }

    public static void solve(int n) {
        int[][] mat = new int[n][n];
        int total = n * n;
        // initialization of first position
        int r = n - 1;
        int c = n / 2;
        int p = 1;
        mat[r][c] = p++;

        // filling values
        while (p <= total) {
            // two rows to up
            int r1 = (r - 2 + n) % n;
            // one column to right
            int c1 = (c + 1) % n;
            // if value already present, move to one row up
            if (mat[r1][c1] > 0) {
                r1 = (r - 1 + n) % n;
                c1 = c;
            }
            mat[r1][c1] = p++;
            r = r1; c = c1;
        }

        Utils.print(mat);
    }

}
