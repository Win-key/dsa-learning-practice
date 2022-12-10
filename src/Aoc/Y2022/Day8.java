package Aoc.Y2022;

import Aoc.input.BaseClass;

public class Day8 extends BaseClass {
    public static void main(String[] args) {
        new Day8().execute();
    }
    @Override
    public void execute() {
        int r = input.size();
        int c = input.get(0).length();
        Status[][] mem = parseInput(r, c);
        partA(r, c, mem);
        partB(r, c, parseInput(r, c));
    }

    private void partB(int r, int c, Status[][] mem) {
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                int k = j-1;
                while (k>=0) {
                    if(mem[i][k].value < mem[i][j].value) {
                        mem[i][j].left++;
                    } else {
                        mem[i][j].left++;
                        break;
                    }
                    k--;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = c - 2; j >= 0; j--) {
                int k = j+1;
                while (k < c) {
                    if(mem[i][k].value < mem[i][j].value) {
                        mem[i][j].right++;
                    } else {
                        mem[i][j].right++;
                        break;
                    }
                    k++;
                }
            }
        }
        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                int k = i-1;
                while (k >= 0) {
                    if(mem[k][j].value < mem[i][j].value) {
                        mem[i][j].top++;
                    }else {
                        mem[i][j].top++;
                        break;
                    }
                    k--;
                }
            }
        }
        for (int j = 0; j < c; j++) {
            for (int i = r -2; i >= 0; i--) {
                int k = i+1;
                while (k < r) {
                    if(mem[k][j].value < mem[i][j].value) {
                        mem[i][j].bottom++;
                    }else {
                        mem[i][j].bottom++;
                        break;
                    }
                    k++;
                }
            }
        }

        int scenicScore = 0;
        for (int i = 1; i < r -1; i++) {
            for (int j = 1; j < c -1; j++) {
                scenicScore = Math.max(scenicScore, mem[i][j].scenicScore());
            }
        }
        print(scenicScore);
    }

    private void partA(int r, int c, Status[][] mem) {
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                mem[i][j].left = Math.max(mem[i][j-1].left , mem[i][j-1].value);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = c - 2; j >= 0; j--) {
                mem[i][j].right = Math.max(mem[i][j+1].right , mem[i][j+1].value);
            }
        }
        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                mem[i][j].top = Math.max(mem[i-1][j].top , mem[i-1][j].value);
            }
        }
        for (int j = 0; j < c; j++) {
            for (int i = r -2; i >= 0; i--) {
                mem[i][j].bottom = Math.max(mem[i+1][j].bottom , mem[i+1][j].value);
            }
        }

        int visible = (2 * r) + (2 * c) - 4;
        for (int i = 1; i < r -1; i++) {
            for (int j = 1; j < c -1; j++) {
                if(mem[i][j].isVisible()) {
                    visible++;
                }
            }
        }
        print(visible);
    }

    private Status[][] parseInput(int r, int c) {
        Status[][] mem = new Status[r][c];
        for (int i = 0; i < input.size(); i++) {
            String row = input.get(i);
            for (int j = 0; j < row.length(); j++) {
                mem[i][j] = new Status();
                mem[i][j].value = Integer.parseInt(row, j, j+1, 10);
            }
        }
        return mem;
    }

    static class Status {
        public int value;
        public int top;
        public int right;
        public int bottom;
        public int left;
        public boolean isVisible() {
            if(value > top
            || value > right
            || value > bottom
            || value > left) {
                return true;
            }
            return false;
        }
        public int scenicScore(){
            return top * bottom * right * left;
        }
    }

}
