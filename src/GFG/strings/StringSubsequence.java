package GFG.strings;

import GFG.sorting.Utils;

/**
 *
 * Check if a String is Subsequence of Other
 *
 * I/P
 * s1= "ABCD"
 * S2= "AD"
 * O/P: True
 *
 *
 * IP:
 * S1 = "ABCDE"
 * S2 = "AED"
 * O/P: False
 *
 */
public class StringSubsequence {

    public static void main(String[] args) {
        Utils.print("ABCDE vs AED = " + solve("ABCDE", "AED"));
        Utils.print("ABCD vs AD = " + solve("ABCD", "AD"));
        Utils.print("GEEKSFORGEEKS vs GRGES = " + solve("GEEKSFORGEEKS", "GRGES"));
    }

    public static boolean solve(String s1, String s2) {
        int pos = 0;
        for (int i = 0; i < s1.length() && pos < s2.length(); i++) {
            if(s1.charAt(i) == s2.charAt(pos)) {
                pos++;
            }
        }
        return pos == s2.length();
    }

}
