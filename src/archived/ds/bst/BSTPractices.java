package archived.ds.bst;

import java.util.Arrays;

public class BSTPractices {

    private static int sum = 0;

    public static void main(String[] args) {
        int n = 9;
        String s = "7,4,9,2,5,8,10,1,3";
//        int[] ar = Arrays.copyOf(Arrays.stream(s.split(",")).mapToInt(Integer::valueOf).toArray(), getSize(n));
        int[] ar = Arrays.stream(s.split(",")).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(ar));
        // this returns the sum of all nodes in the BST
        addGreaterValues(ar, 0);
        System.out.println(Arrays.toString(ar));
    }

    // time = O(n)
    public static int addGreaterValues(int[] ar, int i, int sum) {
        if(i >= ar.length) {
            return sum;
        }
        return addGreaterValues(ar, (i*2)+1, ar[i] +=  addGreaterValues(ar, (i*2)+2, sum));
    }

    public static int addGreaterValues(int[] ar, int i) {
        if (i >= ar.length)
            return sum;
        ar[i] = sum = ar[i] + addGreaterValues(ar, (i * 2) + 2);
        return sum = addGreaterValues(ar, (i * 2) + 1);
    }

    private static int getSize(int n) {
        // h = log n / log 2
        // size = 2^(h+1) - 1
        return (int)Math.pow(2d, 2 +(Math.log(n) / Math.log(2))) -1;
    }

}
