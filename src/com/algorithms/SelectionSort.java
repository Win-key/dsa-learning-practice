package com.algorithms;

public class SelectionSort {
	
	public static void main(String[] args) {
		selectionSort(1,12,333,906,1,3,54,4,43);
	}
	
	public static void selectionSort(int...ar) {
		for (int i = 0; i < ar.length-1; i++) {
			int min = minIndex(ar, i);
			if(min != i) swap(ar, i, min);
			printMe(ar, i);
		}
	}
	
	private static int minIndex(int[] ar, int start) {
		int index = start;
		for (int i = start; i < ar.length-1; i++) {
			if(ar[index]>ar[i+1]) index = i+1;
		}
		return index;	
	}
	
	private static void swap(int[] ar, int aIndex, int bIndex) {
		int temp = ar[aIndex];
		ar[aIndex] = ar[bIndex];
		ar[bIndex] = temp;
	}
	
	private static void printMe(int[] ar, int index) {
		System.out.println("Pass : " + index);
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}

}
