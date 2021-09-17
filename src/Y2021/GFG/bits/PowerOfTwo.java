package Y2021.GFG.bits;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println("naiveMethod 8: " + naiveMethod(8));
        System.out.println("naiveMethod 10: " + naiveMethod(10));
        System.out.println("naiveMethod 16: " + naiveMethod(16));

        System.out.println("byCountingSetBits 8: " + byCountingSetBits(8));
        System.out.println("byCountingSetBits 10: " + byCountingSetBits(10));
        System.out.println("byCountingSetBits 16: " + byCountingSetBits(16));

        System.out.println("byCountingSetBits 256: " + byCountingSetBits(256));
        System.out.println("byCountingSetBits 32: " + byCountingSetBits( 32));
        System.out.println("byCountingSetBits 56: " + byCountingSetBits(56));



        System.out.println("byBriansAlgo 8: " + byBrainsAlgo(8));
        System.out.println("byBriansAlgo 10: " + byBrainsAlgo(10));
        System.out.println("byBriansAlgo 16: " + byBrainsAlgo(16));

        System.out.println("byBriansAlgo 256: " + byBrainsAlgo(256));
        System.out.println("byBriansAlgo 32: " + byBrainsAlgo( 32));
        System.out.println("byBriansAlgo 56: " + byBrainsAlgo(56));


        System.out.println("getFirstSetBit 18: " + getFirstSetBit(18));
        System.out.println("getFirstSetBit 12: " + getFirstSetBit(12));
        System.out.println("getFirstSetBit 20: " + getFirstSetBit(20));
        System.out.println("getFirstSetBit 1: " + getFirstSetBit(1));


    }

    // log n
    public static boolean naiveMethod(int n) {
        while(n > 1) {
            if(n % 2 == 0) {
                n /= 2;
            }else {
                return false;
            }
        }

        return true;
    }

    // O(1)
    public static boolean byCountingSetBits(int n) {
        if(n == 0) {
            return false;
        }
        return CheckKthBit.countSetBitLookUp(n) == 1;
    }

    public static boolean byBrainsAlgo(int n) {
        return (n != 0) && (n & (n-1)) == 0;
    }

    public static int getFirstSetBit(int n){

        // Your code here
        return (int)(Math.log(n & ~(n-1))/ Math.log(2))+1;

    }

}
