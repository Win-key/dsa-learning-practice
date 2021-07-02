package Y2021.ds.LinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author Venkatesh Rajendran
 */

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size = 0;

    public Node<T> getHead() {
        return head;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        if(Objects.isNull(head)) {
            throw new IllegalStateException("Empty list");
        }
        Node<T> temp = head;
        while(Objects.nonNull(temp)) {
            action.accept(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> temp;
            private Node<T> prev;

            @Override
            public boolean hasNext() {
                if(Objects.isNull(temp)) {
                    return Objects.nonNull(head);
                }
                return Objects.nonNull(temp.next);
            }

            @Override
            public T next() {
                if(Objects.isNull(temp)) {
                    temp = head;
                }else {
                    prev = temp;
                    temp = temp.next;
                }
                return temp.data;
            }

            @Override
            public void remove() {
                if(Objects.isNull(prev)) {
                    head = head.next;
                    return;
                }
                prev.next = temp.next;

                // current element is removed
                // prev as temp, so we can handle the element removal caz of list modification
                temp = prev;
                size--;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if(Objects.isNull(t)) {
            return false;
        }
        Node<T> node = new Node<>();
        node.data = t;
        if(Objects.isNull(head)) {
            head = node;
            return true;
        }
        getLastElement().next = node;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(Objects.isNull(o)) {
            return false;
        }
        Node<T> temp = head;
        Node<T> prev = null;
        while(Objects.nonNull(temp)) {
            if(Objects.toString(temp.data).equals(o.toString())) {
                if(prev == null) {
                    head = null;
                }else {
                    prev.next = temp.next;
                }
                size--;
                return true;
            }
            prev = temp;
            temp = prev.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (Objects.isNull(o) || isEmpty()) {
            return -1;
        }
        Node<T> temp = head;
        int index = 0;
        while (Objects.nonNull(temp)){
            if(Objects.toString(temp.data).equals(o.toString())) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node<T> getLastElement() {
        Node<T> temp = head;
        while (Objects.nonNull(temp.next)){
            temp = temp.next;
        }
        return temp;
    }

    public static LinkedList<Integer> getMeASample() {
        LinkedList<Integer> list = new LinkedList<>();
        IntStream.range(1,11).forEach(list::add);
        return list;
    }

    public void removeMiddle() {
        removeMiddle(null, head, 0);
    }

    private int removeMiddle(Node<T> prev, Node<T> head, int index) {
        if(Objects.isNull(head)) {
            return index / 2;
        }

        int middle = removeMiddle(head, head.next, index+ 1);
        if(index == middle) {
            if (Objects.isNull(prev)) {
                this.head = null;
                return middle;
            }
            prev.next = head.next;
        }
        return middle;
    }
}
