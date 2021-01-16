package com.algorithms.problems;

public class Problem6B {

	public static void main(String[] args) {
		System.out.println(sum2(10, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		System.out.println(sum2(1, 20, 2, 10));
	}
	
	// Wrong as it fails corner cases
	public static int sum(int...ar) {
		int sum = 0;
		int max = maxIndex(ar);// o(n)
		ar = Problem6A.rotate(ar.length, max+1, ar);// o(n)
		for (int i = 0; i < ar.length; i++) {// O(n)
			sum += i*ar[i];
		}
		// O(n)
		return sum;
	}
	
	public static int sum2(int...ar) {
		int maxSum = 0, temp=0;
		for (int i = 0; i < ar.length; i++) {// O(n)
			temp = 0;
			ar = Problem6A.rotate(ar.length, i, ar);
			// O(n)
			for (int j = 0; j < ar.length; j++) {// O(n)
				temp += j*ar[j];
			}
			maxSum = temp>=maxSum ? temp : maxSum; 
		}
		// O(n^2) = O(n) * (O(n)+O(n))
		return maxSum;
	}
	
	public static int sum3(int...ar) {
		int sumOfAr=0, sum=0;
		for (int i = 0; i < ar.length; i++) {
			sumOfAr += ar[i];
		}
		return sum;
	}
	
	public static int maxIndex(int[] ar) {
		int index = 0;
		for (int i = 0; i < ar.length-1; i++) {
			if(ar[index]<ar[i+1]) index = i+1;
		}
		return index;	
	}

}
