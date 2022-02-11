package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Day8 {

    static Map<Integer, Integer> segmentMapper = Map.of(2, 1, 4, 4, 3, 7, 7, 8);

    public static void main(String[] args) throws Exception {
        List<SignalValue> input = DataReader.readInput("/day8.txt")
                .stream()
                .map(SignalValue::build)
                .collect(Collectors.toList());
        long uniqueCounts = input.stream().map(SignalValue::countUniqueValues).mapToLong(Long::longValue).sum();
        System.out.println("Part A :" + uniqueCounts);
        int sum = input.stream().map(SignalValue::getValueAsInt).mapToInt(Integer::intValue).sum();
        System.out.println("Part B :" + sum);

    }

    static class SignalValue {
        private List<String> signals;
        private List<String> value;

        private SignalValue(List<String> signals, List<String> value) {
            this.signals = signals;
            this.value = value;
        }

        public static SignalValue build(String s) {
            String[] ar = s.split(" \\| ");
            List<String> signals = Arrays.asList(ar[0].split(" "));
            List<String> value = Arrays.asList(ar[1].split(" "));
            return new SignalValue(signals, value);
        }

        public long countUniqueValues() {
            return value.stream().map(String::length).filter(segmentMapper::containsKey).count();
        }

        public int getValueAsInt() {
            Map<Integer, String> mem = new HashMap<>();
            for (String s : signals) {
                int l = s.length();
                if (l == 2 || l == 4 || l == 3 || l == 7) {
                    int i = l == 2 ? 1 : l == 4 ? 4 : l == 3 ? 7 : 8;
                    mem.put(i, s);
                }
            }
            for (String s : signals) {
                Set<String> set = new HashSet<>(Arrays.asList(s.split("")));
                int one = countMissSegment(mem.get(1), set);
                int four = countMissSegment(mem.get(4), set);
                int seven = countMissSegment(mem.get(7), set);
                int eight = countMissSegment(mem.get(8), set);
                int l = s.length();
                if (l == 5) {
                    mapSignalToValue(mem, s, one, four, seven, eight, 2, 3, 5);
                } else if (l == 6) {
                    mapSignalToValue(mem, s, one, four, seven, eight, 0, 6, 9);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String val : value) {
                for (Integer k : mem.keySet()) {
                    if (mem.get(k).length() == val.length() && 0 == countMissSegment(val, new HashSet<>(Arrays.asList(mem.get(k).split(""))))) {
                        sb.append(k);
                        break;
                    }
                }
            }

            System.out.println(mem);
            System.out.println(Integer.parseInt(sb.toString()));

            return Integer.parseInt(sb.toString());
        }

        private void mapSignalToValue(Map<Integer, String> mem, String s, int one, int four, int seven, int eight, int... ar) {
            for (int a : ar) {
                boolean flag = false;
                switch (a) {
                    case 2:
                        if (one == 1 && four == 2 && seven == 1 && eight == 2) {
                            mem.put(a, s);
                            flag = true;
                        }
                        break;
                    case 3:
                        if (one == 0 && four == 1 && seven == 0 && eight == 2) {
                            mem.put(a, s);
                            flag = true;
                        }
                        break;
                    case 5:
                        if (one == 1 && four == 1 && seven == 1 && eight == 2) {
                            mem.put(a, s);
                            flag = true;
                        }
                        break;
                    case 0:
                        if (one == 0 && four == 1 && seven == 0 && eight == 1) {
                            mem.put(a, s);
                            flag = true;
                        }
                        break;
                    case 6:
                        if (one == 1 && four == 1 && seven == 1 && eight == 1) {
                            mem.put(a, s);
                            flag = true;
                        }
                        break;
                    case 9:
                        if (one == 0 && four == 0 && seven == 0 && eight == 1) {
                            mem.put(a, s);
                            flag = true;
                        }
                        break;
                }
                if (flag) {
                    break;
                }
            }
        }

        private int countMissSegment(String s, Set<String> set) {
            int count = 0;
            for (String c : s.split("")) {
                if (!set.contains(c)) {
                    count++;
                }
            }
            return count;
        }


    }

}
