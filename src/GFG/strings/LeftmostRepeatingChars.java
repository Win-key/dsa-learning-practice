package GFG.strings;

import utils.Utils;

/**
 *
 * Leftmost Repeating Character
 * Return First index of repeating char
 * I/p: str = "geeks for geeks"
 * O/P: 0
 * First Occurrer
 * I/p: str = "abbcc"
 * O/P: 1
 * I/p: str = "abcd"
 * O/p: -1
 *
 */
public class LeftmostRepeatingChars {

    public static void main(String[] args) {
        Utils.print("geeks for geeks : " + solve("geeks for geeks"));
        Utils.print("abbcc : " + solve("abbcc"));
        Utils.print("abcd : " + solve("abcd"));
    }
    public static int solve(String s) {

        int[] asciArray = new int[256];

        int index = - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(++asciArray[s.charAt(i)] > 1) {
                index = i;
            }
        }

        return index;
    }

    public static int solve0(String s) {

        int[] asciArray = new int[256];

        for (int i = 0; i < s.length(); i++) {
            asciArray[s.charAt(i)]+=1;
        }


        for (int i = 0; i < s.length(); i++) {
            if(asciArray[s.charAt(i)] > 1) {
                return i;
            }
        }

        return -1;
    }

}
