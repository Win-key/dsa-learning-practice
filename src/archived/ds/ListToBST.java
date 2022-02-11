package archived.ds;

import java.util.stream.IntStream;

import archived.ds.BinaryTree.Node;

public class ListToBST {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		IntStream.range(1, 11).forEach(i->list.add(i));
		BST bst = new BST();
		bst.root = recInsertion(list, 0, list.size()-1);
		
		bst.inOrderTraversal(bst.root);
	}
	
	public static Node<Integer> recInsertion(LinkedList list, int min, int max){
		if(min > max) return null;
		int mid = (min+max)/2;
		Node<Integer> node = new Node<Integer>();
		
		node.setLeft(recInsertion(list, min, mid-1));
		node.setData(list.next());
		node.setRight(recInsertion(list, mid+1, max));
		
		return node;
	}

	public static Integer getIValues(LinkedList list, int index) {
		Node<Integer> node = list.getHead();
		int pointer = 0;
		while(pointer < index && node.hasNext()) {
			node = node.getRight();
			pointer++;
		}
		return node.getData();
	}
}
