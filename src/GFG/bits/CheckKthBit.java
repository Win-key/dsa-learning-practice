package GFG.bits;

import java.util.stream.IntStream;

public class CheckKthBit {

    public static void main(String[] args) {
        System.out.println("50 , 6 : "+ check(50 , 6));
        System.out.println("50 , 20 : "+ check(50 , 20));
        System.out.println("50 , 32 : "+ check(50 , 32));

        System.out.println("checkRight 50 , 6 : "+ checkRight(50 , 6));
        System.out.println("checkRight 50 , 20 : "+ checkRight(50 , 20));
        System.out.println("checkRight 50 , 32 : "+ checkRight(50 , 32));

        System.out.println("50 : "+ countSetBit(50 ));
        System.out.println("100 : "+ countSetBit(100 ));
        System.out.println("10 : "+ countSetBit(10 ));

        System.out.println("brainAlgo : 50 : "+ brainAlgo(50 ));
        System.out.println("brainAlgo : 100 : "+ brainAlgo(100 ));
        System.out.println("brainAlgo : 10 : "+ brainAlgo(10 ));

        System.out.println("countSetBitLookUp : 50 : "+ countSetBitLookUp(50 ));
        System.out.println("countSetBitLookUp : 100 : "+ countSetBitLookUp(100 ));
        System.out.println("countSetBitLookUp : 10 : "+ countSetBitLookUp(10 ));

        System.out.println("countSetBits");

        IntStream.range(0, 11).mapToObj(i-> i +" : " + countSetBits(i)).forEach(System.out::println);

        System.out.println("countSetBitsEffective");
        IntStream.range(0, 11).mapToObj(i-> i +" : " + countSetBitsEffective(i)).forEach(System.out::println);

        System.out.println("swapBits(1) : " + swapBits(0));
        System.out.println("swapBits(1) : " + swapBits(1));
        System.out.println("swapBits(2) : " + swapBits(2));
        System.out.println("swapBits(3) : " + swapBits(3));
        System.out.println("swapBits(23) : " + swapBits(23));
    }

    public static boolean check(int n, int k) {
        return (n & (1 << (k-1))) != 0;
    }

    public static boolean checkRight(int n, int k) {
        return ((n >> (k-1)) & 1) != 0;
    }

    /**
     * O(bits)
     * @param n
     * @return
     */
    public static int countSetBit(int n) {
        int count = 0;
        while (n > 0){
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    /**
     * O(set bits)
     * @param n
     * @return
     */
    public static int brainAlgo(int n) {
        int count = 0;

        while (n > 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static int countSetBitLookUp(int n) {
        int[] lookup = new int[256];
        for(int i= 1; i < lookup.length; i++) {
            lookup[i] = (i & 1) + lookup[i/2];
        }
        int count = 0;

        while(n > 0) {
            count += lookup[n & 0xFF];
            n >>= 8;
        }
        return count;
    }

    // logn logn
    public static int countSetBits(int n){

        // Your code here
        if(n <= 1) {
            return n;
        }
        int t = n, x = -1;
        while(t > 0) {
            t >>= 1;
            x++;
        }

//        return ((1<<x)/2)*x + (n+1 - (1<<x)) + countSetBits(n - (1 << x));
        return ((1<<x)/2)*x + (n+1 - (1<<x)) + countSetBits(n & ~(1 << x));
    }

    public static int countSetBitsEffective(int n){

        // Your code here
        if(n <= 1) {
            return n;
        }
        int x = getX(n);

        int cnt = 0;
        while(n > 0) {
            cnt += ((1 << x)/2)*x + (n+1 - (1 << x));
            n &= ~(1 << x--);
            while (x > 0 && (n & 1 << x) == 0) {
                x--;
            }
        }
        return cnt;
    }

    private static int getX(int n) {
        int t = n, x = -1;
        while(t > 0) {
            t >>= 1;
            x++;
        }
        return x;
    }

    /**
     *
     * int a = 0xaaaaaaaa;
     * int b = 0x55555555;
     * System.out.println(Integer.toBinaryString(a));
     * System.out.println(Integer.toBinaryString(b));
     *
     * @param n
     */
    public static int swapBits(int n) {

      int a = 0xaaaaaaaa;
      int b = 0x55555555;
      System.out.println(a + " : "+Integer.toBinaryString(a));
      System.out.println(b + " : "+Integer.toBinaryString(b));

        return ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
    }
}
