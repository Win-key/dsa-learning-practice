package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 extends BaseClass {
    public static void main(String[] args) {
        new Day1().execute();
    }
    @Override
    public void execute() {
        List<Integer> calories = new ArrayList<>();
        int max = 0, temp = 0;
        for (String cal :input) {
            if ("".equals(cal)) {
                max=Math.max(max, temp);
                calories.add(temp);
                temp = 0;
            } else {
                temp += Integer.parseInt(cal);
            }
        }
        if(max < temp) {
            calories.add(temp);
            max = temp;
        }

        print(max);
        int top3 = calories.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce((l,r) -> l + r)
                .get();
        print(top3);
    }

}
