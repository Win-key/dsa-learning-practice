package com.algorithms.quickfind;

import java.util.Arrays;

public class QuickFindMain {

	public static void main(String[] args) {
		QuickFind qf = new QuickFind();
		qf.union(4, 3);
		qf.union(3, 8);
		qf.union(6, 5);
		qf.union(9, 4);
		qf.union(2, 1);
		qf.union(5, 0);
		qf.union(7, 2);
		qf.union(6, 1);
		
		for(int i : qf.id)
			System.out.print(i+", ");
		
	}

}
