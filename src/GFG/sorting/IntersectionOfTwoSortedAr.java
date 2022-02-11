package GFG.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  problem taking two sorted arrays
//  and picking out the intersection elements from the two arrays.
public class IntersectionOfTwoSortedAr {

    public static void main(String[] args) {
        System.out.println("Naive 1");
        naive1(new int[]{3, 5, 10, 10, 10, 15, 15, 20},
               new int[]{5, 10, 10, 15, 30});
        naive1(new int[]{1, 1, 3, 3, 3}, new int[]{1, 1, 1, 1, 3, 5, 7});

        System.out.println("Naive 2");
        naive2(new int[]{3, 5, 10, 10, 10, 15, 15, 20}, new int[]{5, 10, 10, 15, 30});
        naive2(new int[]{1, 1, 3, 3, 3}, new int[]{1, 1, 1, 1, 3, 5, 7});

        System.out.println("Naive 3");
        naive3(new int[]{3, 5, 10, 10, 10, 15, 15, 20}, new int[]{5, 10, 10, 15, 30});
        naive3(new int[]{1, 1, 3, 3, 3}, new int[]{1, 1, 1, 1, 3, 5, 7});

        System.out.println("efficient");
        efficient(new int[]{3, 5, 10, 10, 10, 15, 15, 20}, new int[]{5, 10, 10, 15, 30});
        efficient(new int[]{3, 5, 10, 10, 10, 15, 15, 20}, new int[]{9, 10, 10, 15, 30});
        efficient(new int[]{1, 1, 3, 3, 3}, new int[]{1, 1, 1, 1, 3, 5, 7});
    }

    // O(min(n,m)) time O(min(n,m)) space
    public static void naive1(int[] a, int[] b) {
        if (a.length < b.length) {
            int[] t = a;
            a = b;
            b = t;
        }
        Map<Integer, Integer> map = new HashMap<>(a.length);
        Arrays.stream(a).forEach(e -> map.put(e, 1));
        for (int e : b) {
            if (map.get(e) != null) {
                map.put(e, map.get(e) + 1);
                if (map.get(e) == 2) {
                    System.out.print(e + " ");
                }
            }
        }
        System.out.println();
    }

    // n^2 - Modified array
    public static void naive2(int[] a, int[] b) {
        for (int k : a) {
            boolean flag = true;
            for (int j = 0; j < b.length; j++) {
                if (k == b[j]) {
                    if (flag) {
                        System.out.print(k + " ");
                        flag = false;
                    }
                    b[j] *= -1;
                }
            }
        }
        System.out.println();

    }

    // t (n^2), s - 1 - Not Modified array
    public static void naive3(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (i != 0 && a[i] == a[i - 1]) continue;
            int c = 1;
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j])
                    c++;
                if (c == 2) {
                    System.out.print(b[j] + " ");
                    break;
                }
            }

        }
        System.out.println();
    }

    public static void efficient(int[] a, int[] b) {
        int i = 0, j = 0, n1 = a.length, n2 = b.length;
        while (i < n1 && j < n2) {
            while (i < n1 -1 && a[i] == a[i+1])
                i++;
            while (j < n2 -1 && b[j] == b[j+1])
                j++;
            if(a[i] == b[j])
                System.out.print((b[j++] & a[i++]) + " ");
            else if(a[i] < b[j]) i++;
            else j++;

        }
        System.out.println();
    }

}
