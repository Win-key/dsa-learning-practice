package GFG.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println("All moves");
        printTohMove(3, 'a', 'b', 'c');
        System.out.println("All move count : "+ printTohMoveCount(3));

        System.out.println("All moves");
        printTohMove(4, 'a', 'b', 'c');
        System.out.println("All move count : "+ printTohMoveCount(4));

        System.out.println("All moves");
        printTohMove(5, 'a', 'b', 'c');
        System.out.println("All move count : "+ printTohMoveCount(5));
    }

    public static void printTohMove(int n, char a, char b, char c) {
        if (n == 0) {
            return;
        }
        printTohMove(n - 1, a, c, b);
        System.out.println( a + " -> " + c);
        printTohMove(n - 1, b, a, c);
    }

    public static int printTohMoveCount(int n) {
        if (n == 1) {
            return 1;
        }
        return 1 + 2 *printTohMoveCount(n - 1);
    }

}
