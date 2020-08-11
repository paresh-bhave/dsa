package com.ds.linkedlist;

public class DoublyNode {
	public Object value;
	public DoublyNode next;
	public DoublyNode previous;
	
	public DoublyNode(Object v, DoublyNode n, DoublyNode p) {
		value = v;
		next = n;
		previous = p;
	}
}
