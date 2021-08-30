package Y2021.GFG.bits;

public class RightMostDiff {

    public static void main(String[] args) {
        System.out.println("posOfRightMostDiffBit : 11, 9 diff = " + posOfRightMostDiffBit(11, 9));
        System.out.println("posOfRightMostDiffBit : 52, 4 diff = " + posOfRightMostDiffBit(52, 4));
        System.out.println("posOfRightMostDiffBit : 0, 10 diff = " + posOfRightMostDiffBit(0, 10));
        System.out.println("posOfRightMostDiffBit : 0, 0 diff = " + posOfRightMostDiffBit(0, 0));
        System.out.println("posOfRightMostDiffBit : 256, 0 diff = " + posOfRightMostDiffBit(256, 0));
    }

    public static int posOfRightMostDiffBit(int m, int n) {
        // Your code here
        for (int i = 0; m > 0 || n > 0; i++) {
            if ((m & 1) != (n & 1)) {
                return i + 1;
            }
            m >>= 1;
            n >>= 1;
        }
        return -1;
    }

}
