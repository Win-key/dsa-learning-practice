package GFG.searching;


/**
 *
 * Given a binary sorted non-increasing array of 1s and 0s. You need to print the count of 1s in the binary array.
 *
 * Example 1:
 *
 * Input:
 * N = 8
 * arr[] = {1,1,1,1,1,0,0,0}
 * Output: 5
 * Explanation: Number of 1's in given
 * binary array : 1 1 1 1 1 0 0 0 is 5.
 * Example 2:
 *
 * Input:
 * N = 8
 * arr[] = {1,1,0,0,0,0,0,0}
 * Output: 2
 * Explanation: Number of 1's in given
 * binary array : 1 1 0 0 0 0 0 0 is 2.
 * Your Task:
 * The task is to complete the function countOne() which takes the array arr[] and its size N as inputs and returns the count of 1s in the input array.
 *
 * Expected Time Complexity: O(LogN).
 * Expected Auxiliary Space: O(1).
 *
 * Constraint:
 * 1 <= N <= 5*106
 * arr[i] = 0,1
 *
 *
 */
public class Count1s {

    public static void main(String[] args) {
        System.out.println(solve(1,1,1,1,1,1,0,0));
        System.out.println(solve(1,1,1,1,1,1,1,1));
        System.out.println(solve(1,0,0,0,0,0,0,0));
    }

    private static int solve(int ... ar) {
        int low = 0, high = ar.length - 1;
        while (low <= high) {
            int mid = low + high >>> 1;
            if(ar[mid] == 0) {
                if(mid > 0 && ar[mid - 1] == 1 ) {
                    return mid;
                }
                high = mid - 1;
            } else {
                if(mid == ar.length - 1 || ar[mid+1] == 0) {
                    return mid + 1;
                }
                low = mid + 1;
            }
        }
        return -1;
    }


}
