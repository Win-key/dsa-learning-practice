package GFG.bits;

import java.util.ArrayList;
import java.util.List;

public class PowerSetofString {

    public static void main(String[] args) {

    }

    public static List<String> findStringPowerSet(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(2,str.length()); i++) {
            
        }
        return list;
    }

    public static String findChar(String str, int pos) {
        return String.valueOf(str.charAt((int)Math.log(pos)));
    }

}
