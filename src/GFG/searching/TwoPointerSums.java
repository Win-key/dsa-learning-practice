package GFG.searching;

import java.util.Arrays;

public class TwoPointerSums {

    public static void main(String[] args) {
        // Count pairs with given sum in sorted ar
        System.out.println(countPairWithSum(8,1,2,3,4,5,6,7,8));
        System.out.println(countPairWithSum(9,1,2,3,4,5,6,7,8));
        System.out.println(countPairWithSum(2,1,2,3,4,5,6,7,8));
        System.out.println(countPairWithSum(16,1,2,3,4,5,6,7,8));

        System.out.println(countTripletWithSum(8,1,2,3,4,5,6,7,8));
        System.out.println(countTripletWithSum(9,1,2,3,4,5,6,7,8));
        System.out.println(countTripletWithSum(2,1,2,3,4,5,6,7,8));
        System.out.println(countTripletWithSum(16,1,2,3,4,5,6,7,8));


    }

    // Count pairs with given sum in sorted ar
    private static int countPairWithSum(int x, int ... ar) {
        System.out.println(Arrays.toString(ar));
        int start = 0, end = ar.length - 1, count = 0;
        while (start < end) {
            int sum = ar[start] + ar[end];
            if(sum == x) {
                count++;
                end--; start++;
            } else if(sum > x) {
                end--;
            } else {
                start++;
            }
        }
        return count;
    }
    // count triplet with given sum
    private static int countTripletWithSum(int x, int ... ar) {
        int count = 0;
        for (int i = 0; i < ar.length; i++) {
            int start = i + 1, end = ar.length - 1, tempX = x - ar[i];
            while (start < end) {
                int sum = ar[start] + ar[end];
                if(sum == tempX) {
                    count++;
                    start++; end--;
                } else if(sum > tempX) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return count;
    }

    // find if there is triplet a,b,c such that a^2 + b^2 = c^2
}
