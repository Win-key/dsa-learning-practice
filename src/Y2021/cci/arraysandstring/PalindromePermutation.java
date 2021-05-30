package Y2021.cci.arraysandstring;

public class PalindromePermutation {

    public static void main(String[] args) {
        String s1 = "Tact Coa";
        boolean f = checkPalindromePermutation(s1);
        System.out.println(s1+" is permutation of palindrome ? " + f);
        String s2 = "Tact Coat";
        f = checkPalindromePermutation(s2);
        System.out.println(s2+" is permutation of palindrome ? " + f);
        f = checkPalindromePermutationV2(s1);
        System.out.println(s1+" is permutation of palindrome with bits ? " + f);
        f = checkPalindromePermutationV2(s2);
        System.out.println(s2+" is permutation of palindrome with bits ? " + f);
        String s3 = "Dad";
        f = checkPalindromePermutationV2(s3);
        System.out.println(s3+" is permutation of palindrome with bits ? " + f);
    }

    public static boolean checkPalindromePermutation(String s) {
        // fixme : how to avoid toLoweCasing?
        // s = s.toLowerCase();
        // create ascii array
        int[] asciAr = new int[26];
        int oddCounter = 0;
        // scan through the array and invert the flag
        // odd chars will be set to true
        // ignore space
        for (char c : s.toCharArray()) {
            // handle upper case letters
            if('A' <= c && c <= 'Z'){
                c = (char) (c + 32);
            }
            if('a' <= c && c <= 'z') {
                asciAr[c-'a']++;
                if (asciAr[c-'a'] % 2 == 1)
                    oddCounter++;
                else
                    oddCounter--;
            }
        }
        return oddCounter < 2;
    }

    /**
     * If the string contains only alphabets, we can use bit manipulation
     * @param s
     * @return
     */
    public static boolean checkPalindromePermutationV2(String s) {
        // fixme : how to avoid toLoweCasing?
        // s = s.toLowerCase();
        // create ascii array
        int checker = 0;

        // scan through the array and invert the flag
        // odd chars will be set to true
        // ignore space
        for (char c : s.toCharArray()) {
            // handle upper case letters
            if(64 < c && c < 91){
                c = (char) (c + 32);
            }
            if(c != ' ') {
                // normalize to 0
                c = (char) (c - 'a');
                // shift 1 for c 1 << c
                // do xor operation
                checker ^= 1 << c;
            }
        }
        // count chars with true flag
        // more than 1 means not a palindrome
        // need to check checker if it has more one 1 bit?
        // 1 - 31 any one of this place should have 1 bit
        // Use getBit methods
        // Iterate from 0 to 25 and find if it has more than 1 bit
        int trueCount = 0;
        for (int i = 0; i < 26; i++) {
            if(hasOne(checker, i)) {
                trueCount++;
            }
            if (trueCount>1) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasOne(int num, int shifter) {
        return (num & 1 << shifter) != 0;
    }

}
