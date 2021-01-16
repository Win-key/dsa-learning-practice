package winkey.self.assignments;

import java.util.Arrays;
import java.util.Collections;

public class ArrRearng2 {
	
	/**
	 * Given an array of n elements.
	 * Our task is to write a program to rearrange the array such that 
	 * elements at even positions are greater than all elements before it and 
	 * elements at odd positions are less than all elements before it.

		Examples:
		
		Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
		Output : 4 5 3 6 2 7 1
		
		Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8} 
		Output : 4 5 2 6 1 8 1 8
	 * @param args
	 */

	public static void main(String[] args) {
		
		Integer arr[] = {1, 2, 1, 4, 5, 6, 8, 8};
//		Integer arr[] = {1, 2, 3, 4, 5, 6, 7};
		
//		v1(arr);
		v2(arr);
	}
	
	private static void v2(Integer[] arr) {
		Integer out[] = new Integer[arr.length];
		
		Arrays.sort(arr);
		int j = 0, k = arr.length-1;
		for (int i = out.length-1; i > -1 ; i--) {
			if(i%2 == 0) {
				out[i] = arr[j++];
			}else{
				out[i] = arr[k--];
			}
		}
		
		System.out.println(Arrays.toString(out));
	}

	public static void v1(Integer[] arr) {
		Integer out[] = new Integer[arr.length];
		
		Arrays.sort(arr);
		int j = 0;
		for (int i = out.length-1; i > -1 ; i--) {
			if(i%2 == 0) {
				out[i] = arr[j++];
			}
		}
		
		for (int i = 0; i < out.length; i++) {
			if(i%2 != 0) {
				out[i] = arr[j++];
			}
		}
		
		System.out.println(Arrays.toString(out));
	}

}
