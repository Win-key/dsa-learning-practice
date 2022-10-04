package GFG.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array A[] of N positive integers which can contain integers from 1 to P where elements can be repeated or can be absent from the array. Your task is to count the frequency of all elements from 1 to N.
 *
 *
 * Example 1:
 * Input:
 * N = 5
 * arr[] = {2, 3, 2, 3, 5}
 * P = 5
 * Output:
 * 0 2 2 0 1
 * Explanation:
 * Counting frequencies of each array element
 * We have:
 * 1 occurring 0 times.
 * 2 occurring 2 times.
 * 3 occurring 2 times.
 * 4 occurring 0 times.
 * 5 occurring 1 time.
 *
 * Example 2:
 * Input:
 * N = 4
 * arr[] = {3,3,3,3}
 * P = 3
 * Output:
 * 0 0 4 0
 * Explanation:
 * Counting frequencies of each array element
 * We have:
 * 1 occurring 0 times.
 * 2 occurring 0 times.
 * 3 occurring 4 times.
 * 4 occurring 0 times.
 *
 * for(i to n-1) {
 *     arr[arr[i]%(P+1) - 1] += (P+1);
 * }
 *
 * for(i to n-1) {
 *     syso('i+1' appears 'ar[i]/(P+1)' times)
 * }
 *
 */

public class FrequenciesOfLimitedRangeArrayElements {

    public static void main(String[] args) {
        solve2(new int[] {2,3,2,3,5}, 5);
        solve2(new int[] {3,3,3,3,5}, 5);
        solve2(new int[] {7,3,3,4,1,4,6}, 7);

        // return duplicate elements only
        System.out.println(Arrays.toString(solve3(new int[] {7,3,3,4,1,4,6}, 7)));
    }

    private static void solve(int[] ar, int N) {
        int i = 0;
        while (i < N) {
            int x = ar[i]-1;
            if(x >= 0) {
                if(ar[x] >= 0) {
                    ar[i] = ar[x];
                    ar[x] = -1;
                } else {
                    ar[i] = 0;
                    ar[x] += -1;
                }
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(ar).map(Math::abs).toArray()));
    }


    private static void solve2(int[] ar, int N) {
        for (int i = 0; i < N; i++) {
            ar[i]--;
            int x = ar[i] % N;
            ar[x] += N;
        }
        for (int i = 0; i < N; i++) {
            ar[i] /= N;
        }
        System.out.println(Arrays.toString(Arrays.stream(ar).map(Math::abs).toArray()));
    }


    private static int[] solve3(int[] ar, int N) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ar[i]--;
            int x = ar[i] % N;
            ar[x] += N;
            if ((ar[x] / N) == 2) {
                res.add(x + 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
