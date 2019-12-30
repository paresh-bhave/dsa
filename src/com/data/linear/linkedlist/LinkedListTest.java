package com.data.linear.linkedlist;

public class LinkedListTest {
	public static void main(String[] args) {
		// Singly List
		SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
		
		singlyLinkedList.add("John");
		singlyLinkedList.add("Jake");
		singlyLinkedList.add("Joey");
		System.out.println("Singly Linked List ==>");
		singlyLinkedList.printListData();
		
		singlyLinkedList.delete();
		System.out.println("Singly Linked List After Deletion ==> ");
		singlyLinkedList.printListData();
		
		// Doubly Linked List
		DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();
		doublyLinkedList.add("Ted");
		doublyLinkedList.add("Marshall");
		doublyLinkedList.add("Lily");
		doublyLinkedList.add("Barney");
		doublyLinkedList.add("Robin");
		
		System.out.println("Doubly Linked List ==>");
		doublyLinkedList.printListData();
		
		doublyLinkedList.delete();
		System.out.println("Doubly Linked List After Deletion ==> ");
		doublyLinkedList.printListData();
	}
}
