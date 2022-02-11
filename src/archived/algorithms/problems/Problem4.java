package archived.algorithms.problems;

import java.util.Arrays;
import java.util.List;

public class Problem4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t =getNoOfWay(7, 2, Arrays.asList(new Integer[] {}));
		System.out.println(t);
	}
	
	
	public static int getNoOfWay(int n, int k, List<Integer> d) {
		if(d.contains(n)) return 0;
		if(n == 1) return 1;
		int temp = 0;
		for (int i = 1; i <= k; i++) {
			if(n-i > 0) temp += getNoOfWay(n-i,k, d);
		}
		return temp;
	}

}
