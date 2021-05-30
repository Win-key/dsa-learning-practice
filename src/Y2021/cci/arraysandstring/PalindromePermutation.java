package Y2021.cci.arraysandstring;

public class PalindromePermutation {

    public static void main(String[] args) {
        String s = "Tact Coa";
        boolean f = checkPalindromePermutation(s);
        System.out.println(s+" is permutation of palindrome ? " + f);
        s = "Tact Coat";
        f = checkPalindromePermutation(s);
        System.out.println(s+" is permutation of palindrome ? " + f);
    }

    public static boolean checkPalindromePermutation(String s) {
        // fixme : how to avoid toLoweCasing?
        s = s.toLowerCase();
        // create ascii array
        boolean[] asciAr = new boolean[128];

        // scan through the array and invert the flag
        // odd chars will be set to true
        // ignore space
        for (char c :
                s.toCharArray()) {
            if(c != ' ') {
                asciAr[c] = !asciAr[c];
            }
        }
        // count chars with true flag
        // more than 1 means not a palindrome
        int trueCount = 0;
        for (boolean f :
                asciAr) {
            if(f)
                trueCount++;
            if(trueCount > 1)
                return false;
        }
        return true;
    }

}
