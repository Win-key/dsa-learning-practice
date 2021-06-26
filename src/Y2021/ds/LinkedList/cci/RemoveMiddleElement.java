package Y2021.ds.LinkedList.cci;

import Y2021.ds.LinkedList.LinkedList;

public class RemoveMiddleElement {

    public static void main(String[] args) {
        LinkedList<Integer> list = LinkedList.getMeASample();

        list.forEach(System.out::println);
        list.removeMiddle();
        list.forEach(System.out::println);
        list.removeMiddle();
        list.forEach(System.out::println);
    }

}
