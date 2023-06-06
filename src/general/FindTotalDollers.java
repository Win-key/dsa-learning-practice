package general;

/**
 * @author Venkatesh Rajendran
 *
 */

public class FindTotalDollers {
    public static void main(String[] args) {
        String str = "#1 Tickets $50,000Received $40. Expenses $800 . Cheque$2,00,000.";
        int result = findTotal(str);
        System.out.println("Total is $"+ result);
    }

    private static int findTotal(String str) {
        int result = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '$') {
                flag = true;
            } else if(flag) {
                if(c >= '0' && c <= '9') {
                    sb.append(c);
                } else if(c != ',') {
                    flag = false;
                    result += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if(sb.length() != 0) {
            result += Integer.parseInt(sb.toString());
        }
        return result;
    }


}
