package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class Day11 extends BaseClass {

    static long mod = 1;
    public static void main(String[] args) {
        new Day11().execute();
    }

    @Override
    public void execute() {
        ArrayDeque<String> queue = new ArrayDeque<>(input);
        Monkey[] monkeys = new Monkey[8];
        int i = 0;

        while (!queue.isEmpty()) {
            monkeys[i++] = Monkey.build(queue, monkeys);
            mod *= monkeys[i - 1].div;
        }

        for (int j = 0; j < 10000; j++) {
            for (Monkey monkey :monkeys) {
                monkey.operate();
            }
        }

        Arrays.sort(monkeys, Comparator.comparingLong(Monkey::getHoldings).reversed());
        long monkeyBusiness = monkeys[0].holdings * monkeys[1].holdings;
        print(monkeyBusiness);
    }

    static class Monkey {
        public Monkey[] allMonkeys;
        public String name;
        public Queue<Long> items;
        public long left;
        public long right;
        public Operation operation;
        public long div;
        public int trueTarget;
        public int falseTarget;
        public long holdings;

        @Override
        public String toString() {
            return "Holds " + holdings;
        }

        public long getHoldings() { return holdings; }

        public static Monkey build(Queue<String> input, Monkey[] allMonkeys) {
            Monkey monkey = new Monkey();
            monkey.allMonkeys = allMonkeys;
            for (int i = 0; i <= 6; i++) {
                String line = input.poll();
                if(Objects.isNull(line) || line.length() == 0)
                    continue;
                switch (i) {
                    case 0:
                        monkey.name = line;
                        break;
                    case 1:
                        line = line.replaceAll("[A-Za-z\\s]+:?", "");
                        monkey.items =
                                Arrays
                                .stream(line.split(","))
                                .map(Long::valueOf).collect(Collectors.toCollection(ArrayDeque::new));
                        break;
                    case 2:
                        String[] ops = line.replaceAll("  Operation: new = ", "").split(" ");
                        if(!ops[0].equals("old")) {
                            monkey.left = Integer.parseInt(ops[0]);
                        }
                        monkey.operation = Operation.lookUp(ops[1]);
                        if(!ops[2].equals("old")) {
                            monkey.right = Integer.parseInt(ops[2]);
                        }
                        break;
                    case 3:
                        ops = line.split(" ");
                        monkey.div = Integer.parseInt(ops[ops.length - 1]);
                        break;
                    case 4:
                        monkey.trueTarget = Integer.parseInt(line, line.length()-1, line.length(), 10);
                        break;
                    case 5:
                        monkey.falseTarget = Integer.parseInt(line, line.length()-1, line.length(), 10);
                        break;
                    default:
                        // do nothing
                }
            }
            return monkey;
        }

        public void operate() {
            holdings += (long) items.size();
            while (!items.isEmpty()) {
                long newValue = operate(items.poll());
                test(newValue);
            }
        }

        private long operate(long old) {
            long tleft = this.left;
            long tright = this.right;
            tleft = tleft == 0L ? old : tleft;
            tright = tright == 0L ? old : tright;

            if(operation == Operation.ADD) {
                return (tleft + tright);
            }
            return (tleft * tright);
        }

        private void test(long value) {
            if(value % div == 0) {
                allMonkeys[trueTarget].items.add(value % mod);
            }else {
                allMonkeys[falseTarget].items.add(value % mod);
            }
        }

    }

    enum Operation {
        MULTIPLY("*"), ADD("+");
        String symbol;
        Operation(String symbol) {
            this.symbol = symbol;
        }
        public static Operation lookUp(String symbol) {
            for (Operation operation : values()) {
                if (operation.symbol.equals(symbol)) {
                    return operation;
                }
            }
            return null;
        }
    }
}
