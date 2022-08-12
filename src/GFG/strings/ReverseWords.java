package GFG.strings;

import utils.Utils;

public class ReverseWords {

    public static void main(String[] args) {
        Utils.print(solve("welcome to gfg"));
        Utils.print(solve("I love coding"));
        Utils.print(solve("abcd"));
    }

    public static String solve(String input) {
        char[] ca = input.toCharArray();
        int pos = 0;
        int n = input.length();
        for (int i = 0; i < n; i++) {
            if(i == n - 1
                    || ca[i] == ' ') {
                reverse(ca, pos, i == n - 1 ? i : i - 1);
                pos = i + 1;
            }
        }
        reverse(ca, 0, n - 1);
        return new String(ca);
    }

    private static void reverse(char[] ca, int s, int e) {
        while (s < e) {
            char t = ca[s];
            ca[s++] = ca[e];
            ca[e--] = t;
        }
    }

    public static String solve1(String input) {
        int pos = input.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i >= 0; i--) {
            if(i == 0 || ' ' == input.charAt(i-1)) {
                sb.append(input, i, pos+1).append(i == 0 ? '\0' : ' ');
                pos = i - 2;
                i--;
            }
        }
        return sb.toString();
    }
    
}
