package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Day6 extends BaseClass {
    public static void main(String[] args) {
        new Day6().execute();
    }
    @Override
    public void execute() {
        Queue<Character> mem = new ArrayDeque<>();
        Set<Character> hash = new HashSet<>();
        String data = input.get(0);

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if(hash.add(c)) {
                mem.add(c);
                if(mem.size() == 14) {
                    print(i+1);
                    break;
                }
            } else {
//                hash.remove(c);
                while (!mem.isEmpty()) {
                    char top = mem.poll();
                    hash.remove(top);
                    if(top == c) {
                        break;
                    }
                }
                hash.add(c);
                mem.add(c);
            }
        }
    }

}
