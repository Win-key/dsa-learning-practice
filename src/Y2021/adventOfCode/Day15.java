package Y2021.adventOfCode;

import Y2021.adventOfCode.input.DataReader;

import java.util.Arrays;
import java.util.List;

public class Day15 {

    private static Integer[][] mat;
    private static Integer[][] sum;
    private static boolean[][] flag;
    private static int size;


    public static void main(String[] args) throws Exception {
        List<String> input = DataReader.readInput("/day15.txt");

        mat = input
                .stream()
                .map(s -> Arrays.stream(s.split("")).map(Integer::valueOf).toArray(Integer[]::new))
                .toArray(Integer[][]::new);
        sum = new Integer[mat[0].length][mat.length];
        for (Integer[] a : sum) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        flag = new boolean[mat[0].length][mat.length];
        size = mat.length;
        System.out.println("Lowest risk level : " + sum[size - 1][size - 1]);

    }


}
