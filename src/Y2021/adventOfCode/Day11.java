package Y2021.adventOfCode;

import java.util.Arrays;

public class Day11 {
    private static int flashes = 0;

    public static void main(String[] args) throws Exception {
        Integer[][] mat = DataReader.readInput("file:///C:/Users/Windows/Documents/WinKey/Practice/AdvantOfCode/day11.txt")
                .stream()
                .map(s -> Arrays.stream(s.split("")).map(Integer::valueOf).toArray(Integer[]::new))
                .toArray(Integer[][]::new);

        boolean[][] stepFlag = new boolean[10][10];
        int steps = 1;
        // used label to come out of a nested loop to next step directly
        nextStep:
        for (; ; steps++) {
            for (int r = 0; r < 10; r++) {
                for (int c = 0; c < 10; c++) {
                    updateStep(mat, stepFlag, r, c);
                }
            }
            stepFlag = new boolean[10][10];
            // Part A
            if (steps == 100) {
                System.out.println("Part A : " + flashes);
            }
            // PART B
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (mat[i][j] != 0) {
                        continue nextStep;
                    }
                }
            }

            System.out.println("Part B steps: " + steps);
            break;
        }
    }

    private static void updateStep(Integer[][] mat, boolean[][] stepFlag, int r, int c) {
        int n = 10, m = 10;
        if (r >= 0 && r < n && c >= 0 && c < m
                && !stepFlag[r][c] && (mat[r][c] += 1) > 9) {
            stepFlag[r][c] = true;
            mat[r][c] = 0;
            flashes++;
            updateStep(mat, stepFlag, r, c + 1);
            updateStep(mat, stepFlag, r, c - 1);
            updateStep(mat, stepFlag, r + 1, c);
            updateStep(mat, stepFlag, r - 1, c);
            updateStep(mat, stepFlag, r + 1, c + 1);
            updateStep(mat, stepFlag, r + 1, c - 1);
            updateStep(mat, stepFlag, r - 1, c + 1);
            updateStep(mat, stepFlag, r - 1, c - 1);
        }
    }

}
