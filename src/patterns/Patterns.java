package patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Patterns {

	private static Map<Integer, Integer> fibMap = new HashMap<>();
	
	public static void main(String[] args) {
		pattern1(3);
		System.out.println();
		pattern2(5);
		System.out.println();
		pattern3(5);
		System.out.println();
		pattern4(9);
		System.out.println();
		pattern5(6);
		System.out.println();
		pattern6(7, 9);
		System.out.println();
		pattern7(9);
		System.out.println("fibonacciWithIteration");
		fibonacciWithIteration(11,1);
		System.out.println();
		System.out.println("fibonacciWithRecursion");
		fibonacciWithRecursion(11);
		fibMap.forEach(Patterns::valuePrinter);
		System.out.println();
		IntStream.range(0, 501).forEach(Patterns::armstrong);
		System.out.println();
		pattern2Repeated(5, 20, 23);
		System.out.println("Number rotation");
		pattern6SquareRotated(8);
		System.out.println("Pattern 8");
		pattern8(25,20, 2);
		
		System.out.println("Pattern 9 diagonal pattern");
		pattern9(25, 20, 2);
	}
	
	
	private static void pattern1(int n) {
		IntStream.range(0, n).forEach(i-> System.out.println(IntStream.range(0, i+1).mapToObj(a->"*").reduce((a,b)->a+b).get()));
	}
	
	private static void pattern2(int n) {
		int len = 2*n -1;
		for (int i = 1; i <= len; i++) {
			int j = 1;
			for (; j <= Math.abs(n-i); j++) {
				System.out.print(" ");
			}
			
			for (; j <= len-Math.abs(n-i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void pattern2Repeated(int n, int r, int c) {
		System.out.println("Diamond repeated \n");
		int len = 2*n -1;
		for (int i = 1; i <= r; i++) {
			int tempC = c;
			while(tempC >= 0) {
				int j = 1;
				int mod = i%len ==0?1:i%len;
				for (; j <= Math.abs(n-mod) && j <= tempC; j++) {
					System.out.print(" ");
				}
				
				for (; j <= len-Math.abs(n-mod) && j <= tempC; j++) {
					System.out.print("*");
				}
				
				for (; j <= len && j <= tempC; j++) {
					System.out.print(" ");
				}
				tempC -= len;
			}
			System.out.println();
		}
	}
	
	private static void pattern3(int n) {
		int len = 2*n -1;
		
		for (int i = 1; i <= n; i++) {
			halfDiamond(n, len, i);
			System.out.println();
		}
		for (int i = n-1; i >= 1; i--) {
			halfDiamond(n, len, i);
			System.out.println();
		}
	}
	
	private static void pattern4(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= 1; j--) {
				System.out.print(j==i ? "*" : j);
			}
			System.out.println();
		}
	}
	
	private static void pattern5(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 2*n+1; j++) {
				System.out.print(i==j || j==n+1 || j==2*n+2-i ? "* " : "0 ");
			}
			System.out.println();
		}
	}
	
	private static void pattern6SquareRotated(int n) {
		int[][] ar = new int[n][n];
		pattern6SquareRotated(ar, n, 0, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String k = ar[i][j] + "";
				System.out.print(k + IntStream.range(0, k.length()==1?3:k.length()).mapToObj(a->" ").reduce((a,b)->a+b).get());
			}
			System.out.println();
		}
	}
	
	private static void pattern6SquareRotated(int[][] ar, int n, int idx, int count) {
		if(n<=0)
			return;
		int max = pattern6Square(ar, n, idx,count);
		pattern6SquareRotated(ar, n-2, idx+1,max+1);
	}
	
	private static int pattern6Square(int[][] ar, int n, int idx, int count) {
		int max = count+4*n-5;
		int tempMax = max;
		for (int i = idx; i < n+idx; i++) {
			for (int j = idx; j < n+idx; j++) {
				if(i==idx) {
					ar[i][j] = count++;
				}
				if(i>idx && i<n+idx-1) {
					if(j==idx) {
						ar[i][j] = tempMax--;
					}else if(j==n+idx-1) {
						ar[i][j] = count++;
					}
				}
				if(i==n+idx-1) {
					ar[i][j] = tempMax--;
				}
			}
		}
		return max;
	}
	
	private static void pattern6(int r, int c) {
		int count = 1 , max=(2*r-2)+(2*c-4);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(i==0 && j!=c-1) {
					System.out.print(count++ +"  ");
				}
				if(i>0 && i<r-1) {
					if(j==0) {
						System.out.print(max-- + " ");
					}else if(j==c-1) {
						System.out.print(count++ + " ");
					}else {
						System.out.print("   ");
					}
				}
				if(i==r-1 && j!=c-1) {
					System.out.print(max-- +" ");
				}
			}
			System.out.println();
		}
	}
	
	private static void pattern7(int n) {
		int len = 2*n;
		for (int i = 1; i < len; i++) {
			for (int j = 1; j < len; j++) {
				System.out.print((i==j || j==len-i) ? i<=n ? i : 2*n-i : " ");
			}
			System.out.println();
		}
	}

	public static void halfDiamond(int n, int len, int i) {
		int t=1;
		for (int j = 1; j <= len; j++) {
			if(t/2 == i) break;
			if(i+j==n+t) {
				System.out.print("*");
				t+=2;
			}else
				System.out.print(" ");
		}
	}
	
	// 0 1 2 3 4 5 6
	// 1 1 2 3 5 8 13
	public static void fibonacciWithIteration(int n, int k) {
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			if(i<=1)
				ar[i]=1;
			else 
				ar[i]= ar[i-1]+ ar[i-2];
			
			System.out.print(ar[i]+ " ");
		}
	}
	
	
	public static int fibonacciWithRecursion(int n) {
		if(Objects.nonNull(fibMap.get(n)))
			return fibMap.get(n);
		else if(n<=1) {
			fibMap.put(n, n);
			return n;
		}
		int returnVal = fibonacciWithRecursion(n-1)+fibonacciWithRecursion(n-2);
		fibMap.put(n, returnVal);
		// System.out.print(returnVal+" ");
		return returnVal;
	}
	
	public static void armstrong(int n) {
		int temp = n;
		int sum = 0;
		while(temp!=0) {
			int digit = temp%10;
			sum += digit*digit*digit;
			temp/=10;
		}
		if(sum == n) {
			System.out.println(n + " an armstrong number");
		}
		//System.out.println(n+ (sum==n ? " " : " not ")+"an armstrong number");
	}
	
	private static void pattern8(int r, int c, int n) {
		int tempI = 0;
		for (int i = 0; i < r; i++) {
			int tempJ = 0;
			for (int j = 0; j < c; j++) {
				if(tempI==0)
					System.out.print("* ");
				else if(tempJ==j) {
					System.out.print("* ");
					tempJ+=n+1; 
				}else
					System.out.print("  ");
			}
			tempI = tempI==n ? 0 : tempI+1;
			System.out.println();
		}

//		for (let i = 0; i < r; i++) {
//			for (let j = 0; j < c; j++) {
//				str += (i % (n + 1) == 0 || j % (n + 1) == 0) ? '*' : ' '

	}
	
	private static void pattern9(int r, int c, int n) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(i%2 == j%2) {
					System.out.print("* ");
				}else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	private static void pattern9Modified(int r, int c, int n) {
		int i = 0, j = 0;
		
	}
	
	
	private static void valuePrinter(int k, int v) {
		System.out.print(v+ " ");
	}
}
