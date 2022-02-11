package archived.algorithms.problems;

import java.util.Scanner;

public class MatrixProblem {
	
	public static void main(String[] args) {
		
		int r , c , ci, cj;
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter No of rows");
		r = input.nextInt();
		System.out.println("Please Enter No of columns");
		c = input.nextInt();
		System.out.println("Please Enter x index of Center Point");
		ci = input.nextInt();
		System.out.println("Please Enter y index of Center Point");
		cj = input.nextInt();
		
		formMatrix(r, c, ci, cj);
		
		input.close();
		
	}
	
	private static void formMatrix(int r, int c, int ci, int cj) {
		System.out.println("Pattern: ");
		for(int i = 0; i < r; i++) {
			int rowDis = Math.abs(ci-i);
			for(int j = 0; j < c; j++) {
				int colDis = Math.abs(cj-j);
				System.out.print(Math.max(rowDis,colDis)+" ");		
			}
			System.out.println();
		}
	}

}
