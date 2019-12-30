package com.data.linear.stack;

import com.data.linear.linkedlist.SinglyNode;

public class StackLinkedList<T> {
	SinglyNode top;
	
	public StackLinkedList() {
		top = null;
	}
	
	public void push(Object value) {
		SinglyNode newNode = new SinglyNode(value, null);
		if (top != null) {
			newNode.next = top;
		}
		top = newNode;
	}
	
	public T pop() {
		if (top == null) {
			System.out.println(" Stack List is full");
			return null;
		}
		T value = (T) top.value;
		top = top.next;
		return value;
	}
}
