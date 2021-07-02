package Y2021.ds.stack;

import Y2021.ds.LinkedList.Node;

import java.util.Objects;

/**
 * @author Venkatesh Rajendran
 * @vendor (Ideas2IT)
 */

public class Stack<T> {

    private Node<T> top;
    private int size = 0;

    public void push(T data) {
        Node<T> node = new Node<>();
        node.setData(data);
        node.setNext(top);
        top = node;
        size++;
    }

    public T pop() {
        if(Objects.isNull(top)) {
            throw new IllegalStateException("Stack is empty");
        }
        Node<T> temp = top;
        top = top.getNext();
        temp.setNext(null);
        size--;
        return temp.getData();
    }

    public T peek() {
        if(Objects.isNull(top)) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return Objects.isNull(top);
    }


}
