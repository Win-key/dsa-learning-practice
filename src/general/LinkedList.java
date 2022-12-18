package general;

import java.util.Objects;
import java.util.stream.IntStream;

public class LinkedList<T> {
    private Node<T> head;

    public void add(T value) {
        if(isEmpty()) {
            head = new Node<>(value);
        } else {
            Node<T> temp = head;
            while (Objects.nonNull(temp.getNext())) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<>(value));
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        IntStream.range(0,10).forEach(linkedList::add);
        System.out.println(linkedList.getMiddle());
    }

    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    /**
     * Gets the middle element
     * @return
     */
    public T getMiddle() {
        int size = 0;
        Node<T> temp = head;
        while (Objects.nonNull(temp)) {
            size++;
            temp = temp.getNext();
        }
        int mid = size >>> 1;
        temp = head;
        size = 0;
        while (Objects.nonNull(temp)) {
            if(size == mid) {
                return temp.getValue();
            }
            size++;
            temp = temp.getNext();
        }

        return null;
    }

}
