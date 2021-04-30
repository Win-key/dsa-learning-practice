package Y2020.advent.of.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Day9preamble {

	private static Long part1(List<Long> numbers) throws Exception{		
		int preamble = 25;
		List<Long> preambleArray = numbers.subList(0,preamble);
		
		for (int i = preamble; i < numbers.size(); i++) {
			Long sum = numbers.get(i);
			boolean sumFinder = sumFinder(preambleArray, sum);
			if(sumFinder) {
				preambleArray.remove(0);
				preambleArray.add(sum);
			}else {
				return sum;
			}
		}
		return 0L;
	}
	
	private static boolean sumFinder(List<Long> arr, Long sum) {
		Map<Long, Long> recall = new HashMap<>();
		
		for (Long el : arr) {
			if(Objects.isNull(recall.get(el))) {
				recall.put(sum-el,el);
			}else {
				return true;
			}
		}
		return false;
	}
	
	
	private static void part2(List<Long> numbers, Long sum) throws Exception {
		for (int i = 0; i < numbers.size()-1; i++) {
			Collection<Long> rangs = new TreeSet<>();
			Long tempSum = 0L;
			for (int j = i; j < numbers.size(); j++) {
				rangs.add(numbers.get(j));
				tempSum = Long.sum(tempSum, numbers.get(j));
				if(tempSum > sum) {
					break;
				}else if(tempSum.equals(sum) && rangs.size() > 1) {
					Long[] rangAr = new Long[rangs.size()];
					rangs.toArray(rangAr);
					System.out.println(rangs);
					System.out.println(Long.sum(rangAr[0] ,rangAr[rangAr.length-1]));
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		List<Long> numbers = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day9preamble.txt"))
				.stream()
				.map(data->Long.parseLong(data))
				.collect(Collectors.toList());
		Long sum = part1(numbers);
		numbers = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day9preamble.txt"))
				.stream()
				.map(data->Long.parseLong(data))
				.collect(Collectors.toList());
		part2(numbers, sum);
	}

}
