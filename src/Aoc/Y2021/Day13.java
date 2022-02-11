package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

import java.util.Arrays;
import java.util.List;

public class Day13 {

    public static void main(String[] args) throws Exception {
        List<String> input = DataReader.readInput("/day13.txt");

        Integer[][] dots = input.stream()
                .filter(s -> s.contains(","))
                .map(s -> Arrays.stream(s.split(",")).map(Integer::valueOf).toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        Fold[] folds = input.stream().filter(s -> s.startsWith("fold along"))
                .map(Fold::build)
                .toArray(Fold[]::new);

        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (Integer[] ar : dots) {
            maxX = Math.max(maxX, ar[0]);
            maxY = Math.max(maxY, ar[1]);
        }

        int[][] mat = new int[maxY + 1][maxX + 1];
        for (Integer[] ar : dots) {
            mat[ar[1]][ar[0]] = 1;
        }

// PART A
//        Fold fold = folds[0];
// PART B
        for (Fold fold : folds) {
            if (fold.direction.equals("x")) {
                for (int i = 0; i <= maxY; i++) {
                    for (int j = fold.val + 1; j <= maxX; j++) {
                        int X = (fold.val - (j % fold.val)) % fold.val;
                        mat[i][X] = Math.max(mat[i][X], mat[i][j]);
                        mat[i][j] = 0;
                    }
                }
                maxX = fold.val;
            } else {
                for (int i = fold.val + 1; i <= maxY; i++) {
                    int Y = (fold.val - (i % fold.val)) % fold.val;
                    for (int j = 0; j <= maxX; j++) {
                        mat[Y][j] = Math.max(mat[Y][j], mat[i][j]);
                        mat[i][j] = 0;
                    }
                }
                maxY = fold.val;
            }
        }

        int count = 0;
        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                count += mat[i][j] == 1 ? 1 : 0;
                System.out.print(mat[i][j] == 1 ? 1 : " ");
            }
            System.out.println();
        }
        System.out.println(count);

    }

    static class Fold {
        String direction;
        int val;

        public Fold(String direction, int val) {
            this.direction = direction;
            this.val = val;
        }

        public static Fold build(String s) {
            String[] fold = s.substring(s.indexOf('=') - 1).split("=");
            return new Fold(fold[0], Integer.parseInt(fold[1]));
        }
    }

}
