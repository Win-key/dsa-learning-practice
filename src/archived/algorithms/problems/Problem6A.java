package archived.algorithms.problems;

public class Problem6A {

	public static void main(String[] args) {
		
			int[] rotated = rotate(10,4, 1, 2 ,3 ,4 ,5 ,6 ,7,8,9,10);
			for (int i = 0; i < rotated.length; i++) {
				System.out.print(rotated[i] + " ");
			}
	}
	
	public static int[] rotate(int n, int d, int...ar) {
		if (d==0 || n==d) return ar;
		int[] temp = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i]=ar[i+d>=n ? i+d-n:i+d];
		}
		ar = temp;
		return ar;
	}

}
