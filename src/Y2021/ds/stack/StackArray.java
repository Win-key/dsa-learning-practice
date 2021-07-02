package Y2021.ds.stack;

public class StackArray<T>{

    private Object[] internal;
    private int indexOfTop = -1;

    public StackArray(int capacity) {
        internal = new Object[capacity];
    }

    public void push(T data) {
        internal[++indexOfTop] = data;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        T data = (T) internal[indexOfTop];
        internal[indexOfTop--] = null;
        return data;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return (T) internal[indexOfTop];
    }

    public boolean isEmpty() {
        return indexOfTop < 0;
    }

    private boolean isFull() {
        return internal.length == indexOfTop + 1;
    }
}
