package Y2021.GFG.mathematics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllFactors {

    public static void main(String[] args) {
        System.out.println(findAllFactors(48));
        System.out.println(findAllFactors(6));
        System.out.println(findAllFactorsEfficient(48));
        System.out.println(findAllFactorsEfficient(121));
        System.out.println(findAllFactorsEfficient(49));
    }

    public static Set<Integer> findAllFactors(int n) {
        int range = n/2;
        Set<Integer> res = new HashSet<>(range);
        for(int i = 1; i <= range; i++) {
            if(n % i == 0) {
                res.add(i);
            }
        }
        res.add(n);
        return res;
    }

    public static Set<Integer> findAllFactorsEfficient(int n) {
        Set<Integer> res = new HashSet<>();
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                res.add(i);
                res.add(n/i);
            }
        }
        return res;
    }
}
