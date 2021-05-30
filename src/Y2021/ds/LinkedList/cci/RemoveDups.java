package Y2021.ds.LinkedList.cci;

import Y2021.ds.LinkedList.LinkedList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 2.1
 * Remove duplicates from linked list
 *
 */
public class RemoveDups {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(11);
        list.add(12);
        list.add(1);
        list.add(12);
        list.add(10);
        list.add(13);
        list.add(10);
        list.add(11);

        removeDuplicates(list);

        list.forEach(System.out::println);
    }

    /**
     *
     * Using hash
     * Time - O(n)
     * Space - O(n)
     *
     * @param list
     */
    public static void removeDuplicates(LinkedList<Integer> list) {

        // todo: how to avoid hash ?
        Set<Integer> hash = new HashSet<>();
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            if (!hash.add(itr.next())) {
                itr.remove();
            }
        }
    }

}
