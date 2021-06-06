package Y2021.ds.LinkedList;


public class Node<T> {
    protected T data;
    protected Node<T> next;

    public T getData() {
        return data;
    }
    public Node<T> getNext() {
        return next;
    }
}
