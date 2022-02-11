package archived.ds;

import java.util.stream.IntStream;

import archived.ds.BinaryTree.Node;

public class ArrayToBST {

	public static void main(String[] args) {

		int[] array = IntStream.range(1, 11).toArray();
		BST bst = new BST();
		bst.root = recInsert(array, 0, array.length-1);
		bst.inOrderTraversal(bst.root);
	}
	
	public static Node<Integer> recInsert(int[] array, int min, int max) {
		if(min > max) return null;
		Node<Integer> node = new Node<Integer>();
		int mid = (min+max)/2;
		node.setData(array[mid]);
		
		node.setRight(recInsert(array, mid+1, max));
		node.setLeft(recInsert(array, min, mid-1));
		
		return node;
	}

}
