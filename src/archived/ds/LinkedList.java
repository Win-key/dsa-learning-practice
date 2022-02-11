package archived.ds;

import java.util.Objects;

import archived.ds.BinaryTree.Node;

public class LinkedList {
	
	private Node<Integer> head, tail;
	private Node<Integer> current;
	
	private int size;
	
	public void add(int data) {
		if(Objects.isNull(head)) {
			head = new Node<Integer>(data);
			tail = head;
		}else {
			tail.setRight(new Node<Integer>(data));
			tail = tail.getRight();
		}
		
		size++;
	}

	public Node<Integer> getHead() {
		return head;
	}
	
	public Integer next() {
		if(Objects.isNull(current)) 
			current = head;
		else 
			current = current.getRight();
		
		return current.getData();
	}

	public int size() {
		return size;
	}
	
}
