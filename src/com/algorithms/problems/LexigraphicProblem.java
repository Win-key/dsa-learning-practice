package com.algorithms.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class LexigraphicProblem {

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {7,3,2,8,10,1,5,6,4,11,0};
		getRearrangedArray(arr);
	}
	
	public static void getRearrangedArray(Integer[] arr) {
		// Desc sort
		Arrays.sort(arr, Collections.reverseOrder());
		
		int pos = 0, i;
		Integer[] out = new Integer[arr.length];
		
		for ( i=0; (pos+=i)<arr.length; i++) {	
			out[pos] = arr[i];
		}
		
		for (int j = 0; j < out.length; j++) {
			if(Objects.isNull(out[j])) {
				out[j] = arr[i++];
			}
		}

		pos = 0;
		for (int j = 0, k=1; j < out.length; j++,k++) {
			pos += j;
			reverse(out, pos+1, pos+k-1);
		}
		System.out.println(Arrays.toString(out));
		
	}
	
	public static void reverse(Integer[] arr, int start, int end) {
		if(start >= end)
			return;
		else if(end >= arr.length)
			return;
		
		for(int i = start, j = end; i<j; i++,j--) {
			Integer temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
