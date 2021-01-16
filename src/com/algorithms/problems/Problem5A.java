package com.algorithms.problems;

public class Problem5A {

	public static void main(String[] args) {
		int[] elements = {2,5,7,12,15,23,45,67,99};
//		binarySearch(elements, 0, elements.length-1, 12);
		System.out.println(binarySearch(elements, 0, elements.length-1, 15));
		System.out.println(binarySearchLoop(elements,0, elements.length-1, 67));
	}
	
	public static int binarySearch(int[] e,int start, int end, int search){
		int index = (start+end)/2;
		if(e[index]==search) {
			return index;
		}else if(e[index] <  search) {
			start = index+1;
		}else {
			end = index-1;
		}
		if(start > end){
			return -1;
		}
		return binarySearch(e, start, end, search);
		
	}
	
	public static int binarySearchLoop(int[] e,int start, int end, int search) {
		
		while(start <= end) {
			int index = (start+end)/2;
//			System.out.println(index + " -- " + e[index]);
			if(e[index]==search) {
				return index;
			}else if(e[index] <  search) {
				start = index+1;
			}else {
				end = index-1;
			}
		}
		return -1;
	}
}
