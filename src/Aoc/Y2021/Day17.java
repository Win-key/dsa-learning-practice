package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

public class Day17 {


    private static int maxHeight = Integer.MIN_VALUE;
    private static int count = 0;
    private static int x1;
    private static int x2;
    private static int y1;
    private static int y2;

    public static void main(String[] args) throws Exception {
        String input = DataReader.readInput("/day17.txt").get(0);
        String[] inputX = input.substring(input.indexOf("x")+2, input.indexOf(",")).split("\\.\\.");
        String[] inputY = input.substring(input.indexOf("y")+2).split("\\.\\.");
        x1 = Integer.parseInt(inputX[0]);
        x2 = Integer.parseInt(inputX[1]);
        y1 = Integer.parseInt(inputY[1]);
        y2 = Integer.parseInt(inputY[0]);


        for (int i = 0; i <= x2; i++) {
            for (int j = y2; j <= -1*y2; j++) {
                launchProbe(i, j);
            }
        }
        // Part A
        System.out.println(maxHeight);
        // Part B
        System.out.println(count);


    }


    private static boolean launchProbe(int x, int y) {
        int max = y;
        for (int i = x, j = y; i <= x2 && j >= y2; i += (x += Integer.compare(0, x)), j += --y) {
            max = Math.max(max, j);
            if (i >= x1 && i <= x2 && j <= y1 && j >= y2) {
                maxHeight = Math.max(max, maxHeight);
                count++;
                return true;
            }
        }
        return false;
    }

}
