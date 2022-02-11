package archived.ds.stack;

public class StackArrayTest {

    public static void main(String[] args) {
        StackArray<Integer> integerStack = new StackArray<>(5);

        System.out.println("isEmpty " + integerStack.isEmpty());
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        System.out.println("peek " + integerStack.peek());
        integerStack.push(4);
        System.out.println("peek " + integerStack.peek());

        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println("peek " + integerStack.peek());
        System.out.println(integerStack.pop());
        System.out.println("peek " + integerStack.peek());
        System.out.println(integerStack.pop());

        System.out.println("Should get empty exception");
        System.out.println(integerStack.pop());

    }

}
