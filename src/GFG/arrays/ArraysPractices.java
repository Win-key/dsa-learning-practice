package GFG.arrays;

import utils.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class ArraysPractices {
    public static void main(String[] args) {
        System.out.println(findSecondMax(1, 2, 3, 10, 4, 20, 6, 4, 7));
        System.out.println(Arrays.toString(reverseAll(1, 2, 3, 10, 4, 20, 6, 4, 7)));
        System.out.println(replaceDups(1, 2, 3, 4, 4, 5, 6, 7, 7, 8, 8, 8, 8, 9));
        System.out.println(Arrays.toString(moveZeros(6, 2, 0, 10, 4, 0, 6, 8, 0)));
        leftRotateByK2(2, 1, 2, 3, 4, 5);
        leaders(7, 10, 4, 3, 6, 5, 2);
        System.out.println();
        System.out.println("maxDiff : " + maxDiff(12, 11, 10, 4, 6, 5, 9, 8, 1, 2, 5));
        System.out.println("maxDiff : " + maxDiff(2, 3, 10, 6, -4, 8, 1));
        frequenciesInSortedArray(1, 1, 1, 2, 2, 3, 3, 5, 5, 5, 6, 7, 8, 8, 9, 10, 10);
        frequenciesInSortedArray(4, 4, 4, 4);
        frequenciesInSortedArray(10, 20, 30);
        frequenciesInSortedArray(10, 10, 10, 30, 30, 40);
        frequenciesInSortedArray(40, 50, 50, 50);

        // stock buy and sell
        System.out.println("findMaxStockProfit "+findMaxStockProfit(1, 5, 3, 8, 12));
        System.out.println("findMaxStockProfit "+findMaxStockProfit(1, 5, 3, 1, 2, 8));
        System.out.println("findMaxStockProfit "+findMaxStockProfit(7, 1, 5, 3, 6, 4));

        System.out.println("trappingRainWater " +trappingRainWater(3, 0, 1, 2, 5));
        System.out.println("trappingRainWater " +trappingRainWater(3, 0, 1, 2, 7, 5, 6));
        System.out.println("maxConOnes : "+maxConOnes(1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0));
        // ytyt
        // Kadane's algorithm
        System.out.println("maxSubArray2 : "+maxSubArray2(1, 2, 3, 4));
        System.out.println("maxSubArray2 : "+maxSubArray2(2, 3, -8, 7, -1, 2, 3));
        System.out.println("maxEvenOddSubArray2 : " + maxEvenOddSubArray2(10, 12, 14, 7, 8));
        System.out.println("maxEvenOddSubArray2 : " + maxEvenOddSubArray2(7, 10, 13, 14));
        System.out.println("maxEvenOddSubArray2 : " + maxEvenOddSubArray2(10, 12, 8, 4));
        System.out.println("maxEvenOddSubArray2 : " + maxEvenOddSubArray2(5, 10, 20, 6, 3, 8));
        System.out.println("maxCircularSubArray " + maxCircularSubArray(5, -2, 3, 4));
        System.out.println(maxCircularSubArray(3, -4, 5, 6, -8, 7));
        System.out.println("majorityElementsMooreAlgo : " +majorityElementsMooreAlgo(8, 3, 4, 8, 8));
        System.out.println("majorityElementsMooreAlgo : " +majorityElementsMooreAlgo(3, 7, 4, 7, 7, 5));
        minGroupFlipsMoreEfficient(1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1);
        minGroupFlipsMoreEfficient(1, 1, 0, 0, 0, 1);
        minGroupFlipsMoreEfficient(0, 1, 0, 0, 0, 1);
        minGroupFlipsMoreEfficient(1, 1, 1);
        minGroupFlipsMoreEfficient(0, 1);
        System.out.println(majorityElementsMooreAlgo(20, 30, 40, 50, 50, 50, 50));
        System.out.println(findMajority(20, 30, 40, 50, 50, 50, 50));
    }

    private static int maxCircularSubArray2(int ... ar) {
        int max = ar[0];
        int[] mem = new int[ar.length];
        mem[0] = max;
        for (int i = 1; i < (2 * ar.length) - 1; i++) {
            mem[i%ar.length] = Math.max(ar[i%ar.length] + mem[(i-1)%ar.length], ar[i%ar.length]);
            max = Math.max(max, mem[i%ar.length]);
        }
        return max;
    }

    // https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
    private static int majorityElementsMooreAlgo(int... ar) {
        int index = 0, count = 1;
        // vote the elements
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == ar[index]) {
                count++;
            } else
                count--;
            if (count == 0) {
                count = 1;
                index = i;
            }
        }
        // verify the element voted highest is the majority
        count = 0;
        for (int j : ar) {
            if (ar[index] == j)
                count++;
        }
        if (count <= ar.length / 2)
            return -1;
        return index;
    }

    private static int majorityElements(int... ar) {
        int index = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            if (map.get(ar[i]) == null) {
                map.put(ar[i], 1);
            } else {
                map.put(ar[i], map.get(ar[i]) + 1);
            }
            index = map.get(ar[i]) > (ar.length / 2) ? i : index;
        }
        return index;
    }

    // O(n)
    private static int maxCircularSubArray(int... ar) {
        // Using kadane's algorithm
        int max = maxSubArray2(ar);
        // find min index
        int minIndex = IntStream.range(0, ar.length).reduce((i, j) -> ar[i] < ar[j] ? i : j).getAsInt();
        int sum = ar[minIndex];
        max = Math.max(max, sum);
        for (int j = 1; j < ar.length; j++) {
            sum = Math.max(ar[(minIndex + j) % ar.length], sum + ar[(minIndex + j) % ar.length]);
            max = Math.max(max, sum);
        }
        return max;
    }

    // O(n*n)
    private static int maxCircularSubArrayN2(int... ar) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            int sum = ar[i];
            max = Math.max(max, sum);
            for (int j = 1; j < ar.length; j++) {
                sum = Math.max(ar[(i + j) % ar.length], sum + ar[(i + j) % ar.length]);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    // https://www.geeksforgeeks.org/length-of-the-longest-alternating-even-odd-subarray/
    private static int maxEvenOddSubArray2(int... ar) {
        int max = 0, cur = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] % 2 != ar[i - 1] % 2) {
                max = Math.max(++cur, max);
            } else {
                cur = 0;
            }
        }
        return max == 0 ? max : max + 1;
    }

    // O(n*n)
    // sub array (NOT sub set)
    private static int maxSubArray(int... ar) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            int sum = 0;
            for (int j = i; j < ar.length; j++) {
                max = Math.max(max, sum += ar[j]);
            }
        }
        return max;
    }

    /**
     * 1,2,3
     * <p>
     * 3
     * 2 2,3
     * 1 1,2 1,2,3
     * <p>
     * 2 0 ar
     * 1 5 ar, 1 3 ar
     * 0 6 ar, 0 5 ar, 0 4 ar, 0 3 ar,
     *
     * @param ar
     * @return
     */
    private static int maxSubArray2(int... ar) {
        int max = ar[0], sum = ar[0];
        for (int i = 1; i < ar.length; i++) {
            sum = Math.max(sum + ar[i], ar[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    private static int maxConOnes(int... ar) {
        int max = 0, tempMax = 0;
        for (int a : ar) {
            max = Math.max(max, tempMax += a);
            if (a == 0)
                tempMax = 0;
        }
        return max;
    }

    // O(n*n)
    private static int trappingRainWaterN2(int... ar) {
        int i = 1, total = 0;
        while (i < ar.length) {
            int j = 0, left = ar[i];
            for (; j < i; j++) {
                left = Math.max(left, ar[j]);
            }
            int right = ar[i];
            for (; j < ar.length; j++) {
                right = Math.max(ar[j], right);
            }
            total += Math.min(left, right) - ar[i++];
        }
        return total;
    }

    // O(n)
    private static int trappingRainWater(int... ar) {
        Utils.print(ar);
        int total = 0;
        int[] left = new int[ar.length], right = new int[ar.length];
        left[0] = ar[0];
        right[ar.length - 1] = ar[ar.length - 1];
        for (int i = 1; i < ar.length; i++) {
            left[i] = Math.max(left[i - 1], ar[i]);
        }
        for (int i = ar.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], ar[i]);
        }

        for (int i = 1; i < ar.length - 1; i++) {
            total += Math.min(left[i], right[i]) - ar[i];
        }
        return total;
    }


    private static int findMaxStockProfitInefficient(int... ar) {
        int profit = 0, diff = 0, min = ar[0];
        for (int i = 1; i < ar.length; i++) {
            if (diff < ar[i] - min) {
                diff = ar[i] - min;
            }
            if (ar[i] < ar[i - 1]) {
                profit += diff;
                diff = 0;
                min = ar[i];
            }
        }
        return diff > 0 ? profit + diff : profit;
    }

    // You buy and sell
    private static int findMaxStockProfit(int... ar) {
        Utils.print(ar);
        int profit = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] > ar[i - 1]) {
                profit += ar[i] - ar[i - 1];
            }
        }
        return profit;
    }

    public static int findSecondMax(int... ar) {
        if (Objects.isNull(ar) || ar.length < 2) {
            throw new IllegalStateException("Invalid array. Array should contain at-least 2 elements");
        }

        int m1 = Math.max(ar[0], ar[1]), m2 = Math.min(ar[0], ar[1]);
        for (int i = 2; i < ar.length; i++) {
            if (ar[i] > m1) {
                m2 = m1;
                m1 = ar[i];
            } else if (ar[i] > m2) {
                m2 = ar[i];
            }
        }
        return m2;
    }

    public static int[] reverseAll(int... ar) {
        for (int i = 0, j = ar.length - 1; i != j; i++, j--) {
            swap(i, j, ar);
        }
        return ar;
    }

    public static int[] reverse(int I, int J, int... ar) {
        for (int i = I, j = J; i < j; i++, j--) {
            swap(i, j, ar);
        }
        return ar;
    }

    private static void swap(int i, int j, int[] ar) {
        if (i == j) {
            return;
        }
        ar[i] += ar[j];
        ar[j] = ar[i] - ar[j];
        ar[i] = ar[i] - ar[j];
    }

    // get distinct elements in the first place and return the number of distinct elements
    public static int replaceDups(int... ar) {
        if (ar.length < 2) {
            return ar.length;
        }
        System.out.println(Arrays.toString(ar));
        int i = 0, j = 1;
        while (j < ar.length) {
            if (ar[i] != ar[j] && ++i != j) {
                ar[i] = ar[j];
            }
            j++;
        }
        System.out.println(Arrays.toString(ar));

        return i + 1;
    }
    public static int[] moveZeros(int... ar) {
        System.out.println(Arrays.toString(ar));
        for (int i = 0, j = 0; j < ar.length; j++) {
            if (ar[j] != 0) {
                swap(i++, j, ar);
            }
            //(ar[i] == 0 || ++i == 0) &&
        }
        return ar;
    }

    public static int[] leftRotate(int... ar) {
        System.out.println(Arrays.toString(ar));
        for (int i = ar.length - 1; i >= 0; i--) {
            swap(0, i, ar);
        }
        System.out.println(Arrays.toString(ar));
        return ar;
    }

    public static int[] leftRotateByK(int k, int... ar) {
        System.out.println(Arrays.toString(ar));
        int[] res = new int[ar.length];
        int n = ar.length;
        for (int i = 0; i < n; i++) {
            res[i] = ar[(n - k + i - 1) % n];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void leftRotateByK2(int k, int... ar) {
        System.out.println("leftRotateByK2 : "+ Arrays.toString(ar));
        reverse(0, k - 1, ar);
        reverse(k, ar.length - 1, ar);
        reverse(0, ar.length - 1, ar);
        System.out.println(Arrays.toString(ar));
    }

    public static void leaders(int... ar) {
        int max = Integer.MIN_VALUE;
        for (int i = ar.length - 1; i >= 0; i--) {
            if (max < ar[i]) {
                System.out.print(ar[i] + " ,");
                max = ar[i];
            }
        }
    }

    // Max diff of current element with an element to it's right
    public static int maxDiff(int... ar) {
        int dif = ar[1] - ar[0], min = ar[0];
        for (int i = 1; i < ar.length; i++) {
            dif = Math.max(dif, ar[i] - min);
            min = Math.min(ar[i], min);
        }
        return dif;
    }

    public static void frequenciesInSortedArray(int... ar) {
        int cnt = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] != ar[i - 1]) {
                System.out.println(ar[i - 1] + " : " + cnt);
                cnt = 0;
            }
            cnt++;
        }
        System.out.println(ar[ar.length - 1] + " : " + cnt);
    }

    public static void frequenciesInSortedArray2(int... ar) {
        int cnt = 1;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] != ar[i - 1] || ++cnt == 0) {
                System.out.println(ar[i - 1] + " : " + cnt);
                cnt = 1;
            }
        }
        System.out.println(ar[ar.length - 1] + " : " + cnt);
    }

    /**
     * There is property of binary numbers
     * If start and end elements are equal
     * then that element will have more groups actually +1 than other group
     * eg: 1,0,0,0,1,0,0,1,1,1,1
     * start and end = 1, 1's group = 3
     * 0's group = 2
     * <p>
     * if start and end elements are different
     * then groups will be equal
     * eg: 0,1,1,0,1,1,0,1
     * start != end    1's group = 3
     * 0's group = 3
     *
     * @param ar
     */
    public static void minGroupFlipsEfficient(int... ar) {

        System.out.println(Arrays.toString(ar));
        int checker = 0;
        if (ar[0] == ar[ar.length - 1]) {
            checker = ar[0] ^ 1;
        }
        for (int j = 0, k = 0; k < ar.length; k++) {
            if (ar[j] != checker) {
                j++;
            } else if (ar[j] != ar[k] || k == ar.length - 1) {
                System.out.printf("From %d to %d%n", j, k - 1);
                j = k;
            }
        }
    }

    public static void minGroupFlips(int... ar) {
        System.out.println(Arrays.toString(ar));
        int zero = 0, one = 0, i = 1;
        for (; i < ar.length; i++) {
            if (ar[i] != ar[i - 1]) {
                if (ar[i - 1] == 0) zero++;
                else one++;
            }
        }
        if (ar[i - 1] == 0) zero++;
        else one++;
        if (Math.min(one, zero) == 0)
            return;

        int checker = Math.min(one, zero) == zero ? 0 : 1;
        for (int j = 0, k = 0; k < ar.length; k++) {
            if (ar[j] != checker) {
                j++;
            } else if (ar[j] != ar[k] || k == ar.length - 1) {
                System.out.printf("From %d to %d%n", j, k - 1);
                j = k;
            }
        }
    }

    // https://www.geeksforgeeks.org/minimum-group-flips-to-make-binary-array-elements-same/
    public static void minGroupFlipsMoreEfficient(int... ar) {
        System.out.println(Arrays.toString(ar));
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] != ar[i - 1]) {
                if (ar[i] != ar[0]) {
                    System.out.print("From " + i);
                } else {
                    System.out.println(" to " + (i - 1));
                }
            }
        }
        if (ar[0] != ar[ar.length - 1]) {
            System.out.println(" to " + (ar.length - 1));
        }
    }

    public static int findMajority(int... ar) {
        int count = 1, majorityIndex = 0;
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] == ar[i - 1]) {
                count++;
            } else if (--count == 0) {
                count = 1;
                majorityIndex = i;
            }
        }
        count = 0;
        for (int j : ar) {
            count += j == ar[majorityIndex] ? 1 : 0;
        }

        return count > ar.length / 2 ? majorityIndex : -1;
    }

}