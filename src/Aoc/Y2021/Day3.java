package Aoc.Y2021;

import Aoc.input.DataReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) throws Exception {
        List<Integer[]> data = DataReader.readInput("/day3.txt")
                .stream()
                .map(Day3::buildBinaryArray)
                .collect(Collectors.toList());
        int size = data.get(0).length;
        int dataHalfSize = data.size() / 2;
        partA(data, size, dataHalfSize);
        partB(data);
    }

    private static void partB(List<Integer[]> data){
        Integer o2 = parseBinary(processData(new LinkedList<>(data),0, (one, zero)-> one >= zero ? 1 : 0));
        Integer co2 = parseBinary(processData(new LinkedList<>(data),0, (one, zero)->  one >= zero ? 0 : 1));

        System.out.println(o2 * co2);
    }

    private static void partA(List<Integer[]> data, int size, int dataHalfSize) {
        int[] ones = new int[size];
        for (Integer[] binary : data) {
            for (int i = 0; i < binary.length; i++) {
                if (binary[i] == 1)
                    ones[i]++;
            }
        }
        int gamma = 0, epsilon = 0, bitValue = 1;
        for (int i = ones.length -1; i >= 0; i--) {
            int one = ones[i];
            if (one >= dataHalfSize) {
                gamma += bitValue;
            } else {
                epsilon += bitValue;
            }
            bitValue *= 2;
        }
        System.out.println(gamma * epsilon);


    }

    private static Integer[] buildBinaryArray(String str) {
        return Arrays.stream(str.split("")).map(Integer::valueOf).toArray(Integer[]::new);
    }

    private static Integer[] processData(List<Integer[]> data, int i, BiFunction<Integer, Integer, Integer> getCommonVal) {
        if (data.size() == 1) {
            return data.get(0);
        }
        int ones = 0;
        int zeros = 0;
        for (Integer[] binary : data) {
            if (binary[i] == 1)
                ones++;
            else
                zeros++;
        }
        int commonValue = getCommonVal.apply(ones, zeros);
        data.removeIf(x -> x[i]!= commonValue);
        return processData(data,i+1, getCommonVal);
    }

    private static int parseBinary(Integer[] binary) {
        int bitValue = 1, result = 0;
        for (int i = binary.length - 1; i >= 0; i--) {
            if(binary[i] == 1) {
                result += bitValue;
            }
            bitValue *= 2;
        }
        return result;
    }

}
