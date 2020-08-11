package com.ds.stack;

import java.util.Arrays;

public class StackDynamicArray<T> {
	private Object[] elements;
	private int size;
	private int top;
	
	public StackDynamicArray() {
		size = 3;
		elements = new Object[size];
		top = -1;
	}
	
	public void push(Object item) {
		ensureCapacity(size + 2);
		top += 1;
		elements[top] = item;
	}
	
	public T pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return null;
		}
		T item = (T) elements[top];
		top -= 1;
		return item;
	}
  
  public T peek() {
    if (isEmpty()) {
      System.out.println("stack is empty");
      return null;
    }
    return (T) elements[top];
  }
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int getSize() {
		return elements.length;
	}
	
	private void ensureCapacity(int minSize) {
		int oldSize = getSize();
		if (minSize > oldSize) {
			int newSize = oldSize * 2;
			if (newSize < minSize) {
				newSize = minSize;
			}
			elements = Arrays.copyOf(elements, newSize);
		}
	}
}
