package GFG.strings;

import GFG.sorting.Utils;

/**
 *
 * Leftmost Non-repeating Element
 * Given a string, the task is to find the leftmost character that does not repeat.
 *
 * I/p: str = "geeks for geeks"
 * Op: 5 // Index of 'f'
 *
 * Ilp: str = "abcabc"
 * Op: -1
 *
 * I/p: str = "apple"
 * O/P: 0 // Index of 'a'
 *
 */
public class LeftmostNonRepeatingElement {

    public static void main(String[] args) {
        Utils.print("geeks for geeks = " + solve("geeks for geeks"));
        Utils.print("abcabc = " + solve("abcabc"));
        Utils.print("apple = " + solve("apple"));
        Utils.print("aaaa = " + solve("aaaa"));
        Utils.print("aabbaa = " + solve("aabbaa"));
        Utils.print("hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs = " + solve("hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs"));
    }

    public static int solve(String input) {
        // left most index
        Integer[] asci = new Integer[256];
        for (int i = 0; i < input.length(); i++) {
            if(asci[input.charAt(i)] == null) {
                asci[input.charAt(i)] = i;
            } else {
                asci[input.charAt(i)] = Integer.MAX_VALUE;
            }
        }
        int idx = Integer.MAX_VALUE;
        for (Integer i : asci) {
            idx = i != null ? Math.min(i, idx) : idx;
        }
        return idx == Integer.MAX_VALUE ? -1 : idx;
    }

    public static int solve1(String input) {
        int[] asci = new int[256];
        for (int i = 0; i < input.length(); i++)
            asci[input.charAt(i)]++;

        for (int i = 0; i < input.length(); i++)
            if(asci[input.charAt(i)] == 1)
                return i;

        return -1;
    }

}
