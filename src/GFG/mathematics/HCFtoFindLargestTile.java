package GFG.mathematics;

public class HCFtoFindLargestTile {

    public static void main(String[] args) {
        System.out.println(findLargestTile(100, 200));
        System.out.println(findLargestTile(4, 6));
        System.out.println(findLargestTile(7, 19));

        System.out.println("gcdWithEuclidin: ");

        System.out.println(gcdWithEuclidin(100, 200));
        System.out.println(gcdWithEuclidin(4, 6));
        System.out.println(gcdWithEuclidin(7, 19));
    }

    public static int findLargestTile(int a, int b) {
        int l = Math.min(a, b);
        int r = Math.max(a, b);

        for(int i = l; i > 0; i--){
            if(r % i == 0 && l % i == 0) {
                return i;
            }
        }

        return 1;
    }

    public static int gcdWithEuclidin(int a, int b) {
        while(b != 0) {
            // swap
            a = (a % b) + b;
            b = a - b;
            a = a - b;
        }
        return a;
    }

}
