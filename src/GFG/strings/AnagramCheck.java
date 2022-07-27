package GFG.strings;

import GFG.sorting.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Check for Anagram
 * I/P: $1 = "listen", $2 = "silent"
 * O/P: Yes
 * I/p: 81 = "aaacb", 82="cabaa"
 * O/P: Yes
 * I/p: 1="aab" s2 = "ba!"
 * O/P: No
 */
public class AnagramCheck {

    public static void main(String[] args) {
        Utils.print("s1 = \"listen\", s2 = \"silent\" "+ solve("listen","silent"));
        Utils.print("s1 = \"listan\", s2 = \"silent\" "+ solve("listan","silent"));
    }

    public static boolean solve(String s1, String s2) {
        if(s1.length()!= s2.length()) return false;

        // we can use 256 int[] to store the count
        // it could be a better solution as they provide direct access
        Map<Character, Integer> countMap = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            countMap.put(s1.charAt(i), countMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            if(countMap.getOrDefault(s2.charAt(i),0) == 0) {
                return false;
            }
            countMap.put(s2.charAt(i), countMap.getOrDefault(s1.charAt(i), 0) - 1);
        }
        return true;
    }

}
