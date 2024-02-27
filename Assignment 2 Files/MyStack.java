package assignment_2;

import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private T[]stack;
	private int topIndex;
	private static final int DEFAULT_C=20;
	private static final int MAX_C=30;
	
	public MyStack() {
		this(DEFAULT_C);
	}
	public MyStack(int cap) {
		if(cap>MAX_C) {
			cap=MAX_C;
		}
		@SuppressWarnings("unchecked")

		T[]tempS=(T[])new Object[cap];
		stack=tempS;
		topIndex=-1;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topIndex<0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return topIndex==stack.length-1;
	}

	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException();
		}else {
			T top=stack[topIndex];
			stack[topIndex]=null;
			topIndex--;
			return top;
		}
	}

	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new StackUnderflowException();
		}else {
			return stack[topIndex];
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return topIndex+1;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		// TODO Auto-generated method stub
		if(isFull()) {
			throw new StackOverflowException();
		}else {
			stack[topIndex+1]=e;
			topIndex++;
			return true;
		}
	}
	public String toString() {
		String s="";
		for(T e:stack) {
			if(e!=null) {
				s+=e+ " ";
			}
			
		}
		return s;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String s="";
		for(T e:stack) {
			if(e!=null) {
				s+=e;
				s+=delimiter;
			}
		
		}
		return s;
	}

	@Override
	public void fill(ArrayList<T> list) throws StackOverflowException {
		// TODO Auto-generated method stub
		for(T e:list) {
			T item=e;
			push(item);
		}
	}

}
