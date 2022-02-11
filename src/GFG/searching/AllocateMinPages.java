package GFG.searching;

import java.util.Arrays;

public class AllocateMinPages {


    public static void main(String[] args) {
        System.out.println(solveRec(1, 0, 0, 10));
        System.out.println(solveRec(3, 0, 0, 10,20,40,1,4,7));
        System.out.println(solveRec(2, 0, 0, 10,20,30,40));
        System.out.println(solveRec(1, 0, 0, 10,20,30));
        System.out.println(solveRec(3, 0, 0, 10,15,30,1,2,5,10,10));

        System.out.println("With binary search");
        System.out.println(solveBinarySearch(1,  10));
        System.out.println(solveBinarySearch(3,  10,20,40,1,4,7));
        System.out.println(solveBinarySearch(2,  10,20,30,40));
        System.out.println(solveBinarySearch(1,  10,20,30));
        System.out.println(solveBinarySearch(3,  10,15,30,1,2,5,10,10));
    }

    // 10 20 40 1 4 7 k=3
    private static int solveRec(int k, int cut, int sum, int ... ar) {
        int min = Integer.MAX_VALUE;
        if(k == 0) {
            return sum;
        }
        if(k > ar.length) {
            throw new IllegalStateException("K should be <= than length of the elements");
        }

        int cutSum = 0;
        for (int i = cut; i < ar.length + 1 - k; i++) {
            cutSum += ar[i];
            while (k == 1 && ++i < ar.length)
                cutSum += ar[i];

            min = Math.min(solveRec(k - 1, i + 1, Math.max(cutSum, sum), ar),min);
        }
        return min;
    }

    private static int solveBinarySearch(int k, int ... ar) {
        int start = Arrays.stream(ar).max().getAsInt();
        int end = Arrays.stream(ar).sum();
        int mid, min = Integer.MAX_VALUE;
        while (start <= end) {
            mid = start + end >>> 1;
            int sum = 0, count = 1;
            for (int i = 0; i < ar.length && count < k; i++) {
                sum += ar[i];
                if(sum > mid) {
                    count++;
                    sum = ar[i];
                }
            }
            if(count > k){
                start = mid + 1;
            } else {
                end = mid - 1;
                min = Math.min(mid, min);
            }
        }
        return min;
    }

}
