package GFG.matrix;

import GFG.sorting.Utils;

public class FindInSortedMatrix {

    public static void main(String[] args) {
        int[][] mat = Utils.getMatrix(5, 5);
        Utils.print(mat);
        System.out.println();
        solve(mat, 21);
    }

    public static void solve(int[][] mat, int x) {
        if(mat.length == 0) throw new IllegalArgumentException("Matrix could not be empty");

        int r = 0, c = mat[0].length - 1;
        while (r < mat.length && c >= 0) {
            int value = mat[r][c];
            if(x == value) {
                System.out.printf("Found element at (%s,%s)\n", r, c);
                return;
            } else if(x < value)
                c--;
            else
                r++;
        }
        System.out.println("Element is not found.");
    }

}
