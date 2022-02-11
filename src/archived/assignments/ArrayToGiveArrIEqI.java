package archived.assignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArrayToGiveArrIEqI {

	public static void main(String[] args) {
		
		
		Integer[] arr = {-1, -1, 4, 1, 2, 3, 9, -1, 6, -1};
		
		v1(arr);
		v2(arr);
	}
	
	private static void v2(Integer[] arr) {
		System.out.println("-------- V2 --------");
		int i = 0;
		while(i < arr.length) {
			if(arr[i] > -1 && arr[i] != i) {
				int temp = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = temp;
			}else
				i++;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void v1(Integer[] arr) {
		Map<Integer, Integer> mapper = new HashMap<>();
		
		Integer[] out = new Integer[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			mapper.put(arr[i], i);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(Objects.nonNull(mapper.get(i))){
				out[i]=i;
			}else {
				out[i]=-1;
			}
		}
		System.out.println("------ V1 ----------");
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(out));
	}

}
