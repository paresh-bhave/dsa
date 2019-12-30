package com.data.linear.linkedlist;

public class DoublyNode {
	Object value;
	DoublyNode next;
	DoublyNode previous;
	
	public DoublyNode(Object v, DoublyNode n, DoublyNode p) {
		value = v;
		next = n;
		previous = p;
	}
}
