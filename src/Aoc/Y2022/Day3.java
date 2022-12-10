package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.HashSet;
import java.util.Set;

public class Day3 extends BaseClass {

    public static void main(String[] args) {
         new Day3().execute();
    }

    @Override
    public void execute() {
        partA();
        partB();
    }

    private void partA() {
        int total = 0;
        for (String rucksack : input) {
            Set<Character> mem = new HashSet<>();
            Set<Character> mem2 = new HashSet<>();
            int n = rucksack.length() - 1;
            for (int i = 0; i <= n/2; i++) {
                mem.add(rucksack.charAt(i));
            }
            for (int i = 1 + n/2; i <= n; i++) {
                mem2.add(rucksack.charAt(i));
            }
            for (Character c : mem) {
                if(mem2.contains(c)) {
                    if(c >= 'a' && c <= 'z') {
                        total += (c - 'a' + 1);
                    } else {
                        total += (c - 'A' + 27);
                    }
                }
            }
        }
        print(total);
    }

    private void partB() {
        int total = 0;
        for (int i = 0; i < input.size(); i+=3) {
            Set<Character> mem1 = new HashSet<>();
            Set<Character> mem2 = new HashSet<>();
            Set<Character> mem3 = new HashSet<>();

            String rucksack = input.get(i);
            for (int j = 0; j < rucksack.length(); j++) {
                mem1.add(rucksack.charAt(j));
            }
            rucksack = input.get(i+1);
            for (int j = 0; j < rucksack.length(); j++) {
                mem2.add(rucksack.charAt(j));
            }
            rucksack = input.get(i+2);
            for (int j = 0; j < rucksack.length(); j++) {
                mem3.add(rucksack.charAt(j));
            }
            for (Character c : mem1) {
                if(mem2.contains(c) && mem3.contains(c)) {
                    if(c >= 'a' && c <= 'z') {
                        total += (c - 'a' + 1);
                    } else {
                        total += (c - 'A' + 27);
                    }
                }
            }
        }
        print(total);
    }
}
