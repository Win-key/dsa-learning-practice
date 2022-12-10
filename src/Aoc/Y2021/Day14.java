package Aoc.Y2021;

import Aoc.input.DataReader;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 {

    static Map<String, String> instructionMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        List<String> input = DataReader.readInput("/day14.txt");

        String template = input.get(0);
        input.stream().skip(2).forEach(Day14::mapInstruction);

        System.out.println("Part A : " + solve(template, 10));
        System.out.println("Part B : " + solve(template, 40));

    }

    private static long solve(String template, int steps) {

        Map<String , Long> counter = new HashMap<>();
        for(int i = 0; i < template.length() - 1; i++) {
            String sub = template.substring(i, i+2);
            counter.put(sub , 1L);
        }

        for (int i = 0; i < steps; i++) {
            Map<String , Long> temp = new HashMap<>();
            for (String k : counter.keySet()) {
                long v = counter.get(k);
                String split1 = k.charAt(0) + instructionMap.get(k);
                String split2 = instructionMap.get(k) + k.charAt(1);
                temp.put(split1, temp.getOrDefault(split1, 0L) + v);
                temp.put(split2, temp.getOrDefault(split2, 0L)+ v);
            }
            counter = temp;
        }

        Map<Character , Long> charCount = new HashMap<>();
        counter.forEach((k,v) -> {
            charCount.put(k.charAt(0), charCount.getOrDefault(k.charAt(0), 0L) + v);
            charCount.put(k.charAt(1), charCount.getOrDefault(k.charAt(1), 0L) + v);
        });

        long max = 1 + charCount.values().stream().max(Comparator.comparingLong(Long::longValue)).get();
        long min = 1 + charCount.values().stream().min(Comparator.comparingLong(Long::longValue)).get();

        System.out.println(max +" "+ min);
        return (max >> 1) - (min >> 1);
    }

    private static void mapInstruction(String instruction) {
        String[] ins = instruction.split(" -> ");
        instructionMap.put(ins[0], ins[1]);
    }


    // first try which worked for part A steps = 10 and got heap space error for step = 40
    private static String processInstruction(String s) {
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < s.length() - 1; i++) {
            sb.setLength(sb.length() - 1);
            sb.append(instructionMap.get(s.substring(i, i + 2)));
        }
        return sb.toString();
    }

}
