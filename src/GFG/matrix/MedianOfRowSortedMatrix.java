package GFG.matrix;

import GFG.sorting.Utils;

import java.util.Arrays;

public class MedianOfRowSortedMatrix {


    public static void main(String[] args) {
        int[][] mat = Utils.getMatrix(5, 5);
        Utils.print(mat);
        int median = solve(mat);

    }

    // assumptions
    // odd element array
    // distinct elements
    public static int solve(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        // find min and max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++) {
            min = Integer.min(min, mat[i][0]);
            max = Integer.max(max, mat[i][c-1]);
        }

        // find medianPos
        int total = r * c;
        int medianPos = (total + 1) >> 1;
        while (min < max) {
            int mid = (min + max) >>> 1;
            // maintains how many elements smaller than the mid
            int midPos = 0;
            for (int i = 0; i < r; i++) {
                int smallerElements = Arrays.binarySearch(mat[i], mid) + 1;
                midPos += Math.abs(smallerElements);
            }
            if(midPos < medianPos)
                min = mid + 1;
            else
                max = mid;
        }
        Utils.print("Median of the matrix = " + min + " pos = " + medianPos);
        return min;
    }
}
