package GFG.sorting;


/*
* This video discusses a famous interview problem in which you need to segregate an array of elements containing three types of elements.
* The types are:
    Sort an array of 0s, 1s, 2s.
    Three-way partitioning when multiple occurrences of a pivot may exist.
    Partitioning around a range.
*
* */
public class DutchFlagAlgorithm {

    public static void main(String[] args) {
        sort012s(1,2,0,1,0,2, 2, 1, 0);
        threeWayPivotPartition(1,7,4,2,9,0,2,4,1,5,6);
        partitionByPivotRange(new int[]{3,6}, new int[] {7,4,2,9,0,2,4,1,5,6});
    }

    // 3 points and 4 sections
    // low , mid, high
    // 0 to low, low+1 to mid -1, mid to high , high + 1 to end
    // 0s               1s          unknown         2s

    private static void sort012s(int...ar) {
        int low = 0, mid = 0, high = ar.length - 1;
        while (mid <= high) {
            if(ar[mid] == 0) {
                // low possibly will only have 1 in it.
                // if mid = 0, then we swap 0 and 1
                // now 1 will be placed at mid
                // since mid is placed with 1, the counter can be incremented, instead of reprocessing mid
                Utils.swap(ar, low++, mid++);
            } else if(ar[mid] == 1) {
                mid++;
            } else {
                // when mid = 2, we swap mid with high
                // high->mid might have any value (0, 1, 2)
                // so now mid requires a reprocessing and mid is not incremented.
                Utils.swap(ar, high--, mid);
            }
        }
        Utils.print(ar);
    }

    private static void threeWayPivotPartition ( int pi, int... ar) {
        int low = 0, mid = 0, high = ar.length - 1, pivot = ar[pi];

        while (mid <= high) {
            if(ar[mid] < pivot) {
                Utils.swap(ar, low++, mid++);
            } else if(ar[mid] == pivot) {
                mid++;
            } else {
                Utils.swap(ar, high--, mid);
            }
        }

        Utils.print(ar);

    }


    private static void partitionByPivotRange ( int[] pi, int[] ar) {
        for (int i = pi[0]; i <= pi[1]; i++) {
            partitionByPivotRange(i, ar);
            Utils.print(ar);
        }
    }

    private static void partitionByPivotRange ( int pivot, int[] ar) {
        int low = 0, mid = 0, high = ar.length - 1;

        while (mid <= high) {
            if(ar[mid] < pivot) {
                Utils.swap(ar, low++, mid++);
            } else if(ar[mid] == pivot) {
                mid++;
            } else {
                Utils.swap(ar, high--, mid);
            }
        }
    }



}
