package Aoc.Y2022;

import Aoc.input.BaseClass;

public class Day4 extends BaseClass {
    public static void main(String[] args) {
        new Day4().execute();
    }
    @Override
    public void execute() {
        int totalA = 0;
        int totalB = 0;
        for (String rule : input) {
            String[] ranges = rule.split(",");
            int l1 = Integer.parseInt(ranges[0].split("-")[0]);
            int r1 = Integer.parseInt(ranges[0].split("-")[1]);

            int l2 = Integer.parseInt(ranges[1].split("-")[0]);
            int r2 = Integer.parseInt(ranges[1].split("-")[1]);

            if((l1 >= l2 && r1 <= r2)
                    || (l2 >= l1 && r2 <= r1)) {
                totalA++;
            }

            if(l2 <= r1 && r2 >= l1) {
                totalB++;
            }
        }

        print(totalA);
        print(totalB);

    }

}
