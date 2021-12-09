package Y2021.java;

public class BaseA implements Cloneable{

    public int age = 10;

    public int getAge(int a, String b) {
        return age;
    }

    protected int getAge2(int a, String b) {
        return age;
    }

    @Override
    protected BaseA clone() throws CloneNotSupportedException {
        BaseA a = new BaseA();
        a.age = this.age;
        return a;
    }
}
