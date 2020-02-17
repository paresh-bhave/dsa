package com.collections;

import java.util.Stack;

/**
 * Stack DS implementation in java collections using DynamicArray
 */

public class StackMain {
  public static void main(String[] args) {
    Stack<Integer> ids = new Stack<>();
    
    ids.push(1);
    ids.push(5);
    ids.push(6);
    ids.push(2);
    ids.push(100);
  
    // Last in First Out
    System.out.println(ids.pop());
    System.out.println(ids.pop());
    System.out.println(ids.pop());
    System.out.println(ids.pop());
  }
}
