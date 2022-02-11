package archived.ds.arraysandstring.cci;

/**
 *
 * URLify (Write a method to replace all spaces in a string with '%20').
 * You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
 * (Note: if implementing in java, please use a character array so that you can perform this operation in place.)
 *
 *
 */


public class URLify {

    public static void main(String[] args) {
        String toUrl = "Mr John Smith    ";
        int trueLen = 13;
        String urlified = urlify(toUrl, trueLen);
        System.out.println("Brute force :" + urlified);

        // In java, String is immutable object
        char[] toUrlChars = toUrl.toCharArray().clone();
        urlify(toUrlChars, trueLen);
        System.out.println("Without sb  :"+ new String(toUrlChars));
    }

    // brute force
    public static String urlify(String s, int newLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newLength; i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void urlify(char[] s, int trueLength) {

        // since we have enough space at the end of the string, 
        // we can shift the char
        // we scan the array and find number of space in the trueLength
        int count = 0;
        for (int i = 0; i < trueLength; i++) {
            if(' ' == s[i]){
                count++;
            }
        }
        // find true length 3 space need for %20 = place of one existing space (%) + 2 new pace for 20
        int indexUrlfied = trueLength + count * 2;
        // then we scan again starting from the reverse
        for (int i = trueLength-1; i > -1; i--) {
            // shift chars if non space
            if(s[i] != ' ') {
                s[--indexUrlfied] = s[i];
            } else {
            // if char == space, replace 3 position with 0->2->%
                s[--indexUrlfied] = '0';
                s[--indexUrlfied] = '2';
                s[--indexUrlfied] = '%';
            }
        }
    }

}
