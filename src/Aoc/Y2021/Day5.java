package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

    private static int maxX = 0;
    private static int maxY = 0;
    public static void main(String[] args) throws Exception {
        List<Integer[][]> input = DataReader.readInput("/day5.txt")
                                    .stream()
                                    .map(Day5::buildXYLines)
                                    .collect(Collectors.toList());

        int[][] mat = new int[maxX+1][maxY+1];
        int count = 0;
        for(Integer[][] line : input) {
            // Y is equal
            if(line[0][1].equals(line[1][1]) ) {
                int Y = line[0][1];
                int min = Math.min(line[0][0], line[1][0]);
                int max = Math.max(line[0][0], line[1][0]);
                for (int i = min; i <= max; i++) {
                    count += ++mat[Y][i] == 2 ? 1 : 0;
                }
            } else if(line[0][0].equals(line[1][0])) {
                int X = line[0][0];
                int min = Math.min(line[0][1], line[1][1]);
                int max = Math.max(line[0][1], line[1][1]);
                for (int i = min; i <= max; i++) {
                    count += ++mat[i][X] == 2 ? 1 : 0;
                }
            } else {
                Integer[] a = line[0], b = line[1];
                int totalMoves = Math.abs(a[0] - b[0]);
                int xInc = b[0] - a[0] > 0 ? 1 : -1;
                int yInc = b[1] - a[1] > 0 ? 1 : -1;
                for(int i = 0; i <= totalMoves; i++) {
                    count += (++mat[a[1] + (i * yInc)][a[0] + (i * xInc)]) == 2 ? 1 : 0;
                }
            }
        }
        System.out.println(count);
    }

    private static Integer[][] buildXYLines(String s) {
        String[] split = s.split(" -> ");
        Integer[][] xyLine = Arrays.stream(split).map(e -> Arrays.stream(e.split(",")).map(Integer::valueOf).toArray(Integer[]::new)).toArray(Integer[][]::new);
        for (Integer[] x : xyLine) {
            maxX = Math.max(maxX, x[0]);
            maxY = Math.max(maxY, x[1]);
        }
        return xyLine;
    }

}
