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

    public static void print(Object o) {
        System.out.println(o);
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

}
