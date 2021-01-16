package com.ds;

public class QueueV2 {

	private Object[] data;
	private int header;
	private int N;
	private int size;
	
	public QueueV2(int size){
		this.N = size;
		this.data = new Object[size];
	}
	
	public void addFirst(Object element) throws Exception {
		if(isFull())
			throw new Exception("Queue is full");
		data[header] = element;
		header = (header+1)%N;
		size++;
	}
	
	public void addLast(Object element) throws Exception {
		if(isFull())
			throw new Exception("Queue is full");
		data[(N-size-1+header)%N] = element;
		size++;
	}
	
	public Object peekFirst() throws Exception {
		if(isEmpty())
			throw new Exception("Queue is empty");
		return data[(N+header-1)%N];
	}
	
	public Object peekLast() throws Exception {
		if(isEmpty())
			throw new Exception("Queue is empty");
		return data[(header+N-size)%N];
	}
	
	
    public boolean isEmpty() {
		return this.size == 0;
	}
    
    public boolean isFull() {
		return this.size == this.N;
	}
    
    @Override
    public String toString() {
    	if(size==0) return "Queue is Empty";
    	StringBuilder sb = new StringBuilder();
    	for (int i=0;i<size;i++) {
			sb.append(data[(header+N-i-1)%N] +" ");
		}
    	return sb.toString();
    }
    
    private static void operate(String key, QueueV2 queue, Object element) throws Exception {
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
			System.out.println("Yet to impelement.");
//			System.out.println(queue.pollFirst() + " poll from start. queue : "+ queue);
			break;
		case "pollLast":
//			System.out.println(queue.pollLast() + " poll from end. queue : "+ queue);
			System.out.println("Yet to impelement.");
			break;
		case "print":
			System.out.println(queue);
			break;
		default:
			System.out.println("Operation not valid");
			break;
		}
	}
    
    public static void main(String[] args) {
		QueueV2 queue = new QueueV2(3);
		try {
			operate("print", queue, null);
			operate("addLast", queue, 0);
			operate("peekFirst", queue, null);
			operate("addFirst", queue, 1);
			operate("addLast", queue, 2);
			operate("addLast", queue, 3);
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
}