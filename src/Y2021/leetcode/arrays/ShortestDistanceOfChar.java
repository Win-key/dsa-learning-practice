package Y2021.leetcode.arrays;

public class ShortestDistanceOfChar {

    public int[] shortestToChar(String s, char c) {

        int recentCharPos = -1;
        int[] res = new int[s.length()];

        // iterate from left to right till s.length() - 1
        for(int i = 0; i < s.length(); i++) {
            // update recentCharPos is c = charAt(i)
            if(c == s.charAt(i)) {
                recentCharPos = i;
            } else {
                // if there is no 'c' found, then update pos with max value
                // else update with i - recentCharPos
                res[i] = recentCharPos < 0 ? Integer.MAX_VALUE : i - recentCharPos;
            }
        }

        // iterate from right to left
        for(int i = recentCharPos; i >= 0; i--) {
            if(c == s.charAt(i)) {
                recentCharPos = i;
            }else if(res[i] > (recentCharPos - i)) {
                // if current distance is less then the pre filled distance
                res[i] = recentCharPos - i;
            }
        }

        return res;

    }

}
