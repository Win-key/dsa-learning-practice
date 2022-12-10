package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

// todo : refactor to handle part A and B using an array
// the array length should be 2 for part A
// and should be 10 for part B
public class Day9 extends BaseClass {

    private int hr = 0;
    private int hc = 0;
    private int tr = 0;
    private int tc = 0;
    private Set<KeyValue> mem = new HashSet<>();
    private KeyValue[] mat = new KeyValue[9];

    {
        for (int i = 0; i < mat.length; i++) {
            mat[i] = new KeyValue(0, 0);
        }
    }


    public static void main(String[] args) {
        new Day9().execute();
    }

    @Override
    public void execute() {
        List<Instruction> instructions
                = input
                .stream()
                .map(Instruction::new)
                .collect(Collectors.toList());

        mem.add(new KeyValue(tr, tc));
        for (Instruction instruction: instructions) {
            Type type = instruction.type;
            for (int i = 1; i <= instruction.value; i++) {
                switch (type) {
                    case R:
                        hc++;
                        break;
                    case L:
                        hc--;
                        break;
                    case U:
                        hr--;
                        break;
                    case D:
                        hr++;
                        break;
                }
                int tHc = hc, tHr = hr;
                for (int j = 8; j >= 0; j--) {
                    if(!isInPlanckLength(tHc, tHr, j)) {
                        moveTail(tHc, tHr, j);
                    }
                    tHc = mat[j].c; tHr = mat[j].r;
                }
            }
        }

        print(mem.size());

    }

    private boolean isInPlanckLength(int hc, int hr, int i) {
        // hr-1 < tr < hr+2
        // hc-1 < tc < hc+2
        KeyValue tail = mat[i];
        if(tail.r < hr-1 || tail.r > hr+1
        || tail.c < hc-1 || tail.c > hc+1) {
            return false;
        }
        return true;
    }

    private void moveTail(int hc, int hr, int i) {
        KeyValue tail = mat[i];
        // row/column in same, move straight
        if(hc == tail.c) {
            tail.r += tail.r > hr ? -1 : 1;
        } else if(hr == tail.r) {
            tail.c += tail.c > hc ? -1 : 1;
        }
        // move diagonally
        else {
            tail.r += hr > tail.r ? 1 : -1;
            tail.c += hc > tail.c ? 1 : -1;
        }
        if(i == 0)
            mem.add(new KeyValue(tail.r, tail.c));
    }

    static class KeyValue {
        private int r;
        private int c;

        public KeyValue(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyValue keyValue = (KeyValue) o;
            return r == keyValue.r && c == keyValue.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return r + ", " + c;
        }
    }



    static class Instruction {
        public Type type;
        public Integer value;

        public Instruction(String instruction) {
            String[] instructions = instruction.split(" ");
            this.type = Type.valueOf(instructions[0]);
            this.value = Integer.parseInt(instructions[1]);
        }

        @Override
        public String toString() {
            return  type.name() +" " + value ;
        }
    }

    static enum Type {
        R,L,U,D
    }
}
