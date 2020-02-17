package com.ds.linear.linkedlist;

public class DoublyLinkedList<T> {
	DoublyNode head;
	
	public DoublyLinkedList() {
		head = null;
	}
	
	public void add(Object value) {
		DoublyNode newNode = new DoublyNode(value, null, null);
		if (head != null) {
			newNode.next = head;
			head.previous = newNode;
		}
		head = newNode;
	}
	
	public void delete() {
		head = head.next;
		head.previous = null;
	}
	
	public void printListData() {
		DoublyNode n = head;
		while (n != null) {
			System.out.println("NODE ==> " + (T) n.value);
			n = n.next;
		}
	}
	
}
