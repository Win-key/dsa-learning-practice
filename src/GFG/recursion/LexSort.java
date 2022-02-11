package GFG.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LexSort {

    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
        System.out.println(powerSet("cba"));
        System.out.println(powerSet("cbac"));
    }

    // sorting takes n log n where n = 2^n => 2^n log 2^n => n * 2^n
    // time = n * 2^n where n is |s| and space = O(n)
    static ArrayList<String> powerSet(String s) {
        ArrayList<String> lex = new ArrayList<>();
        powerSet(s, "", lex, 0);
        Collections.sort(lex);
        return lex;
    }

    // when string is already in sorted like abc or bcdef this will generate the subsets in lexico order
    // time : O(2^n), space: O(n)
    private static void powerSet(String taken, String left, Collection<String> lex) {
        if (left.length() == 0) {
            lex.add(taken);
            return;
        }
        for (int i = -1; i < left.length(); i++) {
            if (i == -1) {
                powerSet(taken, "", lex);
            } else {
                powerSet(taken + left.charAt(i), left.substring(i + 1), lex);
            }
        }
    }

    // this takes 2^n time and n space
    private static void powerSet(String s, String sub, List<String> lex, int index) {
        if (s.length() == index) {
            lex.add(sub);
            return;
        }
        powerSet(s, sub, lex, index + 1);
        powerSet(s, sub + s.charAt(index), lex, index + 1);
    }

}
