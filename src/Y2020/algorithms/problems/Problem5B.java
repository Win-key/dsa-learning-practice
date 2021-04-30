package Y2020.algorithms.problems;

public class Problem5B {

	public static void main(String[] args) {
		
		int [] elements = {67,99, 145, 168, 5,7,12,15,23,45};
		int search =168, start= 0, end = elements.length-1;
		int pivotIndex = findPivotIndex(elements, 0, elements.length-1);// log(n)
		if(pivotIndex == -1) {
			System.out.println("Array is not sorted and rotated");
			return;
		}else if(elements[pivotIndex]==search) {
			System.out.println(pivotIndex);
			return;
		}else if(search >= elements[start] && search <= elements[pivotIndex]) {
			end = pivotIndex;
		}else {
			start = pivotIndex+1;
		}
//		System.out.println(pivotIndex+" - " + start + " - " + end );
		System.out.println(Problem5A.binarySearch(elements, start, end, search)); // log(n)
		
		// o(log(n)+log(n))= o(2log(n)) = o(log(n))
		
	}
	
	public static int findPivotIndex(int[] e, int start , int end) {
		int mid ;
		while(start <= end){
			mid = (start + end)/2;
			if(e[mid]> e[mid-1] && e[mid]>e[mid+1]) {
//				System.out.println("1." +e[mid] + " - " + e[start] +" - " + e[end] );
				return mid;
			}else if(e[mid]>=e[start]) {
//				System.out.println("2." +e[mid] + " - " + e[start] +" - " + e[end] );
				start = mid+1;				
			}else {
//				System.out.println("3." +e[mid] + " - " + e[start] +" - " + e[end] );
				end = mid-1;
			}
		}
		return -1;
	}

}
