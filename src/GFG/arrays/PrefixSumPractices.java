package GFG.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class PrefixSumPractices {
    public static void main(String[] args) {
        int[] ar = {2, 8, 3, 9, 6, 5, 4};
        int[] lar = {1, 2, 5};
        int[] rar = {6, 5, 7};
        IntStream.range(1, ar.length).forEach(i -> ar[i] += ar[i - 1]);
        System.out.println(getQueryResult(0, 2, ar));
        System.out.println(getQueryResult(1, 3, ar));
        System.out.println(getQueryResult(2, 6, ar));
        System.out.println(isAnEquilibriumPrefixOofN(7, 4, 1, 2, 1, 3, 4, 1));
        System.out.println(isAnEquilibriumPrefixOofN(3, 5, 9, 2, 4, 6, 2, 5));
        System.out.println(isAnEquilibriumPrefixOofN(4, 2, -2));
        System.out.println(isAnEquilibriumPrefixOofN(4, 2, -1));
        System.out.println(mostAppearElementInRanges(lar, rar));
        System.out.println(mostAppearElementInRangesWithMap(lar, rar));
        System.out.println(mostAppearElementInRanges(new int[]{4, 6, 2, 7}, new int[]{5, 8, 4, 10}));
        System.out.println(mostAppearElementInRangesWithMap(new int[]{4, 6, 2, 7}, new int[]{5, 8, 4, 10}));
        System.out.println(mostAppearElementInRangesWithMap(new int[]{102, 360, 221, 280}, new int[]{225, 800, 260, 290}));

        System.out.println(threeEqualParts(5, 2, 6, 1, 1, 1, 5));
        System.out.println(threeEqualParts(14, 1, 4, 6, 5, 8, 7));
        System.out.println(threeEqualParts(15, 1, 3, 6, 5, 8, 7));
        System.out.println(threeEqualParts(15, 1, 3, 6, 5, 8, 8));
        System.out.println(threeEqualParts(15, 1, 3, 6, 7, 8, 8));

        System.out.println("subArraySumZero : " + subArraySumZero(5, 7, 6, -3, -1, -2, 8));
        System.out.println("subArraySumZero : " + subArraySumZero(1, 8, -2, -3, 3, 1, 1, 6));
        System.out.println("subArraySumZero : " + longestSubArWithEq0and1(0,0,0,1,1,1,0,0,0));
        System.out.println("subArraySumZero : " + longestSubArWithEq0and1(0,0,1,1));
    }

    private static int longestSubArWithEq0and1(int... ar) {
        Map<Integer, Integer> map = new HashMap<>(ar.length);
        int sum = 0, length = 0;
        for (int i = 0; i < ar.length; i++) {
            sum += ar[i] == 0 ? -1 : 1;
            if (map.get(sum) != null)
                length = Math.max(length, i - map.get(sum));
            else
                map.put(sum, i);

            length = sum == 0 ? i + 1 : length;
        }
        return length;
    }

    private static boolean subArraySumZero(int... ar) {
        Set<Integer> set = new HashSet<>();
        set.add(ar[0]);
        for (int i = 1; i < ar.length; i++) {
            if (!set.add(ar[i] += ar[i - 1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean threeEqualParts(int... ar) {
        int div = Arrays.stream(ar).sum() / 3;

        int count = 0;
        for (int i = 1; i < ar.length; i++) {
            ar[i] += (ar[i - 1] == div && ++count == count ? 0 : ar[i - 1]);
        }
        count += ar[ar.length - 1] == div ? 1 : 0;
        return count == 3;
    }

    private static int mostAppearElementInRanges(int[] lar, int[] rar) {
        int[] aux = new int[1000];
        for (int i = 0; i < lar.length; i++) {
            aux[lar[i]]++;
            aux[rar[i] + 1]--;
        }
        int max = 0;
        for (int i = 1; i < aux.length; i++) {
            aux[i] += aux[i - 1];
            max = aux[i] > aux[max] ? i : max;
        }
        return max;
    }

    private static int mostAppearElementInRangesWithMap(int[] lar, int[] rar) {
        Map<Integer, Integer> aux = new HashMap<>();
        int length = 0;
        for (int i = 0; i < lar.length; i++) {
            aux.put(lar[i], getVal(aux.get(lar[i])) + 1);
            aux.put(rar[i] + 1, getVal(aux.get(rar[i] + 1)) - 1);
            length = Math.max(rar[i], length);
        }
        int max = 0;
        for (int i = 1; i <= length; i++) {
            aux.put(i, getVal(aux.get(i)) + getVal(aux.get(i - 1)));
            max = getVal(aux.get(i)) > getVal(aux.get(max)) ? i : max;
        }
        return max;
    }

    private static int getVal(Integer i) {
        return Objects.isNull(i) ? 0 : i;
    }


    private static boolean isAnEquilibriumPrefixOofN(int... ar) {
        int sum = Arrays.stream(ar).sum(), left = 0;

        for (int a : ar) {
            if (left == sum - a) {
                return true;
            }
            left += a;
            sum -= a;
        }

        return false;
    }

    private static boolean isAnEquilibrium2Pointer(int... ar) {
        int left = 0, right = 0;
        for (int i = -1, j = ar.length; i <= j; ) {
            if (left <= right) {
                left += ar[++i];
            } else {
                right += ar[--j];
            }
            if (i == j && left == right) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnEquilibrium(int... ar) {
        System.out.println("isAnEquilibrium : " + Arrays.toString(ar));
        int[] forward = new int[ar.length];
        //int[] backward = new int[ar.length];
        int back = 0;
        forward[0] = ar[0];
        //backward[ar.length-1] = ar[ar.length-1];
        for (int i = 1/*, j = ar.length-2*/; i < ar.length/* && j >= 0*/; i++/*, j--*/) {
            forward[i] = forward[i - 1] + ar[i];
            /*backward[j] = backward[j+1] + ar[j];*/
        }
        for (int i = ar.length - 1; i >= 0; i--) {
            if (forward[i] == (back += ar[i])) {
                return true;
            }

            /*if(forward[i] == backward[i]) {
                return true;
            }*/
        }

        return false;
    }

    private static int getQueryResult(int x, int y, int[] ar) {
        if (x > y) {
            return 0;
        }
        return x == 0 ? ar[y] : ar[y] - ar[x - 1];
    }


}
