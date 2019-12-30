package com.data.linear.stack;

public class StackTest {
	public static void main(String[] args) {
		// StackArray test
		StackArray<Integer> stackArray = new StackArray<Integer>(5);
		stackArray.push(10);
		stackArray.push(5);
		stackArray.push(12);
		stackArray.push(39);
		stackArray.push(100);
		stackArray.push(50); // should throw full message here
		
		System.out.println("STACK ARRAY POP ==> " + stackArray.pop());
		
		// StackDynamicArray test
		StackDynamicArray<Integer> stackDynamicArray = new StackDynamicArray<Integer>();
		stackDynamicArray.push(10);
		stackDynamicArray.push(5);
		stackDynamicArray.push(12);
		stackDynamicArray.push(39);
		stackDynamicArray.push(100);
		stackDynamicArray.push(50);
		
		System.out.println("STACK DYNAMIC ARRAY POP ==> " + stackDynamicArray.pop());
		
		// StackLinkedList Test
		StackLinkedList<String> stackLinkedList = new StackLinkedList<String>();
		stackLinkedList.pop();
		stackLinkedList.push("John");
		stackLinkedList.push("Jena");
		
		System.out.println(stackLinkedList.pop());
		System.out.println(stackLinkedList.pop());
	}
}
