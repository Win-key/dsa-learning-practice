package Y2021.java;

import java.util.Objects;

public class MainClass {

    public static void main(String[] args) throws CloneNotSupportedException {
        BaseA a = new DeriveB();
        System.out.println(a);
        BaseA c = a.clone();
        System.out.println(c);
        DeriveB b = new DeriveB();
//        System.out.println(a.age + " : " +a.getAge(10, ""));
    }
}
