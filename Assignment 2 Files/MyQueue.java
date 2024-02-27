package assignment_2;

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	private T[]queue;
	private int index;
	private int numEntries;
	private static final int DEFAULT_C=20;
	private static final int MAX_C=30;
	
	
	
	public MyQueue() {
		this(DEFAULT_C);
	}
	public MyQueue(int cap) {
		if(cap>MAX_C) {
			cap=MAX_C;
		}
		@SuppressWarnings("unchecked")

		T[]tempS=(T[])new Object[cap];
		queue=tempS;
		index=0;
		numEntries=0;
		
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return numEntries==0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return numEntries==queue.length;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}else {
			T front=queue[index];
			queue[index]=null;
			index++;
			numEntries--;
			return front;
		}
		// TODO Auto-generated method stub
		
		
		
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numEntries;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new QueueOverflowException();
		}else {
			queue[numEntries]=e;
			numEntries++;
			return true;

		}
	}
	
	public String toString() {
		return toString(" ");
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String s="";
		for(T e:queue) {
			if(e!=null) {
				s+=e;
				s+=delimiter;
			}
		}
		return s;
	}

	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		// TODO Auto-generated method stub
		for(T e:list) {
			T item=e;
			enqueue(item);
		}
	}
	
	


}
