package com.ds;


public class SinglyLinkedList<T> {
	private Node<T> head;
	private int size = 0;
	
	public Node<T> getHead(){
		return this.head;
	}
	
	public int size() {
		return this.size;
	}
	
	public void push(T data) {
		head = new Node<T> (data, head);
		size++;
	}
	
	public void pushAfter (Node<T> prev, T data) {
		prev.next = new Node<T>(data, prev.next);
		size++;
	}
	
	public void pushLast(T data) {
		if(head == null) {
			head =  new Node<T>(data,null);
			size++;
			return;
		}
		Node<T> trav = head;
		while (trav.next != null) {
			trav = trav.next;
		}
		trav.next = new Node<T>(data,null);
		size++;
	}
	
	public void pushAt(int index, T data) {
		if (index >= size) System.out.println("Can't add at this position");
		else {
			Node<T> trav = head;
			int i =0;
			while (trav.next != null) {
				if(i==index-1) break;
				trav = trav.next;
				i++;
			}
			
			trav.next = new Node<T>(data, trav.next);
			size++;
		}
	}
	
	public Node<T> get(int i) throws Exception{
		if(i >= size || i < 0) throw new Exception("Invalid index.");
		Node<T> trav = head;
		int index = 0;
		while (trav != null) {
			if(index == i) break;
			trav =trav.next;
			index++;
		}
		return trav;
	}
	
	public T remove(T key) throws Exception {
		T result = null;
		if(size == 0) throw new Exception("List is empty.");
		else if(head.data.equals(key)) {
			result = head.data;
			head = head.next;
			size--;
		}else {
			Node<T> trav = head.next , prev = head;
			/*boolean isFound = false;
			while (trav != null) {
				if(trav.data.equals(data)) { isFound = true; break; }
				prev = trav;
				trav = trav.next;
			}
			if(isFound) {
				out = trav.data;
				prev.next = trav.next;
				trav.next = null;
				size--;
			}else
				out = null;*/
			while (trav != null && !trav.data.equals(key)) {
				prev = trav;
				trav = trav.next;
			}
			if(trav!=null) {
				result = trav.data;
				prev.next = trav.next;
				trav.next = null;
				size--;
			}
		}
		return result;
	}
	
	public T removeFront() {
		T result = null;
		if(size == 0) System.out.println("List is empty");
		else {
			result = head.data;
			head = head.next;
			size--;
		}
		return result;
	}
	
	public T removeTail() {
		T result = null;
		if(size == 0) System.out.println("List is empty");
		else {
			Node<T> trav = head, prev = null;
			while (trav.next != null) {
				prev=trav;
				trav = trav.next;
			}
			result = trav.data;
			if(trav==head)
				head = null;
			else
				prev.next = null;
			size--;
		}
		return result;
	}
	
	public T removeAtV1(int index) {
		T result = null;
		if (size == 0 ) System.out.println("List is empty.");
		else if (index >= size || index < 0) System.out.println("Invalid index.");
		else {
			Node<T> trav = head, prev = null;
			int i = 1;
			while (trav != null && i<=index) {
				prev= trav;
				trav = trav.next;
				i++;
			}
			result = trav.data;
			if(prev == null) 
				head = trav.next;
			else
				prev.next = trav.next;
			size--;
		}
		
		return result;
	}
	
	public T removeAt(int index) {
		T result = null;
		
		// index points to head // index greater than no of el // index lies in between
		
		Node<T> temp = head;
		if(size==0) {
			System.out.println("List is empty.");
			return result;
		}else if(index==0) {
			result = head.data;
			head = head.next;
			size--;
			return result;
		}
		
		for (int i = 0; temp!=null && i < index-1; i++) {
			temp=temp.next;
		}
		
		if( temp==null || temp.next == null ) {
			System.out.println("Invalid index.");
			return result;
		}
		
		result = temp.next.data;
		temp.next = temp.next.next;
		size--;
		return result;
	}
	
	public void reverse() {
		Node<T> prev = null, current = head, next = head;
		
		while (current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	public static class Node<E> {
		E data;
		Node<E> next;
		public Node(E data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public boolean hasNext() {
			return this.next!=null;
		}
	}
	
	@Override
	public String toString() {
		if (size == 0) return "[]";
		StringBuffer sb = new StringBuffer("[");
		Node<T> trav = head;
		while (trav != null) {
			sb.append(trav.data+",");
			trav = trav.next;
		}
		sb.setLength(sb.length()-1);
		
		return sb.append("]").toString();
	}
	
	public static void main(String[] args) throws Exception {
		SinglyLinkedList<Object> list = new SinglyLinkedList<Object>();
		list.push(1);
		list.push(2);
		list.push(3);
		System.out.println(list);
		
		list.pushLast(4);
		System.out.println(list);
		
		list.pushAt(2, 5);
		
		System.out.println(list);
		
		list.pushAfter(list.get(1), 10);
		System.out.println(list);

		list.remove(5);
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
		
		/*list.remove(3);
		System.out.println(list);
		
		list.remove(4);
		System.out.println(list);
		*/
		/*list.remove(2);
		System.out.println(list);
		
		list.removeFront();
		System.out.println(list);
		
		System.out.println(list.removeTail());
		System.out.println(list);*/
//		System.out.println("removeAt(3) :: "+list.removeAt(3));
//		System.out.println(list);		
//		System.out.println("removeAt(1) :: "+list.removeAt(1));
//		System.out.println(list);
//		System.out.println(list.size);
//		System.out.println("removeAt(0) :: "+list.removeAt(0));
//		System.out.println(list);
//		System.out.println("removeAt(0) :: "+list.removeAt(0));
//		System.out.println(list);
//		System.out.println("removeAt(0) :: "+list.removeAt(0));
		list.reverse();
		System.out.println("Reverse() :: "+list);
			
	}
}
