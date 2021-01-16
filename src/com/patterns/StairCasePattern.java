package com.patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StairCasePattern {

	private static Map<Integer, Integer> fibMap = new HashMap<>();
	private static List<Integer> jumps = Arrays.asList(1,3);
	private static List<Integer> brokenSteps = Arrays.asList();
	
	public static void main(String[] args) {
		int stepWays = stepWays(5);
		fibMap.forEach((k,v)->System.out.print(k + "-"+v +" "));
		System.out.println();
		System.out.println("stepWays :: "+stepWays);
	}
	
	public static int stepWays(int n) {
		if(brokenSteps.contains(n))
			return 0;
		else if(Objects.nonNull(fibMap.get(n)))
			return fibMap.get(n);
		else if(n < 0) {
			return 0;
		}else if(n<=1) {
			fibMap.put(n, 1);
			return 1;
		}
		
		int ways = 0;
		for (Integer jump : jumps) {
			ways += stepWays(n-jump);
		}
		fibMap.put(n, ways);
		
		return ways;
	}

}
