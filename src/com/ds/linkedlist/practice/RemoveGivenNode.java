package com.ds.linkedlist.practice;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list,
 * given only access to that node
 *
 * Input: the node ‘c’ from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 *
 * Solution:
 * The solution to this is to simply copy the data from the next node into this node and
 * then delete the next node
 *
 * NOTE: This problem can not be solved if the node to be deleted is the last node in the linked l
 * list That’s ok—your interviewer wants to see you point that out You could consider marking
 * it as dummy in that case This is an issue you should dis- cuss with your interviewer
 */

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyNode;

public class RemoveGivenNode {
  static boolean remove(SinglyNode node) {
    if (node == null || node.next == null) {
      return false;
    }
    
    SinglyNode next = node.next;
    node.value = next.value;
    node.next = next.next;
    return true;
  }
  
  public static void main(String[] args) {
    SinglyLinkedList<String> list = new SinglyLinkedList<>();
    
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("e");
  
    System.out.println("Before removing nth node ==> ");
    list.printListData();
  
    System.out.println("After removing middle node ==> " + remove(list.head.next.next));
    list.printListData();
  }
}
