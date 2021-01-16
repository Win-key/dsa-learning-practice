package com.algorithms.problems;

import java.util.ArrayList;
import java.util.List;

public class TimesIndexV2 {
	
	public static void main(String[] args) {
		List<Integer> values = new ArrayList<>();
		for (int i = 1; i <= 13; i++) {
			values.add(i);
		}
		/*System.out.println(getValue(values,0,5));
		System.out.println(getValue(values,4,1));
		System.out.println(getValue(values,6,2));*/
		for (int i = 0; i < 31; i++) {
			System.out.println("================ "+i+" times================ ");
			for (int j = 1; j <= values.size(); j++) {
				System.out.println("Index = "+j + " value = "+getValue(values,i,j));
			}
		}
		/*System.out.println(getValue(values,10,1));
		System.out.println(getValue(values,11,1));
		System.out.println(getValue(values,14,3));
		System.out.println(getValue(values,18,5));
		System.out.println(getValue(values,20,10));
		System.out.println(getValue(values,24,3));
		System.out.println(getValue(values,28,1));
		System.out.println(getValue(values,30,1));
		System.out.println(getValue(values,33,2));
		System.out.println(getValue(values,42,1));*/

	}
	
	private static int getIndex(int n, int t, int i) {
		if(t==0) 
			return i;
		int invertor = ((t-1)/n)%2;
		t = t%n;
		if(t==0)
			t=n;
		if(invertor == 0) {
			if(t <= Math.ceil((double)n/2)) {
				if(t>=i)
					return i*2;
				else
					return i+t;
			}else 
				return 2*(t-(n/2)+1)+2*(i-1);
		}else {
			if(t < (n/2)) {
				if(i > t)
					return -1;
				else
					return (2*i)-1;	
			}else {
				int temp = 2*(t- (n/2)) +1;
				if(i <= temp)
					return i;
				else
					return (2*i)-temp;
			}
		}
	}
	
	public static int getValue(List<Integer> values , int t, int i) {
		int index = getIndex(values.size(), t, i);
		return index <= 0 || index > values.size() ? -1 : values.get(index-1);
	}

}
