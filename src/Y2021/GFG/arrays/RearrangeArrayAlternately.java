package Y2021.GFG.arrays;

import java.util.Arrays;

public class RearrangeArrayAlternately {

    public static void main(String[] args) {
        solve(1, 2, 3, 4, 5, 6);
        solve(10,20,30,40,50,60,70,80,90,100,110);
    }

    /**
     * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.
     *
     * Example 1:
     *
     * Input:
     * N = 6
     * arr[] = {1,2,3,4,5,6}
     * Output: 6 1 5 2 4 3
     * Explanation: Max element = 6, min = 1,
     * second max = 5, second min = 2, and
     * so on... Modified array is : 6 1 5 2 4 3.
     * @param ar
     */
    private static void solve(int... ar) {
        System.out.println(Arrays.toString(ar));
        int max = Arrays.stream(ar).max().getAsInt() + 1, start = 0 , end = ar.length -1;
        for(int i = 0; i < ar.length; i++) {
            if(i % 2 == 0) {
                ar[i] += (ar[end--]%max) * max;
            } else {
                ar[i] += (ar[start++]%max) * max;
            }
        }
        for(int i = 0; i < ar.length; i++) {
            ar[i] /= max;
        }
        System.out.println(Arrays.toString(ar));
    }

}
