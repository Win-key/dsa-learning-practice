package archived.algorithms;

public class BubbleSort {

	
	public static int[] sort(int ...data) {
		int status = 0;
		do{
			status = 0;
			for (int i = 0; i < data.length-1; i++) {
				if (data[i]>data[i+1]) {
					int temp = data[i];
					data[i]=data[i+1];
					data[i+1] = temp;
					status++;
				}
			}
		}while ( status>0 );
		
		return data;
	}
	
	public static void main(String[] args) {
		
		int [] data = sort(7,4,0,2,6,8,3,8,5,9,-1);
		
		for (int i = 0; i < data.length; i++) 
			System.out.print(data[i] + " , ");
		 
	}

}
