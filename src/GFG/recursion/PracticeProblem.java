package GFG.recursion;

public class PracticeProblem {

    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("printNto1");
        printNto1(10);
        System.out.println("print1toN");
        print1toN(10);
        System.out.println("abbcbba : "+isPalindrome("abbcbba", 0, 6));
        System.out.println("abbbba : "+isPalindrome("abbbba", 0, 5));
        System.out.println("sumOfDigits : "+sumOfDigits(12345, 0));

        System.out.println("ropeCuts : "+ropeCuts(23, 11, 9, 12));
        System.out.println("ropeCuts : "+ropeCuts(5, 2, 5, 1));
        System.out.println("ropeCuts : "+ropeCuts(5, 4, 2, 6));
        System.out.println("ropeCuts : "+ropeCuts(9, 2, 2, 2));

        System.out.println("printSubSets : abc");
        printSubSets("abc", "", 0);

        sumSubSets(new int[]{10,5,2,3,6}, 0, 0, 8);
        System.out.println("sumSubSets: 10,5,2,3,6 : sum: "+8+" count : " + count);

        sumSubSets(new int[]{1,2,3}, count = 0, 0, 5);
        System.out.println("sumSubSets: 1,2,3 : sum: "+5+" count : " + count);

        sumSubSets(new int[]{1,2,3}, count = 0, 0, 3);
        System.out.println("sumSubSets: 1,2,3 : sum: "+3+" count : " + count);

        sumSubSets(new int[]{1,2,3}, count = 0, 0, 4);
        System.out.println("sumSubSets: 1,2,3 : sum: "+4+" count : " + count);

        sumSubSets(new int[]{10,20,15}, count = 0, 0, 0);
        System.out.println("sumSubSets: 10,20,15 : sum: "+0+" count : " + count);

        sumSubSets(new int[]{10,20,15}, count = 0, 0, 37);
        System.out.println("sumSubSets: 10,20,15 : sum: "+37+" count : " + count);

        System.out.println("sumSubSets2");

        System.out.println("sumSubSets: 10,5,2,3,6 : sum: "+8+" count : " + sumSubSets2(new int[]{10,5,2,3,6}, 0, 0, 8));

        System.out.println("sumSubSets: 1,2,3 : sum: "+5+" count : " + sumSubSets2(new int[]{1,2,3}, count = 0, 0, 5));

        System.out.println("sumSubSets: 1,2,3 : sum: "+3+" count : " + sumSubSets2(new int[]{1,2,3}, count = 0, 0, 3));

        System.out.println("sumSubSets: 1,2,3 : sum: "+4+" count : " + sumSubSets2(new int[]{1,2,3}, count = 0, 0, 4));

        System.out.println("sumSubSets: 10,20,15 : sum: "+0+" count : " + sumSubSets2(new int[]{10,20,15}, count = 0, 0, 0));

        System.out.println("sumSubSets: 10,20,15 : sum: "+37+" count : " + sumSubSets2(new int[]{10,20,15}, count = 0, 0, 37));
        String str = "abc";
        System.out.println("permutations of " + str);
        printPermutations(str, "", 0);
        System.out.println("permutations of " + (str="abcd"));
        printPermutations(str, "", 0);
    }

    public static void printNto1(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printNto1(n-1);
    }

    public static void print1toN(int n) {
        if(n == 0) {
            return;
        }
        print1toN(n-1);
        System.out.println(n);
    }

    public static boolean isPalindrome(String str, int l, int r) {
        if(l >= r) {
            return true;
        }
        if(str.charAt(l) != str.charAt(r)) {
            return false;
        }
        return isPalindrome(str, l+1, r-1);
    }

    public static int sumOfDigits(int num, int sum) {
        if(num <= 0) {
            return sum;
        }
        return sumOfDigits(num/10, sum + num%10);
    }

    public static int ropeCuts(int num, int a, int b , int c) {
        if (num == 0) {
            return 0;
        } else if (num < 0) {
            return -1;
        }
        int aCut = ropeCuts(num - a, a, b, c);
        int bCut = ropeCuts(num - b, a, b, c);
        int cCut = ropeCuts(num - c, a, b, c);
        int cut = Math.max(aCut, Math.max(bCut, cCut));
        return cut >= 0 ? 1 + cut : cut;
    }

    public static void printSubSets(String s, String c, int index) {
        if (index == s.length()) {
            System.out.println(c);
            return;
        }
        printSubSets(s, c, index+1);
        printSubSets(s, c + s.charAt(index), index + 1);
    }

    public static void sumSubSets(int[] ar, int index, int sumOfTree, int sum) {

        if(index == ar.length) {
            count += (sumOfTree == sum ? 1 : 0);
            return;
        }

        sumSubSets(ar, index+1, sumOfTree, sum);
        sumSubSets(ar, index+1, sumOfTree+ar[index], sum);
    }

    public static int sumSubSets2(int[] ar, int index, int sumOfTree, int sum) {

        if(index == ar.length) {
            return sumOfTree == sum ? 1 : 0;
        }

        return sumSubSets2(ar, index+1, sumOfTree, sum) + sumSubSets2(ar, index+1, sumOfTree+ar[index], sum);
    }

    public static void printPermutations(String str, String per, int index) {
        if(str.length() == 0) {
            System.out.println(per);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            printPermutations(str.replaceAll(str.charAt(i)+"", ""), per+ str.charAt(i), index+1);
        }
    }

}
