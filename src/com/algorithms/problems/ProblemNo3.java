package com.algorithms.problems;

public class ProblemNo3 {

	
	public static void main(String[] args) {
		
		int n = 100;
		System.out.println("Below Doors are opened: ");
		for(int dNo =1; dNo<=n; dNo++) {
			boolean isOpen= false;
			for (int i = 1; i <= n; i++) {
				if(dNo%i==0) 
					isOpen = !isOpen;
				
			}
			if(isOpen) 
				System.out.println(dNo);
			
		}
		
	}
	
}
