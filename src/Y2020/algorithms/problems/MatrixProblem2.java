package Y2020.algorithms.problems;

public class MatrixProblem2 {

	public static void main(String[] args) {
		int n = 4;
		n = (int)Math.round(Math.pow(2, n-1));
		System.out.println(n);
		System.out.println("Pattern: ");
		
		if(n == 1) {
			System.out.println(n);
			return;
		}
		
		int [][] matrix = new int[n][n];
		int count = 0;
		
		fn(0, 0, n, matrix, count);
//		for(int i = 0; i< n; i+=2) {
//			for(int j=0;j<n; j+=2) {
//				matrix[i][j] = ++count; matrix[i][j+1] = ++count;
//				matrix[i+1][j] = ++count; matrix[i+1][j+1] = ++count;
//			}
//		}
		
//		for (int length = 1; length <= n; length=2*length) {
//			for (int i = 0; i < length; i+=2) {
//				for (int j = 0; j < length; j+=2) {
//					fillMat(i,j,length, matrix, count);
//				}
//			}
//		}
//		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static void fillMat(int R, int C, int len, int[][] mat, int count) {
		for (int i = R; i < len; i++) {
			for (int j = C; j < len; j++) {
				mat[i][j]=++count;
			}
		}
	}
	
	public static void fn(int R, int C, int l, int[][] mat, int count) {
		for (int i = R; i <= l/2; i+=l/2) {
			for (int j = C; j <= l/2; j+=l/2) {
				System.out.println(i+"--" + j);
				for (int i1 = i; i1 < i + l/2; i1++) {
					for (int j1 = j; j1 < j + l/2; j1++) {
						mat[i1][j1]=++count;
//						System.out.println(count);
					}
				}
				//fillMat(i, j, (i>j ? i : j) + l/2, mat, count);
			}
		}
	}
	
}
