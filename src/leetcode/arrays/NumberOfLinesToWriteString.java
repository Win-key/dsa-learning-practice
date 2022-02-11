package leetcode.arrays;

import java.util.Arrays;

public class NumberOfLinesToWriteString {

    public static void main(String[] args) {

        int[] width = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(Arrays.toString(numberOfLines(width, s)));
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int pixels = 0, lines = 1;
        for(int i = 0; i < s.length(); i++) {
            int pxlOfChar = widths[s.charAt(i) - 'a'];
            pixels += pxlOfChar;
            if(pixels > 100) {
                lines++;
                pixels = pxlOfChar;
            }
        }
        return new int[] {lines, pixels};
    }

}
