package Aoc.Y2021;

import Aoc.Y2021.input.DataReader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day1 {

    public static void main(String[] args) throws Exception {
        partA();
        partB();
    }

    private static void partA() throws Exception {
        List<String> data = DataReader.readInput("/day1A.txt");
        int count = 0, i = 1;
        for (; i < data.size(); i++) {
            if (Integer.parseInt(data.get(i)) > Integer.parseInt(data.get(i - 1))) {
                count++;
            }
        }
        System.out.println("partA : count : "+count + " , i : "+ i);
    }

    private static void partB() throws Exception {
        List<Integer> data = DataReader.readInput("/day1A.txt").stream().map(Integer::valueOf).collect(Collectors.toList());
        int count = 0, i = 3, sum = IntStream.range(0,3).map(data::get).sum();
        for (; i < data.size(); i++) {
            int t = sum - data.get(i-3) + data.get(i);
            if(t > sum) {
                count++;
            }
        }
        System.out.println("partB : count : "+count + " , i : "+ i);
    }

}
