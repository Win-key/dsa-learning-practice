package Y2020.advent.of.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day10Joltage {

	public static void main(String[] args) throws Exception{
		List<Integer> numbers = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day10Joltage.txt"))
				.stream()
				.map(data->Integer.parseInt(data))
				.collect(Collectors.toList());

		Collections.sort(numbers);
		
		System.out.println(numbers);
		
//		part1(numbers);
		part2(numbers);
	}
	
	private static void part2(List<Integer> numbers) {
		Deque<Integer> arrayDeque = new ArrayDeque<Integer>();
		arrayDeque.addAll(numbers);
		arrayDeque.addFirst(0);
		arrayDeque.addLast(arrayDeque.getLast()+3);
		
		int ways = 0;
		Map<Integer, Integer> waysMap = new HashMap<>();
		
		for (Integer integer : arrayDeque) {
			if(arrayDeque.contains(integer+1)) {
				ways++;
			}
			if(arrayDeque.contains(integer+2)) {
				ways++;
			}
			if(arrayDeque.contains(integer+3)) {
				ways++;
			}
			
			waysMap.put(integer, ways);
			ways = 0;
		}

		while (!arrayDeque.isEmpty()) {
			Integer last = arrayDeque.pollLast();
			try {
				waysMap.put(arrayDeque.getLast(), waysMap.get(arrayDeque.getLast())+waysMap.get(last));
			}catch (Exception e) {
				System.out.println(last);
				e.printStackTrace();
			}
		}
				
		System.out.println(waysMap);
		int sum = waysMap.values().stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
	}
	
	private static void part1(List<Integer> numbers) {
		Map<Integer, Integer> diffCount = new HashMap<>();
		for (int i = 0, j = 1; j < numbers.size(); i++, j++) {
			int diff = numbers.get(j) - numbers.get(i);
			if(Objects.nonNull(diffCount.get(diff))) {
				diffCount.put(diff, diffCount.get(diff)+1);
			}else {
				diffCount.put(diff, 2);
			}
		}
		
		Integer one = diffCount.get(1);
		Integer two = diffCount.get(3);
		System.out.println(diffCount);
		System.out.println(one + " : " + two);
		System.out.println(one * two);
	}
	
}
