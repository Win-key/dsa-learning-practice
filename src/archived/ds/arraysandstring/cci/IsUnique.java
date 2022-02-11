package archived.ds.arraysandstring.cci;

/**
 * @author Venkatesh Rajendran
 * @vendor (Ideas2IT)
 */

public class IsUnique {

    public static void main(String[] args) {
        String s = "zxcvbnmasdfghjklqwertyuiopZXCVBNMLKJHGFDSAQWERTYUIOP";
        System.out.println(isUniqueStringWithBit(s));
        System.out.println(isUniqueString(s));
    }

    /**
     * chars in ascii encoding range from 0 - 127
     *
     * since we iterate over the contant array of size 128,
     * we can say this run in O(n) (believe me :d)
     *
     * @param s
     * @return
     */
    public static boolean isUniqueString(String s) {
        // create ascii array
        boolean[] ascii = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // return false if value == true
            if(ascii[c]) {
                return false;
            }
            // set true on first attempt
            ascii[c] = true;
        }
        return true;
    }


    /**
     *
     * only 26 chars in english
     * is we care only about alphabets
     * we can make use of bits
     *
     * throws {@link java.util.IllegalFormatException}, if there are non alphabets characters
     */
    public static boolean isUniqueStringWithBit(String s) {
        // 8 bytes = 64 bits
        long checker = 0L;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            if('A' <= c && c <= 'Z') {
               c -= 'A';
            }else
            // we can merge this condition just above, at a cost of 6 bits (:P)
            if ('a' <= c && c <= 'z') {
                c -= ('A'+6);
            }else {
                throw new IllegalArgumentException("String contains non alphabet characters");
            }
            // check if already accessed
            // since we use long checker, we may shift more than 32 bits
            // so make sure, we use the 1 which type casted to long (1L)
            if((checker & (1L << c)) != 0) {
                return false;
            }
            // set true on first attempt
            checker |= (1L << c);
        }

        return true;
    }

}
