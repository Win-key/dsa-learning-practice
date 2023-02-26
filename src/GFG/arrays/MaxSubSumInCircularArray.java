package GFG.arrays;

import java.util.Arrays;

// https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/#practice
public class MaxSubSumInCircularArray {

    public static void main(String[] args) {
        System.out.println(circularSubarraySum(new int[] {8, -8, 9, -9, 10, -11, 12}, 7));
    }
  
    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        if(n == 1)
            return a[0];
        // Your code here
        int normalRes = kadane(a,n);
        if(normalRes < 0)
            return normalRes;
        return Integer.max(normalRes, reverseKadane(a,n));
    }
    
    private static int kadane(int[] a, int n) {
        int max = a[0], temp = a[0];
        for(int i = 1; i < n; i++) {
            temp = Integer.max(a[i]+temp, a[i]);
            max = Integer.max(max, temp);
        }
        return max;
    }
    
    private static int reverseKadane(int[] a, int n) {
        int sum = 0;
        for(int d : a) sum += d;
        
        int min = a[0], temp = a[0];
        for(int i = 1; i < n; i++) {
            temp = Integer.min(a[i]+temp, a[i]);
            min = Integer.min(min, temp);
        }
        return sum - min;
    }
    
}
