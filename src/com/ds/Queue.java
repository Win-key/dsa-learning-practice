package com.ds;

import java.util.Arrays;

public class Queue {

	private int head;
	private int tail;
	private int size;
	private Object[] internalArray;
	
	public Queue(int capacity) {
		head = tail = -1;
		size = 0;
		internalArray = new Object[capacity];
	}
	
	public boolean addFirst(Object element) throws Exception {
		if(isFull()) throw new Exception("Queue is full");
		else if(isEmpty()) {
			head = 0; tail = 0;
		}else if(head-1<0)
			head= internalArray.length-1;
		else head--;
		
		internalArray[head]=element;
		size++;
		return true;
	}
	
	public boolean addLast(Object element) throws Exception {
		if(isFull()) throw new Exception("Queue is full");
		else if(isEmpty()) {
			head = 0;tail = 0;
		}else if(tail+1>=internalArray.length)
			tail =0;
		else tail++;
		
		internalArray[tail]=element;
		size++;
		return true;
	}

	
	public Object pollLast() throws Exception{
		Object out;
		if(isEmpty()) throw new Exception("Queue is empty");
		else if(tail-1<0) {
			out = internalArray[tail];
			tail = internalArray.length-1;
		}else 
			out = internalArray[tail--];
		size--;
		return out;
	}
	
	public Object pollFirst() throws Exception {
		Object out;
		if(isEmpty()) throw new Exception("Queue is empty");
		else if(head+1>=internalArray.length) {
			out = internalArray[head];
			head = 0;
		}else 
			out = internalArray[head++];
		size--;
		return out;
	}
	
	public Object peekFirst() throws Exception {
		if (isEmpty()) throw new Exception("Queue is empty");
		return internalArray[head];
	}
	
	public Object peekLast() throws Exception {
		if (isEmpty()) throw new Exception("Queue is empty");
		return internalArray[tail];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size == internalArray.length;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "[]";
		if(head > tail) {
			StringBuffer sb = new StringBuffer("[");
			for (int i = 0; i < internalArray.length; i++) {
				int index = (i+head)%internalArray.length;	
				if(!(index> tail && index< head))
					sb.append(internalArray[index]+ ",");
			}
			sb.setLength(sb.length()-1);
			sb.append("]");
			return sb.toString();
		}else {
			return Arrays.toString(Arrays.copyOfRange(internalArray, head, tail+1));
		}
	}

	public static void main(String[] args) {
		Queue queue = new Queue(3);
		try {
			operate("print", queue, null);
			operate("addFirst", queue, 1);
			operate("addLast", queue, 2);
			operate("addFirst", queue, 3);
			operate("print", queue, null);
			
			operate("peekFirst", queue, null);
			operate("pollFirst", queue, null);
			operate("pollLast", queue, null);
			
			operate("addFirst", queue, 4);
			operate("addLast", queue, 5);
			
			operate("peekLast", queue, null);
			operate("pollFirst", queue, null);
			operate("addFirst", queue, 6);
			operate("print", queue, null);
			

			operate("pollFirst", queue, null);
			operate("pollLast", queue, null);
			operate("pollFirst", queue, null);
			
//			operate("pollFirst", queue, null); // Exception
			
			operate("addFirst", queue, 1);
			operate("addFirst", queue, 2);
			operate("addLast", queue, 3);
			
			operate("pollFirst", queue, null);
			operate("addLast", queue, 100);
			operate("peekFirst", queue, null);
			
			operate("addLast", queue, 4); // Exception
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void operate(String key, Queue queue, Object element) throws Exception {
		switch (key) {
		case "addFirst":
			queue.addFirst(element);
			System.out.println(element + " added at start of queue : "+queue);
			break;
		case "addLast":
			queue.addLast(element);
			System.out.println(element + " added at end of queue : "+queue);
			break;
		case "peekFirst":
			System.out.println("peek First : " + queue.peekFirst());
			break;
		case "peekLast":
			System.out.println("peek Last : " + queue.peekLast());
			break;
		case "pollFirst":
			System.out.println(queue.pollFirst() + " poll from start. queue : "+ queue);
			break;
		case "pollLast":
			System.out.println(queue.pollLast() + " poll from end. queue : "+ queue);
			break;
		case "print":
			System.out.println(queue);
			break;
		default:
			System.out.println("Operation not valid");
			break;
		}
	}
	
}
