package Y2021.ds.arraysandstring.cci;

public class OneAway {

    public static void main(String[] args) {

        System.out.println((byte)((byte)75>>> 1));

        System.out.println("\"pale\", \"lpe\" : " + checkOneAway("pale", "ple"));
        System.out.println("\"pales\", \"pale\" : " + checkOneAway("pales", "pale"));
        System.out.println("\"pales\", \"pales\" : " + checkOneAway("pale", "bale"));
        System.out.println("\"pales\", \"pales\" : " + checkOneAway("pales", "bale"));
    }

    public static boolean checkOneAway(String a, String b) {

        // in case we have the same length
        // we can only replace a char to form the equal value
        if(a.equals(b)){
            return true;
        }else if(a.length() == b.length()) {
            int change = 0;
            for (int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) {
                    change++;
                    if(change > 1) {
                        return false;
                    }
                }
            }
            return true;
        }else if(a.length()+1 == b.length()) {
            return oneInsertAway(a, b);
        }else if(a.length()-1 == b.length()) {
            return oneInsertAway(b, a);
        }
        return false;
    }

    private static boolean oneInsertAway(String small, String big) {
        int i = 0, j = 0;
        while (i < small.length()) {
            if(small.charAt(i) != big.charAt(j)) {
                if(i != j) {
                    return false;
                }else {
                    j++;
                }
            }else{
                i++; j++;
            }
        }
        return true;
    }

}
