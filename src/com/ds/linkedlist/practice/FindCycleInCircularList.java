package com.ds.linkedlist.practice;

/**
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
 *
 * DEFINITION: Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list
 *
 * E.g.
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier] Output: C
 *
 * If we move two pointers, one with speed 1 and another with speed 2, they will end up meet- ing if the linked list has a loop
 *
 * We know:
 * 1 Head is k nodes from LoopStart (by definition)
 * 2 MeetingPoint for n1 and n2 is k nodes from LoopStart (as shown above)
 *
 * Thus, if we move n1 back to Head and keep n2 at MeetingPoint, and move them both at the same pace, they will meet at LoopStart
 */

import com.ds.linkedlist.SinglyLinkedList;
import com.ds.linkedlist.SinglyNode;

public class FindCycleInCircularList {
  static SinglyNode findStart(SinglyNode head) {
    SinglyNode n1 = head;
    SinglyNode n2 = head;
  
    // Find meeting point
    while (n2.next != null) {
      n1 = n1.next;
      n2 = n2.next.next;
      if (n1.equals(n2)) {
        break;
      }
    }
  
    // Error check - there is no meeting point, and therefore no loop
    if (n2.next == null) return null;
  
    /* Move n1 to Head. Keep n2 at Meeting Point. Each are k steps /* from the Loop Start. If they move at the
    same pace, they must * meet at Loop Start. */
    
    n1 = head;
    while (n1 != n2) {
      n1 = n1.next;
      n2 = n2.next;
    }

    // Now n2 points to the start of the loop.
    return n2;
  }
  
  public static void main(String[] args) {
    SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
    list1.add(5); // head
    list1.add(1); // next
    list1.add(3); // next
    list1.add(6); // next
    list1.add(9); // next == head.next.next --> 3
    
    // creating cycle
    
    list1.head.next.next.next.next = list1.head.next.next;
    
    SinglyNode start = findStart(list1.head);
    System.out.println(" Start of the circle ==> " + start.value);
  }
}
