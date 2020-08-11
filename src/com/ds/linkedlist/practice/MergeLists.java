package com.ds.linkedlist.practice;

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyNode;

/**
 * You have two numbers represented by a linked list, where each node contains a sin- gle digit
 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list
 * Write a function that adds the two numbers and returns the sum as a linked list
 * EXAMPLE
 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 *
 * Solution:
 * We can implement this recursively by adding node by node, just as we would digit by digit
 * 1. result data = (node1 + node2 + any earlier carry) % 10
 * 2. if node1 + node2 > 10, then carry a 1 to the next addition
 * 3. add the tails of the two nodes, passing along the carry
 */

public class MergeLists {
  static SinglyNode addLists(SinglyNode headOfList1, SinglyNode headOfList2, int carry) {
    if (headOfList1 == null && headOfList2 == null) return null;
    
    SinglyNode result = new SinglyNode(carry, null);
    
    int value = carry;
    
    if (headOfList1 != null) {
      value += (int) headOfList1.value;
    }
    
    if (headOfList2 != null) {
      value += (int) headOfList2.value;
    }
    
    result.value = value % 10;
    
    SinglyNode nextHead1 = headOfList1 == null ? null : headOfList1.next;
    SinglyNode nextHead2 = headOfList2 == null ? null : headOfList2.next;
    int carry1 = value >= 10 ? 1 : 0;
    
    SinglyNode next = addLists(nextHead1, nextHead2, carry1);
    
    result.next = next;
    return result;
  }
  
  public static void main(String[] args) {
    SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    list1.add(5);
    list1.add(1);
    list1.add(3);
  
    SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
    list2.add(2);
    list2.add(9);
    list2.add(5);
    
    SinglyNode newHead = addLists(list1.head, list2.head, 0);
    
    while (newHead != null) {
      System.out.printf("%d -> ", newHead.value);
      newHead = newHead.next;
    }
  }

}
