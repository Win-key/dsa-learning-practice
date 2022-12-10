package Aoc.Y2021;

import Aoc.input.DataReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Day10 {

    private static Stack<Character> stack = new Stack<>();
    private static Map<Character, Integer> counter = new HashMap<>(Map.of(')', 0, ']', 0, '>', 0, '}', 0));
    private static Map<Character, Integer> pointsA = Map.of(')', 3, ']', 57, '}', 1197, '>', 25137);
    private static Map<Character, Character> ocMap = Map.of('(',')', '[', ']', '{', '}', '<', '>');
    private static Map<Character, Integer> pointsB = Map.of(')', 1, ']', 2, '}', 3, '>', 4);

    public static void main(String[] args) throws Exception {
        List<String> input = DataReader.readInput("/day10.txt");
        input = input.stream().filter(Predicate.not(Day10::isInvalid)).collect(Collectors.toList());
        int sum = counter.values().stream().reduce(Math::addExact).get();
        System.out.println("Part A : "+ sum);
        stack.clear();

        long[] totals = input.stream().mapToLong(Day10::processIncomplete).sorted().toArray();

        System.out.println("Part B : "+ totals[totals.length/2]);
    }

    private static long processIncomplete(String data) {
        for(int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            isInvalid(c);
        }
        long total = 0;
        while (!stack.isEmpty()) {
            total *= 5;
            total += pointsB.get(ocMap.get(stack.pop()));
        }
        return total;
    }

    private static boolean isInvalid(String data) {
        for(int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (!isInvalid(c)) {
                counter.put(c, counter.get(c) + pointsA.get(c));
                stack.clear();
                return true;
            }
        }
        return false;
    }

    private static boolean isInvalid(char c) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                case '<':
                    return Objects.nonNull(stack.push(c));
                case ')':
                    return stack.pop().equals('(');
                case ']':
                    return stack.pop().equals('[');
                case '}':
                    return stack.pop().equals('{');
                case '>':
                    return stack.pop().equals('<');
            }
            return false;
    }

}
