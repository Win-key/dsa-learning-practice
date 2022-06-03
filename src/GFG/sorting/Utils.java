package GFG.sorting;

import java.util.Arrays;

public class Utils {

    public static void swap(int[] ar, int i, int j) {
        if (i == j) return;
        ar[i] += ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }

    public static void print(int ... ar) {
        System.out.println(Arrays.toString(ar));
    }
    public static void print(int[][] ar) {
        System.out
            .println(Arrays
                .stream(ar)
                .map(a -> Arrays.stream(a)
                    .mapToObj(Integer::toString)
                    .reduce((x, y) -> (x+ " " + y)).get())
                .reduce((x, y) -> (x+ "\n" + y)).get());
        System.out.println();
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void swap(int[][] ar, int i1, int j1, int i2, int j2) {
        int temp = ar[i1][j1];
        ar[i1][j1] = ar[i2][j2];
        ar[i2][j2] = temp;
    }

    public static class Interval {
        int x;
        int y;

        private Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }

        @Override
        public String toString() {
            return "{ x : " + x +", y : " + y +'}';
        }
        static Interval of(int x, int y) {
            return new Interval(x, y);
        }
    }

    public static int[][] getMatrix(int n, int m) {
        int[][] mat = new int[n][m];
        int t = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = t++;
            }
        }
        return mat;
    }

}
