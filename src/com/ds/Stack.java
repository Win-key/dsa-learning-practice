package com.ds;

import java.util.Arrays;

public class Stack {

	private Object[] internalArray;
	private int size = 0;
	private static final int DEFAULT_SIZE = 10;
	private final boolean IS_SIZE_FIXED;
	
	public Stack() {
		this.internalArray = new Object[DEFAULT_SIZE];
		this.IS_SIZE_FIXED = false;
	}
	
	public Stack(int size) {
		this.internalArray = new Object[size];
		this.IS_SIZE_FIXED = true;
	}

	public void push(Object element) throws Exception {
		checkSize();
		this.internalArray[size++]=element;
	}

	private void checkSize() throws Exception {
		if(size+1 > internalArray.length){
			if(!IS_SIZE_FIXED)
				this.internalArray = Arrays.copyOf(internalArray, size*2);
			else 
				throw new Exception("Stack is full");
		}
	}
	
	public Object pop() throws Exception {
		if(size == 0) throw new Exception("Stack is Empty");
		return this.internalArray[--size];
	}
	
	public Object peek() {
		return this.internalArray[size-1];
	}
	
	public boolean isFull() {
		if(!IS_SIZE_FIXED) return false;
		else return (size+1) > internalArray.length;	
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Stack s = new Stack(3);
		try {
		System.out.println("Starts here");
		System.out.println(s.isEmpty()); //true
		System.out.println("Push 1,2,3");
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println("s.peek() : " + s.peek()); //3
		System.out.println("s.pop() : " + s.pop());//3
		System.out.println("s.peek() : " + s.peek());//2
		
		System.out.println("s.pop() : "+ s.pop());//2
		System.out.println("s.pop() : "+s.pop());//1
		//s.pop(); //Exception Empa
		
		System.out.println("Push 1,2,3");
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("s.isFull() : " + s.isFull()); //true;
		s.push(4); // eXcecption , ds
		
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
}
