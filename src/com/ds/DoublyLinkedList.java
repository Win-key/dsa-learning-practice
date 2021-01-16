package com.ds;

import java.util.List;

public class DoublyLinkedList<T> {
	
	private int size = 0;
	private Node<T> head;
	private Node<T> tail;
	
	public void add(T data) {
		addLast(data);
	}
	
	public void addFirst(T data) {
		Node<T> cur = new Node<T>(null, null, data);
		if (size == 0) {
			head = tail = cur;
		}else {
			head.prev = cur;
			cur.next = head;
			head = cur;
		}
		size++;
	}
	
	public void addLast(T data) {
		Node<T> cur = new Node<T>(null, null, data);
		if (size == 0) {
			head = tail = cur;
		}else {
			tail.next = cur;
			cur.prev = tail;
			tail = cur;
		}
		size++;
	}
	
	public void remove() {
		removeLast();
	}
	
	public void removeFirst() {
		if (size == 0) System.out.println("List is empty");
		else if(size==1) head = tail = null;
		else {
			head = head.next;
			head.prev = null;
		}
		size--;
	}
	
	public void removeLast() {
		if (size == 0) System.out.println("List is empty");
		else if (size == 1) head = tail = null;
		else {
			tail = tail.prev;
			tail.next=null;
		}
		size--;
	}
	
	@Override
	public String toString() {
		if (size == 0) return "List is empty";
		StringBuffer sb = new StringBuffer("DoublyLinkedList [");
		Node<T> node = head;
		do{
			sb.append(node.data+",");
			node = node.next;
		}while (node!=null );
		sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.add(1);
		System.out.println(list);
		list.add(2);
		System.out.println(list);
		list.add(3);
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}

	public class Node<T> {
		
		private Node<T> prev;
		private Node<T> next;
		private T data;
		
		public Node(Node<T> prev, Node<T> next, T data) {
			this.prev = prev;
			this.next = next;
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [" + data + "]";
		}
		
	}
	
}
