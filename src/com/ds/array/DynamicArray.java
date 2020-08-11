package com.ds.array;

import java.util.Arrays;

public class DynamicArray<T> {
	private Object[] elemets;
	private int size;
	
	public DynamicArray() {
		size = 0;
		elemets = new Object[1];
	}
	
	public int getSize() {
		return elemets.length;
	}
	
	public T get(int index) {
		return (T) elemets[index];
	}
	
	public void put(Object element) {
		ensureCapacity(size + 1);
		elemets[size++] = element;
	}
	
	public void ensureCapacity(int minSize) {
		int oldSize = getSize();
		if (minSize > oldSize) {
			int newSize = oldSize * 2;
			if (newSize < minSize) {
				newSize = minSize;
			}
			elemets = Arrays.copyOf(elemets, newSize);
		}
	}
}
