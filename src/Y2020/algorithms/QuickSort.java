package Y2020.algorithms;

import java.util.Arrays;

public class QuickSort {

	// Partition
	// Swap
	// QuickSort
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(quickSort(0,7,12,333,906,1,3,54,4,43)));
//		for(int a : quickSort(0,7,12,333,906,1,3,54,4,43)) {
//			System.out.println(a);
//		}
	}
	public static int[] quickSort(int lb, int ub, int...ar) {
		if(lb<ub) {
			int end = partition(ub, lb, ar);
			quickSort(lb, end-1,ar);
			quickSort(end+1, ub,ar);
		}
		return ar;
	}
	
	public static int partition(int ub, int lb, int...ar) {
		
//		12,333,906,1,3,54,4,43
		
		int pivot = ar[lb];
		int start = lb;
		int end = ub;
		while (start<end) {
			while (start<=ar.length-1 && ar[start]<=pivot) {
				start++;
			}
			while (end>=0 && ar[end]>pivot) {
				end--;
			}
			
			if(start < end) {
				swap(ar,start, end);
			}
		}
		swap(ar, lb, end);
		return end;	
	}

	private static void swap(int[] ar, int start, int end) {
		int temp = ar[start];
		ar[start]=ar[end];
		ar[end]=temp;
	}
	
}
