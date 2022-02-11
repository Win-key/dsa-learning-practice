package archived.algorithms;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = insertionSort(6,1,3,54,4,43);
		
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}
	
	public static int[] insertionSort(int...ar) {
		int n = ar.length ;
		for (int i = 1; i < n; i++) {
			int j = i-1;
			int temp = ar[i];
			
			for(;j>=0 && ar[j]>temp;j--) {
				ar[j+1]=ar[j];
			}
			
			ar[j+1]=temp;
			
		}
		return ar;
	}

}
