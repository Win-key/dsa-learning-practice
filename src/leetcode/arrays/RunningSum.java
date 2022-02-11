package leetcode.arrays;

import java.util.Arrays;

/**
 *
 * From @leetcode  : https://leetcode.com/problems/running-sum-of-1d-array/
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 * Example 2:
 *
 * Input: nums = [1,1,1,1,1]
 * Output: [1,2,3,4,5]
 * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 * Example 3:
 *
 * Input: nums = [3,1,2,10,1]
 * Output: [3,4,6,16,17]
 */

public class RunningSum {

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum2(ar)));
        System.out.println(Arrays.toString(runningSum2(ar)));
        System.out.println(Arrays.toString(runningSum2(ar)));
    }


    /**
     * O(n) time + O(n) space
     * @param nums
     * @return
     */
    public static int[] runningSum(int[] nums) {

        int[] ar = new int[nums.length];
        ar[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            ar[i] = ar[i-1] + nums[i];
        }

        return ar;
    }


    /**
     * O(n) time + O(1) there is no limitation for modifying the original array
     * @param nums
     * @return
     */
    public static int[] runningSum2(int[] nums) {

        int sum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            nums[i] += sum;
            sum = nums[i];
        }

        return nums;
    }

}
