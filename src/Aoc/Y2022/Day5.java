package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day5 extends BaseClass {
    public static void main(String[] args) {
        new Day5().execute();
    }

    @Override
    public void execute() {
        partA();
        partB();
    }

    private void partA() {
        List<Stack<Character>> stacks = new ArrayList<>();
        List<List<Integer>> moves = parseData(stacks);

        for (List<Integer> move : moves) {
            for (int i = 0; i < move.get(0); i++) {
                stacks
                        .get(move.get(2) - 1)
                        .add(
                                stacks
                                        .get(move.get(1) - 1)
                                        .pop()
                        );
            }
        }
        StringBuilder sb = new StringBuilder();
        stacks.stream().map(Stack::peek).forEach(sb::append);
        print(sb.toString());
    }

    private void partB() {
        List<Stack<Character>> stacks = new ArrayList<>();
        List<List<Integer>> moves = parseData(stacks);

        for (List<Integer> move : moves) {
            Stack<Character> temp = new Stack<>();
            for (int i = 0; i < move.get(0); i++) {
                temp
                .add(
                    stacks
                    .get(move.get(1) - 1)
                    .pop()
                );
            }
            for (int i = 0; i < move.get(0); i++) {
                stacks
                .get(move.get(2) - 1)
                .add(temp.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        stacks.stream().map(Stack::peek).forEach(sb::append);
        print(sb.toString());
    }

    private List<List<Integer>> parseData(List<Stack<Character>> stacks) {
        for (int i = 0; i < 9; i++) {
            stacks.add(new Stack<>());
            if (i == 0) {
                stacks.get(i).add('D');
                stacks.get(i).add('T');
                stacks.get(i).add('R');
                stacks.get(i).add('B');
                stacks.get(i).add('J');
                stacks.get(i).add('L');
                stacks.get(i).add('W');
                stacks.get(i).add('G');
            }
            if (i == 1) {
                stacks.get(i).add('S');
                stacks.get(i).add('W');
                stacks.get(i).add('C');
            }
            if (i == 2) {
                stacks.get(i).add('R');
                stacks.get(i).add('Z');
                stacks.get(i).add('T');
                stacks.get(i).add('M');
            }
            if (i == 3) {
                stacks.get(i).add('D');
                stacks.get(i).add('T');
                stacks.get(i).add('C');
                stacks.get(i).add('H');
                stacks.get(i).add('S');
                stacks.get(i).add('P');
                stacks.get(i).add('V');
            }
            if (i == 4) {
                stacks.get(i).add('G');
                stacks.get(i).add('P');
                stacks.get(i).add('T');
                stacks.get(i).add('L');
                stacks.get(i).add('D');
                stacks.get(i).add('Z');
            }
            if (i == 5) {
                stacks.get(i).add('F');
                stacks.get(i).add('B');
                stacks.get(i).add('R');
                stacks.get(i).add('Z');
                stacks.get(i).add('J');
                stacks.get(i).add('Q');
                stacks.get(i).add('C');
                stacks.get(i).add('D');
            }
            if (i == 6) {
                stacks.get(i).add('S');
                stacks.get(i).add('B');
                stacks.get(i).add('D');
                stacks.get(i).add('J');
                stacks.get(i).add('M');
                stacks.get(i).add('F');
                stacks.get(i).add('T');
                stacks.get(i).add('R');
            }
            if (i == 7) {
                stacks.get(i).add('L');
                stacks.get(i).add('H');
                stacks.get(i).add('R');
                stacks.get(i).add('B');
                stacks.get(i).add('T');
                stacks.get(i).add('V');
                stacks.get(i).add('M');
            }
            if (i == 8) {
                stacks.get(i).add('Q');
                stacks.get(i).add('P');
                stacks.get(i).add('D');
                stacks.get(i).add('S');
                stacks.get(i).add('V');
            }
        }

        return
            input
            .stream()
            .filter(str -> str.startsWith("move"))
            .map(move -> {
                String[] str = move.split(" ");
                return Arrays.asList(Integer.parseInt(str[1]), Integer.parseInt(str[3]), Integer.parseInt(str[5]));
            })
            .collect(Collectors.toList());
    }

}
