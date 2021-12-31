package Y2021.adventOfCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day22 extends BaseClass {

    @Override
    public void execute() {

        List<Instruction> instructions = input.stream().map(Instruction::parse).collect(Collectors.toList());

        //partA(instructions);
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> z = new ArrayList<>();

        for (Instruction ins : instructions) {
            x.add(ins.x1);
            x.add(ins.x2);
            y.add(ins.y1);
            y.add(ins.y2);
            z.add(ins.z1);
            z.add(ins.z2);
        }
        Collections.sort(x);
        Collections.sort(y);
        Collections.sort(z);

        int[][][] xyz = new int[x.size()][y.size()][z.size()];

        for (Instruction ins : instructions) {
            int x1 = x.indexOf(ins.x1);
            int x2 = x.indexOf(ins.x2);
            int y1 = y.indexOf(ins.y1);
            int y2 = y.indexOf(ins.y2);
            int z1 = z.indexOf(ins.z1);
            int z2 = z.indexOf(ins.z2);

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    for (int k = z1; k < z2; k++) {
                        xyz[i][j][k] = ins.on ? 1 : 0;
                    }
                }
            }
        }

        long count = 0;
        for (int i = 0; i < x.size() - 1; i++) {
            for (int j = 0; j < y.size() - 1; j++) {
                for (int k = 0; k < z.size() - 1; k++) {
                    count += (long) xyz[i][j][k] *  (x.get(i + 1) - x.get(i)) * (y.get(j + 1) - y.get(j)) * (z.get(k + 1) - z.get(k));
                }
            }
        }

        System.out.println(count);

    }

    private void partA(List<Instruction> instructions) {
        int size = 101;
        int[][][] xyz = new int[size][size][size];

        for (Instruction ins : instructions) {
            for (int i = ins.x1; i < ins.x2; i++) {
                for (int j = ins.y1; j < ins.y2; j++) {
                    for (int k = ins.z1; k < ins.z2; k++) {
                        if (ins.on) {
                            xyz[i + 50][j + 50][k + 50] = 1;
                        } else {
                            xyz[i + 50][j + 50][k + 50] = 0;
                        }
                    }
                }
            }
        }


        long count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (xyz[i][j][k] > 0) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    static class Instruction {

        boolean on;
        int x1;
        int x2;
        int y1;
        int y2;
        int z1;
        int z2;

        public Instruction(boolean on, int x1, int x2, int y1, int y2, int z1, int z2) {
            this.on = on;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.z1 = z1;
            this.z2 = z2;
        }

        public int min() {
            return Math.min(x1, Math.min(y1, z1));
        }

        public int max() {
            return Math.max(x2, Math.max(y2, z2));
        }

        public boolean isInRange() {
            int from = -50, to = 50;
            if (x1 < from || x1 > to || x2 < from || x2 > to ||
                    y1 < from || y1 > to || y2 < from || y2 > to ||
                    z1 < from || z1 > to || z2 < from || z2 > to) {
                return false;
            }
            return true;
        }

        public static Instruction parse(String s) {
            boolean on = s.startsWith("on");
            String[] xyz = s.substring(s.indexOf("x")).split(",");

            String[] x = xyz[0].split("\\.\\.");
            int x1 = Integer.parseInt(x[0].substring(2));
            int x2 = Integer.parseInt(x[1]) + 1;

            String[] y = xyz[1].split("\\.\\.");
            int y1 = Integer.parseInt(y[0].substring(2));
            int y2 = Integer.parseInt(y[1]) + 1;

            String[] z = xyz[2].split("\\.\\.");
            int z1 = Integer.parseInt(z[0].substring(2));
            int z2 = Integer.parseInt(z[1]) + 1;

            return new Instruction(on, x1, x2, y1, y2, z1, z2);
        }

        @Override
        public String toString() {
            return "on=" + on +
                    ", x1=" + x1 +
                    ", x2=" + x2 +
                    ", y1=" + y1 +
                    ", y2=" + y2 +
                    ", z1=" + z1 +
                    ", z2=" + z2;
        }
    }


    public static void main(String[] args) {
        new Day22().execute();
    }
}
