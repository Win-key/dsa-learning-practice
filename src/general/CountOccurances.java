package general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Venkatesh Rajendran
 * @vendor (Ideas2IT)
 */

public class CountOccurances {

    // I LOVE MY LFE

    public static void main(String[] args) {

        String s = "I LOVE MY LFE";
        Map<Character, Integer> mem = new HashMap<>();
        for (Character c : s.toCharArray()) {
            mem.put(c, mem.getOrDefault(c, 0) + 1);
        }

        System.out.println(mem);

    }

}
