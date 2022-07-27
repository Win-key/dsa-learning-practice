package GFG.hashing.openaddressing.impl;

import GFG.hashing.openaddressing.Hash;

import java.util.Arrays;
import java.util.Objects;

public class LinearOpenAddressing implements Hash {

    private Wrap[] ar;
    private int size, cap;

    public LinearOpenAddressing(int cap) {
        this.cap = cap;
        ar = new Wrap[cap];
    }

    private int hashCode(int data) {
        return data % cap;
    }

    @Override
    public int search(int data) {
        if(size == 0) return -1;
        int h = hashCode(data);
        int i = h;
        Wrap cur = ar[i];
        while (Objects.nonNull(cur) && !cur.equalsInt(data)) {
            cur = ar[(++i) % cap];
            if(i % cap == h) return -1;
        }
        return Objects.nonNull(cur) ? (i%cap) + 1 : -1;
    }

    @Override
    public boolean insert(int data) throws IllegalStateException {
        if(size == cap) return false;

        int index = hashCode(data);
        Wrap cur = ar[index];
        while (Objects.nonNull(cur) && !cur.isDeleted) {
            cur = ar[(++index) % cap];
        }
        ar[index % cap] = Wrap.of(data);
        size++;
        return true;
    }

    @Override
    public boolean delete(int toDelete) {
        if(size == 0) return false;

        int i = search(toDelete);
        if(i == -1) {
            return false;
        }
        ar[i - 1].delete();
        size--;
        return true;
    }

    @Override
    public void print() {
        if(size == 0) return;
        StringBuilder sb = new StringBuilder();
        Arrays.stream(ar)
            .filter(wrap -> Objects.nonNull(wrap) && !wrap.isDeleted)
            .forEach(wrap -> sb.append(',').append(wrap.toString()));
        System.out.println(sb.substring(1));
    }

    static class Wrap {
        int data;
        boolean isDeleted;

        public Wrap(int data) {
            this.data = data;
        }

        public void delete() {
            isDeleted = true;
        }

        static Wrap of(int data) {
            return new Wrap(data);
        }

        public boolean equalsInt(int toEqual) {
            if(isDeleted) return false;
            return data == toEqual;
        }

        @Override
        public String toString() {
            if(isDeleted)
                return "";
            return Objects.toString(data);
        }
    }
}
