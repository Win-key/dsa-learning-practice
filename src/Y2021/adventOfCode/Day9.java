package Y2021.adventOfCode;

import Y2021.adventOfCode.input.DataReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {

    public static void main(String[] args) throws Exception {
        Heightmap map = Heightmap.build(DataReader.readInput("/day9.txt"));
        System.out.println(" Risk Level : " + map.sumRiskLevel());
        System.out.println(" Product of three largest basic size : " + map.findBasins());
    }

    static class BasinPoint {
        private boolean included;
        private int r;
        private int c;
        private int val;
        private int size;

        public BasinPoint(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        public void included() {
            this.included = true;
        }

        public boolean isIncluded() {
            return this.included;
        }

        public void add() {
            this.size++;
        }

        public int getSize() {
            return size;
        }
        public int val() {
            return this.val;
        }
    }

    static class Heightmap {
        private int n;
        private int m;
        private BasinPoint[][] allPoints;
        private List<BasinPoint> lowPoints = new ArrayList<>();


        private Heightmap(BasinPoint[][] allPoints) {
            this.allPoints = allPoints;
            this.n = allPoints.length;
            this.m = allPoints[0].length;
        }

        public static Heightmap build(List<String> input) {
            var allPoints = new BasinPoint[input.size()][input.get(0).length()];
            for(int r = 0; r < input.size(); r++) {
                String s = input.get(r);
                var bps = new BasinPoint[s.length()];
                for (int c = 0; c < s.length(); c++) {
                    bps[c] = new BasinPoint(r, c, Integer.parseInt(s.charAt(c)+""));
                }
                allPoints[r] = bps;
            }
            return new Heightmap(allPoints);
        }


        public int sumRiskLevel() {
            int sum = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    int u = Integer.MAX_VALUE, r = Integer.MAX_VALUE, b = Integer.MAX_VALUE, l = Integer.MAX_VALUE;
                    if (col == 0) {
                        r = allPoints[row][col + 1].val();
                    } else if (col == m - 1) {
                        l = allPoints[row][col - 1].val();
                    } else {
                        r = allPoints[row][col + 1].val();
                        l = allPoints[row][col - 1].val();
                    }
                    if (row == 0) {
                        b = allPoints[row + 1][col].val();
                    } else if (row == (n - 1)) {
                        u = allPoints[row - 1][col].val();
                    } else {
                        u = allPoints[row - 1][col].val();
                        b = allPoints[row + 1][col].val();
                    }
                    int t = allPoints[row][col].val();
                    if (t < u && t < b && t < l && t < r) {
                        lowPoints.add(allPoints[row][col]);
                        sum += (t + 1);
                    }
                }
            }
            return sum;
        }

        public int findBasins() {
            return lowPoints.stream().peek(bp -> findBasins(bp, bp.r, bp.c)).map(BasinPoint::getSize).sorted(Collections.reverseOrder()).limit(3).reduce(Math::multiplyExact).get();
        }

        private void findBasins(BasinPoint root, int r, int c) {
            BasinPoint p;
            if (r >= 0 && r < n && c >= 0 && c < m
                    && (!(p = allPoints[r][c]).isIncluded()) && p.val() < 9) {
                root.add();
                p.included();
                findBasins(root, r, c + 1);
                findBasins(root, r + 1, c);
                findBasins(root, r, c - 1);
                findBasins(root, r - 1, c);
            }
        }

    }

}
