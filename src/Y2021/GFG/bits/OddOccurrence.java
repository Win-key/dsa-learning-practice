package Y2021.GFG.bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class OddOccurrence {


    public static void main(String[] args) {
        System.out.println("findMissingValue : " + findMissingValue(5, 5, 4, 2, 1));
        System.out.println("findMissingValueXOR : " + findMissingValueXOR(5, 5, 4, 2, 1));
        System.out.println("findTwoOddOccurrences : " + findTwoOddOccurrences( 4,4,3,3,1,3,4,5,5,4));
        System.out.println("findTwoOddOccurrencesXOR : " + findTwoOddOccurrencesXOR( 4,4,3,3,1,3,4,5,5,4));
        System.out.println("findTwoOddOccurrencesXOR : " + findTwoOddOccurrencesXOR( 44,455,364,3332,5,3332,44,455,5,455));
    }

    /**
     * XOR operator can be used for finding the odd value
     * Basically the xor will neutralise the same value
     * 2^2 = 0, 2^1^2 = 1
     * Using this property we will find the odd occurrence
     * <p>
     * Limitation: There should be only one odd occurrence value
     *
     * @param ar
     * @return
     */
    public static int findOddOccurrence(int... ar) {
        int res = 0;
        for (int a :
                ar) {
            res ^= a;
        }
        // as mentioned above , all even occurrence values will be neutralized
        // and only odd occurrence will be returned
        return res;
    }

    public static int findMissingValue(int n, int... ar) {
        int sumAll = n * (n + 1) / 2;
        int sumAr = Arrays.stream(ar).sum();
        System.out.println(sumAll + " : " + sumAr);
        return sumAll - sumAr;
    }

    public static int findMissingValueXOR(int n, int... ar) {
        return IntStream.range(1, n + 1).reduce((left, right) -> left ^ right).getAsInt() ^ Arrays.stream(ar).reduce((left, right) -> left ^ right).getAsInt();
    }

    /**
     * time     space
     * O(n) and O(n)
     * @param ar
     * @return
     */
    public static List<Integer> findTwoOddOccurrences(int... ar) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(ar).forEach(i->{
            if(set.contains(i)) {
                set.remove(i);
            }else {
                set.add(i);
            }
        });
        return new ArrayList<>(set);
    }

    /**
     * time     space
     * O(n) and O(1)
     * @param ar
     * @return
     */
    public static List<Integer> findTwoOddOccurrencesXOR(int... ar) {
        List<Integer> list = new ArrayList<>(2);

        int xor = Arrays.stream(ar).reduce((a, b)-> a ^ b).getAsInt();
//        int setBit = xor & ~(xor-1); // ~(xor-1) = -xor
        int setBit = xor & -xor;
        int x = 0, y = 0;
        for (int a : ar) {
            if ((a & setBit) == 0) {
                x ^= a;
            }else {
                y ^= a;
            }
        }

        list.add(x);
        list.add(y);

        return list;
    }

}
