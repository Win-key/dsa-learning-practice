package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.HashMap;
import java.util.Map;

public class Day2 extends BaseClass {
    public static void main(String[] args) {
        new Day2().execute();
    }
    static Map<Character, Integer> map = new HashMap<>();
    {
        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('X', 0);
        map.put('Y', 1);
        map.put('Z', 2);
    }

    @Override
    public void execute() {
        partA();
        partB();
    }

    private void partB() {
        int total = 0;
        for (String str : input) {
            int p1 = map.get(str.charAt(0));
            int p2 = findShape(p1, str.charAt(2));
            if (p1 == p2) {
                total += (p2 + 1 + 3);
            } else if((p1 - 1 +3)%3 == p2) {
                total += (p2 + 1);
            } else {
                total += (p2 + 1 + 6);
            }
        }
        print(total);
    }

    private void partA() {
        int total = 0;
        for (String str : input) {
            int p1 = map.get(str.charAt(0));
            int p2 = map.get(str.charAt(2));
            if (p1 == p2) {
                total += (p2 + 1 + 3);
            } else if((p1 - 1 +3)%3 == p2) {
                total += (p2 + 1);
            } else {
                total += (p2 + 1 + 6);
            }
        }
        print(total);
    }

    private static int findShape(int p1, Character rule) {
        if(rule == 'X') {
            return (p1 - 1 +3)%3;
        }
        if(rule == 'Z') {
            return  (p1 + 1)%3;
        }
        return p1;
    }

}
