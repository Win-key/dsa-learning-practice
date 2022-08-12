package GFG.strings;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PatternSearching {

    public static void main(String[] args) {
        /*naive("abababcd", "abab");
        naive("abcabcd", "abcd");
        naive("aaaaaa", "aaa");


        naiveDistinct("abababcd", "ba");
        naiveDistinct("geeksforgeeks", "eks");
        naiveDistinct("abcaaad", "abd");*/

        rabinKarpAlgorithm("GEEKS FOR GEEKS", "EKS");
        rabinKarpAlgorithm("ABABABCD", "AB");
    }

    public static void naive(String txt, String pat) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < pat.length(); j++) {
                if(txt.charAt(i + j) != pat.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) res.add(i);
        }

        Utils.print(res);
    }


    public static void naiveDistinct(String txt, String pat) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < pat.length(); j++) {
                if(txt.charAt(i + j) != pat.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res.add(i);
                i += pat.length() + 1;
            }
        }

        Utils.print(res);
    }


    // Also call rolling hash technique
    public static void rabinKarpAlgorithm(String txt, String pat) {
        List<Integer> res = new ArrayList<>();
        int d = 26;
        int q = 5381; // prime number
        // preprocess left most weight value
        int h = 1;
        for (int i = 0; i < pat.length() - 1; i++) {
            h = (h * d) % q;
        }
        // pattern and text hash calculation
        int ph = 0;
        int th = 0;
        int x = 1;
        for (int i = pat.length() - 1; i >= 0; i--) {
            ph +=  (x * charHash(pat.charAt(i))) % q;
            th +=  (x * (charHash(txt.charAt(i)))) % q;
            x *= d;
        }

        // slide over the text
        for (int i = 0; i <= txt.length() - pat.length(); i++) {
            // hashes matches. scan to find the equality
            if(ph == th) {
                int j = 0;
                for (; j < pat.length(); j++) {
                    if(pat.charAt(j) != txt.charAt(i + j)) {
                        break;
                    }
                }
                if(j == pat.length())
                    res.add(i);
            }

            // remove the left most element
            th = (th - (h * charHash(txt.charAt(i)))) % q;
            // left shift by d
            th *= d;
            // add next element to the window
            if(i + pat.length() < txt.length())
                th = (th + charHash(txt.charAt(i + pat.length()))) % q;
        }

        Utils.print(res);
    }

    private static int charHash(char c) {
        return c - 'A' + 1;
    }

}
