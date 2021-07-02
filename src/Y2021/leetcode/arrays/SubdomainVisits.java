package Y2021.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {


    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(cpdomains).forEach(System.out::println);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {

        List<String> result = new ArrayList<>(cpdomains.length);

        for(String cp : cpdomains) {
            int n = 0;
            while(cp.charAt(n) != ' ') {
                n++;
            }

            int count = Integer.parseInt(cp.substring(0, n));
            for(int i = cp.length()-1; i >= n; i-- ) {
                if( i == n || cp.charAt(i) == '.') {
                    addValue(count, cp.substring(i+1));
                }
            }
        }

        map.forEach((k,v)->{
            result.add(v + " " + k);
        });

        return result;
    }

    public static void addValue(int count, String s) {
        if(map.containsKey(s)) {
            count += map.get(s);
        }
        map.put(s, count);
    }

}
