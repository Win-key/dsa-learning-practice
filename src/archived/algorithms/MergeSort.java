package archived.algorithms;

public class MergeSort {
	
	private static void mergeSort(int[] arr, int lb, int ub) {
		if(lb==ub) return;
		int mid = (lb+ub)/2;
		mergeSort(arr, lb, mid);
		mergeSort(arr, mid+1, ub);
		merge(arr, lb, mid, ub);
	}
	
	private static void merge(int[] arr, int lb, int mid, int ub) {
		int i = lb, j = mid+1, k =lb;
		int b[] = new int[ub+1];
		while(i<=mid && j<=ub) {
			if(arr[i]<=arr[j]) {
				b[k]=arr[i];i++;
			}else {
				b[k]=arr[j];j++;
			}
			k++;
		}
		if(i>mid)
			while(j<=ub) {
				b[k]=arr[j];j++;k++;
			}
		else 
			while(i<=mid) {
				b[k]=arr[i];i++;k++;
			}
		for(int index=lb; index<=ub; index++) {
			arr[index] = b[index];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{15, 16,6,8,5};
		mergeSort(arr,0,4);
		for (int a : arr) {
			System.out.print(a+" ");
		}
	}

}
