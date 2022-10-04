package GFG.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayProblems {


    public static void main(String[] args) throws NoSuchMethodException {

        reverseInGroups(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 5, 3);
        reverseInGroups(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7)), 7, 3);
        reverseInGroups(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)), 9, 5);
        reverseInGroups(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)), 9, 9);
        reverseInGroups(new ArrayList<>(List.of(10, 5, 15, 25, 20, 6, 7)), 7, 4);

        reverseInGroups(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)), 9, 0);


    }

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        if (k < 1 || n < 1) {
            return;
        }
        for (int i = 0; i < n; i += k) {
            reveres(i, i + k - 1 - (i + k) % n, arr);
        }

        System.out.println(arr.toString());
    }

    static void reveres(int i, int j, ArrayList<Integer> arr) {
        if (i >= j)
            return;
        while (i < j) {
            Integer temp = arr.get(i);
            arr.set(i++, arr.get(j));
            arr.set(j--, temp);
        }
    }

}
