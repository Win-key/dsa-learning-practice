package Y2021.GFG.searching;

// Time - O(n) space : O(1)
// Immutable array

import java.util.HashSet;
import java.util.Set;

public class RepeatingElement {

    public static void main(String[] args) {

    }

    // With O(n) time and space
    private static void solve1(int ... ar) {
        Set<Integer> set = new HashSet<>(ar.length);
        for (int a : ar) {
            if(!set.add(a)) {
                System.out.println("Repeating element : "+a);
                break;
            }
        }
    }

    // O(n) time and O(1) space solution with mutable array
    //   0   1   2   3   4
    // ---------------------
    // | 3 | 4 | 1 | 4 | 2 |
    // ---------------------
    // Range between 1 to n-1
    private static void solve2(int ... ar) {
        for (int i = 0; i < ar.length; i++) {
            int a = Math.abs(ar[i]);
            if (ar[a] > 0) {
                ar[a] *= -1;
            } else {
                System.out.println("Repeating element : "+a);
            }
        }
    }



}
