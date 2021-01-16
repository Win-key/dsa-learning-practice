package com.ds;

import java.util.NoSuchElementException;

public class DynamicArray<T> {
	
	private int len = 0;
	private int capacity=0;
	private T[] arr;
	
	public static void main(String[] args) {
		DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>(7);
		dynamicArray.add(0);
		dynamicArray.add(10);
		dynamicArray.add(20);
		dynamicArray.add(30);
		dynamicArray.add(40);
		dynamicArray.add(50);
		
		System.out.println(dynamicArray.toString());
		
		dynamicArray.remove(3);
		System.out.println(dynamicArray.toString());
		dynamicArray.remove(0);
		
		System.out.println(dynamicArray.toString());
		dynamicArray.remove(1);
		System.out.println(dynamicArray.toString());
		dynamicArray.remove(2);
		System.out.println(dynamicArray.toString());
	}
	
	public DynamicArray() {
		this(10);
	}

	public DynamicArray(int capacity) {
		this.arr = (T[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	public void add(T object) {
		if(len+1 >= capacity) {
			if(capacity == 0) capacity = 1;
			else capacity *= 2;
			
			T[] newArr = (T[]) new Object[capacity];
			for (int i = 0; i < size(); i++) {
				newArr[i] = arr[i];  
			}
			arr = newArr;
		}
		arr[len++] = object;
	}
	
	public void remove(int index) {
		if(index < 0) {throw new IndexOutOfBoundsException("Invalid index");}
		boolean isRemoved = false;
		for (int i = 0; i<len; i++) {
			if (index == i) isRemoved = true;
			if(!isRemoved )
				arr[i]= arr[i];
			else
				arr[i]= arr[i+1];
		}
		arr[len-1] = null;len--;
	}
	
	public void remove(T object) {
		int index;
		if((index = indexOf(object))> -1) 
			remove(index);
		else 
			throw new NoSuchElementException("Element not found in the array.");
	}
	
	public int indexOf(T object) {
		if (object == null) throw new NullPointerException("Null values are not allowed");
		for (int i = 0; i < len; i++) {
			if (arr[i]==object) return i;
		}
		return -1;
	}
	
	public int size() {
		return this.len;
	}
	
	public T get(int index) {
		return arr[index];
	}
	
	public void set(T object, int index) {
		arr[index] = object;
	}
	
	@Override
	public String toString() {
		String arrStr = "";
		for (int i = 0; i < len; i++) {
			arrStr += arr[i] + "  ";
		}
		return arrStr;
	}

}
