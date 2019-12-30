package com.data.linear.linkedlist;

public class SinglyLinkedList<T> {
	SinglyNode head;
	
	public SinglyLinkedList() {
		head = null;
	}
	
	public void add(Object value) {
		SinglyNode newNode = new SinglyNode(value, null);
		if (head != null) {
			newNode.next = head;
		}
		head = newNode;
	}
	
	public void delete() {
		head = head.next;
	}
	
	public void printListData() {
		SinglyNode n = head;
		while (n != null) {
			System.out.println("NODE ==> " + (T) n.value);
			n = n.next;
		}
	}
}
