package Y2020.advent.of.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Day7Bags {

	static String input = "shiny gold";
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		part2();
	}
	
	private static void part2() throws Exception{
		Map<String, ColorBag> bagMap = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day7Bags.txt"))
				.stream().map(Day7Bags::parseLine).collect(Collectors.toMap(ColorBag::getColor, ColorBag::getBag));
		
		
//		int recursiveCount = recursiveCount(bagMap.get(input), bagMap);
//		
//		System.out.println(recursiveCount);
		
		getMaxCount(input, bagMap);
	}
	
	private static void getMaxCount(String bagColor, Map<String, ColorBag> bagMap) {
		int countLocal = 0;
		ColorBag colorBag = bagMap.get(bagColor);
		BagCount bagCount = new BagCount(colorBag, 1);
		
		List<BagCount> bagCounts = new ArrayList<>();
		bagCounts.add(bagCount);
		
		while (!bagCounts.isEmpty()) {
			BagCount current = bagCounts.get(0);
			bagCounts.remove(0);
			countLocal += current.getCount();
			
			for (Entry<String, Integer> entry : current.getBag().innerBags().entrySet()) {
				bagCounts.add(new BagCount(bagMap.get(entry.getKey()), (current.getCount() * entry.getValue())));
			}
		}
		
		System.out.println(countLocal-1);
		
	}
	
	
	private static int recursiveCount(ColorBag bag, Map<String, ColorBag> bagMap){
		if(bag.innerBags().isEmpty())
			return 1;
		for (Entry<String, Integer> entry : bag.innerBags().entrySet()) {
			int recursiveCount = recursiveCount(bagMap.get(entry.getKey()), bagMap);
			System.out.println(entry);
			count = entry.getValue()+(entry.getValue() * recursiveCount);
		}
		
		return count;
	}

	private static void part1() throws Exception {

		List<ColorBag> bags = Files.readAllLines(Paths.get("D:\\Ideas2IT\\ProgramPractice\\aocInputs\\Day7Bags.txt"))
				.stream().map(Day7Bags::parseLine).collect(Collectors.toList());
		List<String> bagsHasInput = new ArrayList<>();
		Set<String> checkedBags = new HashSet<>();
		// Root level
		for (ColorBag colorBag : bags) {
			if (colorBag.hasInnerBag(input)) {
				bagsHasInput.add(colorBag.getColor());
				checkedBags.add(colorBag.getColor());
			}
		}

		while (!bagsHasInput.isEmpty()) {
			String current = bagsHasInput.get(0);
			bagsHasInput.remove(0);

			for (ColorBag colorBag : bags) {
				if (colorBag.hasInnerBag(current)) {
					bagsHasInput.add(colorBag.getColor());
					checkedBags.add(colorBag.getColor());
				}
			}
		}

		System.out.println(checkedBags);

		System.out.println("Count : " + checkedBags.size());

	}

	public static ColorBag parseLine(String line) {
		String[] baseArray = line.split("bags contain");
		String bagColor = baseArray[0].trim();
		ColorBag bag = new ColorBag(bagColor);
		baseArray[1] = baseArray[1].replace("bags", "").replace("bag", "").replace(".", "").replace("no other",
				"0 no other");
		Arrays.asList(baseArray[1].split(",")).stream().forEach(bagData -> {
			String[] split = bagData.trim().split(" ");
			bag.add(bagData.replace(split[0], "").trim(), Integer.parseInt(split[0]));
		});
		return bag;
	}
}

class ColorBag {

	private String color;
	private Map<String, Integer> innerBags = new HashMap<>();

	public String getColor() {
		return color;
	}

	public ColorBag getBag() {
		return this;
	}

	public ColorBag(String color) {
		super();
		this.color = color;
	}

	public void add(String bagColor, Integer count) {
		if (count > 0)
			innerBags.put(bagColor, count);
	}
	
	public Map<String, Integer> innerBags() {
		return innerBags;
	}

	public boolean hasInnerBag(String name) {
		return innerBags.containsKey(name);
	}

	@Override
	public String toString() {
		return "ColorBag [color=" + color + ", innerBags=" + innerBags + "]";
	}

}

class BagCount {
	
	private ColorBag bag;
	private Integer count;
	
	public BagCount(ColorBag bag, Integer count) {
		super();
		this.bag = bag;
		this.count = count;
	}
	public ColorBag getBag() {
		return bag;
	}
	public void setBag(ColorBag bag) {
		this.bag = bag;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "BagCount [bag=" + bag + ", count=" + count + "]";
	}
	
}