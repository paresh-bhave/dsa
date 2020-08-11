package com.ds.array;

public class DynamicArrayMain {
	public static void main(String[] args) {
		DynamicArray<Integer> dynamicArray = new DynamicArray<Integer>();
		
		dynamicArray.put(11);
		dynamicArray.put(12);
		dynamicArray.put(13);
		
		System.out.println("Size: " + dynamicArray.getSize());
		
		for (int i = 0; i < dynamicArray.getSize() - 1; i++) {
			System.out.println("dynamicArray[" + i + "] = " + dynamicArray.get(i));
		}
	}
}
