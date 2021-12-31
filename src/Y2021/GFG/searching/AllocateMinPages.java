package Y2021.GFG.searching;

public class AllocateMinPages {


    public static void main(String[] args) {
        System.out.println(solveRec(3, 0, 0, 10,20,40,1,4,7));
        System.out.println(solveRec(2, 0, 0, 10,20,30,40));
        System.out.println(solveRec(1, 0, 0, 10,20,30));
        System.out.println(solveRec(3, 0, 0, 10,15,30,1,2,5,10,10));
    }

    // 10 20 40 1 4 7 k=3
    private static int solveRec(int k, int cut, int sum, int ... ar) {
        int min = Integer.MAX_VALUE;
        if(k == 0) {
            return sum;
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

}
