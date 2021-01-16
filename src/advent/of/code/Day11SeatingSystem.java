package advent.of.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day11SeatingSystem {

	private static void framPart1(List<List<String>> dataList) {
		AtomicBoolean atomic= new AtomicBoolean(false); 
		
		List<List<String>> dataListFramed = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {
			List<String> newData = new ArrayList<>();
			newData.add(".");
			newData.addAll(dataList.get(i));
			newData.add(".");
			
			dataList.set(i, newData);
		}
		
		List<String> dots = new ArrayList<>();
		IntStream.range(0, dataList.get(0).size()).forEach(i->dots.add("."));
		
		dataListFramed.add(dots);
		
		dataListFramed.addAll(dataList);
		dataListFramed.add(new ArrayList<>(dots));
		
		dataListFramed.forEach(System.out::println);
		List<List<String>> part1 = part1(dataListFramed, atomic);
		
		if(atomic.get()) {
			framPart1(part1);
		}else {
			List<String> data = new ArrayList<String>();
			System.out.println("Ends here");
			part1.stream().forEach(data::addAll);
			String collect = data.stream().collect(Collectors.joining(""));
			long count = collect.chars().filter(ch-> ch == '#').count();
			System.out.println(count);
		}
		
	}
	private static List<List<String>> part1(List<List<String>> dataList, AtomicBoolean atomicBoolean ) {
		List<List<String>> newDataList = new ArrayList<List<String>>();
		
		for (int outer=1; outer< dataList.size()-1; outer++) {
			List<String> newList = new ArrayList<>();
			List<String> list = dataList.get(outer);
			for (int inner=1; inner< list.size()-1; inner++) {
				
				String data = list.get(inner);
				int count = countAdjOccupied(outer, inner, dataList, list);
				if(data.equals("L") && count == 0) {
					data = "#";
					atomicBoolean.set(true);
				}else if(data.equals("#") && count >= 4) {
					data = "L";
					atomicBoolean.set(true);
				}
				
				newList.add(data);
			}
			newDataList.add(newList);
		}
		
		return newDataList;
	}
	
	private static int countAdjOccupied(int outer, int inner, List<List<String>> dataList, List<String> list) {
		int count =0;
		List<String> dataToCheck = new ArrayList<>();
		dataToCheck.addAll(dataList.get(outer-1).subList(inner-1, inner+2));// prev
		dataToCheck.addAll(dataList.get(outer+1).subList(inner-1, inner+2));// next
		dataToCheck.add(list.get(inner-1));
		dataToCheck.add(list.get(inner+1));
		
		for (String data : dataToCheck) {
			if(data.equals("#")) {
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws Exception {
		
		List<String> dataList = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day11Seating.txt"))
				.stream()
				.map(data->Arrays.asList(data.split(" ")))
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		System.out.println(dataList);
		System.out.println(dataList.size());
		
		//framPart1(dataList);
		
	}

}
