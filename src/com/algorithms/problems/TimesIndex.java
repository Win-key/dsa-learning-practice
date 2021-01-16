package com.algorithms.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TimesIndex {

	public static void main(String[] args) {
		int N = 10;
		Function<Integer, List<Node>> getNodeList = n->{
			List<Node> nodeList = new ArrayList<>(n);
			for (int i = 1; i <= n; i++) {
				nodeList.add(new Node(i,true));
			}
			return nodeList;
		};
		
		Map<Integer, Integer> queries = new HashMap<>();
		queries.put(0, 1);
		queries.put(3, 10);
		queries.put(100, 3);
		queries.put(105, 3);
		queries.forEach((times,index)->{
			System.out.println("Query :: "+times+" times:: "+index+" index");
			getValueTimes(times, getNodeList.apply(N), index);			
		});
	}

	
	private static void getValueTimes(int times, List<Node> arr, int valueIndex) {
		
		List<Node> list = new LinkedList<>(arr);
		for (int i = 0; i < times; i++) {
			int index = i%arr.size();
			int invertor = (i/10)%2;
			Node node = arr.get(index);
			if(invertor == 0) {
				if(index%2==0)
					node.setActive(!node.isActive());
			}else if(index%2!=0)
				node.setActive(!node.isActive());
			
			if(node.isActive()) {
				if(!list.contains(node)) {
					if(invertor == 0)
						list.add(node);
					else
						list.add(index,node);
				}
			}else 
				list.remove(node);
		}
		System.out.println(arr.toString());
		System.out.println(list.toString());
		System.out.println(list.size() >= valueIndex ? list.get(valueIndex-1) : -1);
//		System.out.println(arr.stream().filter(e->e.isActive()).collect(Collectors.toList()).get(valueIndex-1).getData());
	}

}

class Node{
	
	private int data;
	private boolean isActive;
	
	public String getData() {
		if(!isActive) return "_";
		return data+"";
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		if(!isActive) return "_";
		return data+"";
	}
	public Node(int data, boolean isActive) {
		super();
		this.data = data;
		this.isActive = isActive;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
