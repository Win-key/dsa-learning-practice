package Aoc.Y2022;

import Aoc.input.BaseClass;

/**
 *
 *
 *
 * 17940
 *  ###  ##  ###   ##    ## ####   ## ####
 *    # #  # #  # #  #    # #       #    #
 *   #  #    ###  #  #    # ###     #   #
 *  #   #    #  # ####    # #       #  #
 * #    #  # #  # #  # #  # #    #  # #
 * ####  ##  ###  #  #  ##  #     ##  ####
 *
 *
 */
public class Day10 extends BaseClass {
    private int x = 1;
    private int sum = 0;
    private int cycle = 0;
    private int interval = 20;
    private int sprite  = 0;
    private int[][] crt = new int[6][40];

    public static void main(String[] args) {
        new Day10().execute();
    }

    @Override
    public void execute() {
        partA();
        partB();
    }

    private void partB() {
        cycle = 0;
        for (String instruction : input) {
            if (instruction.startsWith("noop")) {
                cycle++;
                drawPixel();
            } else {
                int value = Integer.parseInt(instruction.split(" ")[1]);
                for (int i = 0; i < 2; i++) {
                    cycle++;
                    if(i == 1) {
                        x += value;
                        sprite += value;
                    }
                    drawPixel();
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(crt[i][j] == 1 ? '#' : ' ');
            }
            System.out.println();
        }
    }

    private void drawPixel() {
        int r = cycle / 40;
        int c = cycle % 40;

        if(c >= sprite && c <= sprite+2) {
            crt[r][c] = 1;
        }
    }

    private void partA() {
        for (String instruction : input) {
            if (instruction.startsWith("noop")) {
                cycle++;
                addSum();
            } else {
                int value = Integer.parseInt(instruction.split(" ")[1]);
                for (int i = 0; i < 2; i++) {
                    cycle++;
                    if(i == 1) {
                        x += value;
                    }
                    addSum();
                }
            }
        }

        print(sum);
    }

    private void addSum() {
        if(cycle == interval && interval <= 220) {
            int signalStrength = cycle * x;
            sum += signalStrength;
            interval+=40;
        }
    }
}
