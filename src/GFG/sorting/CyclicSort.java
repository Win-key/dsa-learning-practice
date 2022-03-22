package GFG.sorting;

public class CyclicSort {

    public static void main(String[] args) {
        // 5 2 4 6 3
        // 5 2 4 5 3 - 6
        // 5 2 4 5 6 - 3
        // 5 3 4 5 6 - 2
        // 2 3 4 5 6 - 5

        // 5, 2, 4, 6, 5, 2 => 2, 2, 4, 5, 5, 6
        // 5, 2, 4, 6, 5, 2 - 5
            // 5, 2, 4, 5, 5, 2 - 6
            // 5, 2, 4, 5, 5, 6 - 2
            // 5, 2, 2, 5, 5, 6 - 4
            // 5, 2, 4, 5, 5, 6 - 2
            // 2, 2, 4, 5, 5, 6 - 5
        // 2, 2, 4, 5, 5, 6 - 2
        // 2, 2, 4, 5, 5, 6 - 4
        // 2, 2, 4, 5, 5, 6 - 5
        // 2, 2, 4, 5, 5, 6 - 5
        // 2, 2, 4, 5, 5, 6 - 6

        // 5, 2, 4, 6, 5, 2 - 5
            // 5, 2, 4, 5, 5, 2 - 6
            // 5, 2, 4, 5, 5, 6 - 2
            // 2, 2, 4, 5, 5, 6 - 5
        // 2, 2, 4, 5, 5, 6 - 2
        // 2, 2, 4, 5, 5, 6 - 4
        // 2, 2, 4, 5, 5, 6 - 5
        // 2, 2, 4, 5, 5, 5 - 6
        // 2, 2, 4, 5, 5, 6 - 5
        // 2, 2, 4, 5, 5, 5 - 6
        // ....

        int[] ar = sort(5, 2, 4, 6, 5, 1, 2);
        Utils.print(ar);

        ar = sort(20,40,50,10,30);
        Utils.print(ar);

        ar = sort(2,440, 60,8, 7 ,30, 1);
        Utils.print(ar);

    }

    public static int[] sort(int ... ar) {
        int swaps = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            // If we don't pre-process the first element
            // It will go into infinite loop.
            // Took some elbow crease to understand why we need a pre-process of the first element in the cycle
            int e = ar[i];
            int cnt = i;
            for (int j = i+1; j < ar.length; j++)
                if(ar[j] < e) cnt++;

            // if element already in it's correct position then move to next.
            if(cnt == i) continue;
            while (cnt < ar.length && ar[cnt] == e)
                cnt++;
            // swap
            e += ar[cnt]; ar[cnt] = e - ar[cnt]; e = e - ar[cnt];
            swaps++;
            while (cnt != i) {
                cnt = i;
                for (int j = i + 1; j < ar.length; j++)
                    if (ar[j] < e) cnt++;

                while (cnt < ar.length && ar[cnt] == e)
                    cnt++;
                // swap
                e += ar[cnt]; ar[cnt] = e - ar[cnt]; e = e - ar[cnt];
                swaps++;
            }
        }
        System.out.println("Minimum swaps required : " + swaps);
        return ar;
    }

}
