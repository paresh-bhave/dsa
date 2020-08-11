package com.ds.linkedlist.practice;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ListOps {
  
  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;
    
    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }
  
  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;
    
    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }
    
    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
      
      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }
      
      this.tail = node;
    }
  }
  
  /**
   * Print Linked List
   * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
   */
  static void printLinkedList(SinglyLinkedListNode head) {
    SinglyLinkedListNode n = head;
    while (n != null) {
      System.out.println(n.data);
      n = n.next;
    }
  }
  
  /*
   * Insert Node at Head
   * https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
   */
  static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    if (llist != null) {
      newNode.next = llist;
    }
    llist = newNode;
    return llist;
  }
  
  // Complete the insertNodeAtPosition function below.
  
  /*
   * Insert Node at Specific Position
   * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
   */
  static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    //create new node.
    SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
    newNode.next = null;
  
    if (head == null) {
      //if head is null and position is zero then exit.
      if (position != 0) {
        return null;
      } else { //node set to the head.
        head = newNode;
      }
    }
  
    if (head != null && position == 0) {
      newNode.next = head;
      head = newNode;
      return head;
    }
  
    SinglyLinkedListNode current = head;
    SinglyLinkedListNode previous = null;
  
    int i = 0;
  
    while (i < position) {
      previous = current;
      current = current.next;
    
      if (current == null) {
        break;
      }
      i++;
    }
  
    newNode.next = current;
    previous.next = newNode;
    
    return head;
  }
  
  /**
   * Delete a Node
   * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem?h_r=next-challenge&h_v=zen
   */
  static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

    SinglyLinkedListNode current = head;
    SinglyLinkedListNode previous = null;
  
    if (head != null && position == 0) {
      current = head.next;
      head = null;
      return current;
    }
    
    int i = 0;
    while (i < position) {
      previous = current;
      current = current.next;
      
      if (current == null) {
        break;
      }
      i++;
    }
    previous.next = current.next;
    current = null;
    
    return head;
  }
  
  
  /**
   * Print List in Reverse
   * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem?h_r=next-challenge&h_v=zen
   */
  static void reversePrint(SinglyLinkedListNode head) {
  
    SinglyLinkedListNode prev = null;
    SinglyLinkedListNode curr = head;
    
    while (curr != null) {
      SinglyLinkedListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    
    while (prev != null) {
      System.out.println(prev.data);
      prev = prev.next;
    }
  }
  
  /**
   * Check if has cyclic visit
   * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
   */
  static boolean hasCycle(SinglyLinkedListNode head) {
    boolean cycle = false;
    HashMap<SinglyLinkedListNode, Integer> map = new HashMap<>();
    
    if (head.next == null) {
      return cycle;
    }
    
    while (head.next != null) {
      if (map.get(head) == null) {
        map.put(head, 0);
      } else if (map.get(head) == 0) {
        map.put(head, (map.get(head)+1));
      } else if (map.get(head) >= 1) {
        cycle = true;
        break;
      }
      head = head.next;
    }
    return cycle;
  }
  
  
  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));
      
      node = node.next;
      
      if (node != null) {
        bufferedWriter.write(sep);
      }
    }
  }
  
  private static final Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    
    SinglyLinkedList llist = new SinglyLinkedList();
    
    int llistCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
    for (int i = 0; i < llistCount; i++) {
      int llistItem = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
      
      llist.insertNode(llistItem);
    }
    
    int data = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
    int position = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    
    SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);
    
    printSinglyLinkedList(llist_head, " ", bufferedWriter);
    bufferedWriter.newLine();
    
    bufferedWriter.close();
    
    scanner.close();
  }
}
