package Y2021.bitwise.practice;

public class BitShifter {
    
    /*
     *  Arithmetic shifter
        0 Before shift : -158
        0 After shift : -79
        1 Before shift : -79
        1 After shift : -40
        Final -40
        Logical shifter
        0 Before shift : -158
        0 After shift : 2147483569
        1 Before shift : 2147483569
        1 After shift : 1073741784
        Final 1073741784
     */
    
    public static void main(String[] args) {
        System.out.println("Final "+ arithmeticShit(-93242, 40));
        System.out.println("Final "+ logicalShit(-93242, 40));
    }
    
    public static int arithmeticShit(int x, int count) {
        System.out.println("Arithmatic shifter");
        for (int i = 0; i < count; i++) {
            System.out.println(i +" Before shift : " + x);
            x >>= 1;
            System.out.println(i + " After shift : " + x);
        }
        return x;
    }
    
    public static int logicalShit(int x, int count) {
        System.out.println("Logical shifter");
        for (int i = 0; i < count; i++) {
            System.out.println(i +" Before shift : " + x);
            x >>>= 1;
            System.out.println(i + " After shift : " + x);
        }
        return x;
    }

}
