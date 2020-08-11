package com.ds.linkedlist.practice;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyNode;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list
 *
 * Solution:
 * 1. Create two pointers, p1 and p2, that point to the beginning of the node
 * 2. Increment p2 by n-1 positions, to make it point to the nth node from the beginning (to make the distance of n between p1 and p2)
 * 3. Check for p2->next == null if yes return value of p1, otherwise increment p1 and p2 If next of p2 is null it means p1 points to the nth node from the last as the distance between the two is n
 * 4. Repeat Step 3
 */

public class RemoveNthNode {
  static SinglyNode nthToLast(SinglyNode head, int n) {
    if (head == null || n < 1) return null;
    
    SinglyNode p1 = head;
    SinglyNode p2 = head;
  
    for (int i = 0; i < n - 1; i++) {
      if (p2 == null) return null;
      p2 = p2.next;
    }
    
    while (p2.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1;
  }
  
  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
  
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
  
    System.out.println("Before removing nth node ==> ");
    list.printListData();
  
    SinglyNode node = nthToLast(list.head, 3);
    System.out.println("Removing 3rd node from last ==> " + node.value);
    list.printListData();
  }
}
