package Y2021.ds.LinkedList.cci;

import Y2021.ds.LinkedList.LinkedList;
import Y2021.ds.LinkedList.Node;

import java.util.Objects;

/**
 * @author Venkatesh Rajendran
 * @vendor (Ideas2IT)
 */

public class FindKthLastElement {

    private static int idx = 0;
    public static void main(String[] args) {
        LinkedList<Integer> list = LinkedList.getMeASample();
        findRecursively(list.getHead(), 3);

        idx = 0;
        Node<Integer> node = findNodeRecursively(list.getHead(), 3);
        assert node != null;
        System.out.println(node.getData());

        node = findNodeIteratively(list.getHead(), 3);
        assert node != null;
        System.out.println(node.getData());

    }

    public static int findRecursively(Node<Integer> node, int k) {
        if (Objects.isNull(node))
            return 0;
        // last.next would return 0
        int index = findRecursively(node.getNext(), k) + 1;
        if(k == index) {
            System.out.println("Element at the "+k+" index : "+node.getData());
        }
        return index;
    }


    public static Node<Integer> findNodeRecursively(Node<Integer> node, int k) {
        if (Objects.isNull(node))
            return null;
        // back tracking
        Node<Integer> temp = findNodeRecursively(node.getNext(), k);
        if(++idx == k) {
            temp = node;
        }

        return temp;
    }


    public static Node<Integer> findNodeIteratively(Node<Integer> node, int k) {
        Node<Integer> temp = node;

        for (int i = 0; i < k && temp != null; i++) {
            temp = temp.getNext();
        }

        assert temp != null;

        while (temp != null){
            temp = temp.getNext();
            node = node.getNext();
        }
        return node;
    }

}
