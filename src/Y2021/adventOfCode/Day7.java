package Y2021.adventOfCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

public class Day7 {

    public static void main(String[] args) throws Exception {
        int[] input = Arrays.stream(DataReader.readInput("file:///C:/Users/Windows/Documents/WinKey/Practice/AdvantOfCode/day7.txt")
                .get(0).split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<Integer, Integer> counter = new HashMap<>();
        int max = -1;
        for (int i : input) {
            if (Objects.isNull(counter.get(i))) {
                counter.put(i, 0);
            }
            counter.put(i, counter.get(i) + 1);
            max = Math.max(max, i);
        }
        solve(counter, max, (i, j) -> Math.abs(i - j));
        solve(counter, max, (i, j) -> {
            int n = Math.abs(i - j);
            return (n * (n + 1)) / 2;
        });
    }

    private static void solve(Map<Integer, Integer> counter, int max, BiFunction<Integer, Integer, Integer> eval) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= max; i++) {
            AtomicInteger count = new AtomicInteger(0);
            int I = i;
            counter.forEach((k, v) -> {
                if (k != I) {
                    count.addAndGet(eval.apply(k, I) * v);
                }
            });
            min = Math.min(min, count.get());
        }
        System.out.println(min);
    }


}
