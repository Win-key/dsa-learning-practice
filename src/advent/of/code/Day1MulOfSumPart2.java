package advent.of.code;

import java.util.Arrays;
import java.util.Collections;

public class Day1MulOfSumPart2 {

	
	public static void main(String[] args) {
		int sum = 2020;
		Integer[] a = {1721,
						979,
						366,
						299,
						675,
						1456};
		
		a = Day1MulOfSumPart1.arr;
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
		for (int i=0; i < a.length; i++) {
			
			for (int j = i+1, k=a.length-1; i<k; ) {
				if(sum > (a[i]+a[j]+a[k])) {
					j++;
				}else if(sum < (a[i]+a[j]+a[k])) {
					k--;
				}else {
					System.out.println("i="+a[i]+", j="+a[j]+",k="+a[k]);
					System.out.println((a[i]*a[j]*a[k]));
					return;
				}
			}
			
		}
		
	}
	
}
