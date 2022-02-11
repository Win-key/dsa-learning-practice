package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Day6 {

    public static void main(String[] args) throws Exception {
        String[] input = DataReader.readInput("/day6.txt").get(0).split(",");
        Map<Long, Long> counter = new HashMap<>();
        for (String s: input) {
            Long i = Long.valueOf(s);
            if(Objects.isNull(counter.get(i))) {
                counter.put(i, 0L);
            }
            counter.put(i, counter.get(i)+1);
        }

        for (int i = 0; i < 256 ; i++) {
            Map<Long, Long> local = new HashMap<>();
            counter.forEach((k,v) -> {
                if(k == 0) {
                    local.put(8L, (local.get(8L) != null ? local.get(8L) : 0) + v);
                    local.put(6L, (local.get(6L) != null ? local.get(6L) : 0) + v);
                } else {
                    local.put(k-1, (local.get(k-1) != null ? local.get(k-1) : 0) + v);
                }
            });
            counter = local;
        }
        System.out.println("count : " + counter.values().stream().mapToLong(Long::longValue).sum());
    }


}
