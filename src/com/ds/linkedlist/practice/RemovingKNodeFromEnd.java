package com.ds.linkedlist.practice;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyNode;

/**
 * FAANMG
 */

public class RemovingKNodeFromEnd {
  static void deleteNode(SinglyNode head, int k) {
    SinglyNode node1 = head;
    SinglyNode node2 = head;
    
    while (k > 0) {
      node2 = node2.next;
      k--;
    }
    
    while (node2.next != null) {
      node1 = node1.next;
      node2 = node2.next;
    }
    
    SinglyNode temp = node1.next;
    node1.next = node1.next.next;
    temp = null;
  }
  
  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    
    list.add(6);
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(1);
    list.printListData();
  
    System.out.println("\n After deleting ==> ");
    deleteNode(list.head, 3);
    list.printListData();
  }
}
