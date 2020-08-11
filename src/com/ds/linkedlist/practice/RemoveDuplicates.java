package com.ds.linkedlist.practice;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyNode;
import java.util.HashMap;

/**
 * Write code to remove duplicates from an unsorted linked list FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * Solution:
 * 1. With Space tarde-off: keep track of elements in a hashtable and remove any dups:
 * 2. With Time trade off: Without a buffer, we can iterate with two pointers:
 * “current” does a normal iteration, while “runner” iterates through all prior nodes
 * to check for dups Runner will only see one dup per node, because if there were
 * multiple duplicates they would have been removed already
 */

public class RemoveDuplicates {
  
  // with buffer space
  static void removeDuplicatesBuff(SinglyNode head) {
    HashMap<Object, Boolean> map = new HashMap<>();
    SinglyNode current = head;
    SinglyNode previous = null;
    
    while (current != null) {
      if (map.containsKey(current.value)) {
        previous.next = current.next;
      } else {
        map.put(current.value, true);
        previous = current;
      }
      current = current.next;
    }
  }
  
  // without buffer
  static void removeDuplicates(SinglyNode head) {
    if (head == null) return;
    
    SinglyNode previous = head;
    SinglyNode current = head.next;
    
    while (current != null) {
      SinglyNode runner = head;
      
      // check for earlier dups
      while (runner != current) {
        
        if (runner.value == current.value) {
          // remove current
          SinglyNode tmp = current.next;
          previous.next = tmp;
  
          // update current to next node
          current = tmp;
  
          // all other dups have already been removed
          break;
        }
        
        // current not updated - update now
        if (runner == current) {
          previous = current;
          current = current.next;
        }
      }
    }
  }
  
  
  
  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    
    list.add(9);
    list.add(8);
    list.add(9);
    list.add(8);
    list.add(7);
    list.add(6);
    list.add(7);
    list.add(6);
    list.add(5);
    list.add(4);
    list.add(5);
    list.add(4);
    list.add(3);
    list.add(2);
    list.add(3);
    list.add(2);
    list.add(1);
    
    System.out.println("Before duplicate ==> ");
    list.printListData();
    
    removeDuplicatesBuff(list.head);
    System.out.println("\nAfter duplicates removed with buffer strategy ==> ");
    list.printListData();
  
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
  
    System.out.println("\nAfter adding new duplicates ==> ");
    list.printListData();
  
    removeDuplicatesBuff(list.head);
    System.out.println("\nAfter duplicates removed with no buffer strategy ==> ");
    list.printListData();
  }
}
