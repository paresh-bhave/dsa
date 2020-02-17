package com.ds.linear.stack;

public class StackArray<T> {
	private Object[] elemets;
	private int size;
	private int top;
	
	public StackArray(int s) {
		size = s;
		elemets = new Object[size];
		top = -1;
	}
	
	public void push(Object item) {
		if (isFull()) {
			System.out.println("stack is full");
			return;
		}
		top += 1;
		elemets[top] = item;
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return null;
		}
		T item = (T) elemets[top];
		top -= 1;
		return item;
	}
	
	public boolean isFull() {
		return top == (size - 1);
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
}
