package GFG.hashing.openaddressing;


// https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * I/p: a[] = [10, 15, 20, 5, 30] b[] = [30, 5, 30, 80]
 * 0/p: 2
 *
 * I/p: a[] = [10, 20] b[] = [20, 30]
 * 0/P: 1
 *
 * Ilp: a[] = [10, 10, 10] b[] = [10, 10, 10]
 * O/P: 1
 *
 */
public class IntersectionOfTwoAr {

    public static void main(String[] args) {
        int[] a = {10, 15, 20, 5, 30}, b = {30, 5, 30, 80};
        solve(a, b);
        a = new int[] {10, 20}; b = new int[] {20, 30};
        solve(a, b);
        a = new int[] {10, 10,10}; b = new int[] {10,10};
        solve(a, b);
        a = new int[] {10, 10,10}; b = new int[] {1,101};
        solve(a, b);
    }

    // one approch is simply adding both array to two hashset aset, best
    // and aset.add(belemnt) = true/false will give the count
    // but that would need a extra space
    //
    // In this approche, the bigger array will be hashed
    // and smaller array will checked against the hashed array
    public static void solve(int[] a, int[] b) {
        // make a as always a bigger array
        if(a.length < b.length) {
            int[] t = a; a = b;b = t;
        }

        Set<Integer> setA = new HashSet<>();
        Arrays.stream(a).forEach(setA::add);

        int count =
        Arrays.stream(b).map(e -> {
            boolean res = setA.add(e);
            setA.remove(e);
            return res ? 0 : 1;
        }).sum();

        System.out.println(count);
    }

}
