package com.ds.stack.practice;

import com.ds.linkedlist.SinglyNode;
import com.ds.stack.StackDynamicArray;

/**
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time
 *
 * Solution 1:
 * You can implement this by having each node in the stack keep track of the minimum beneath itself
 * Then, to find the min, you just look at what the top element thinks is the min
 *
 * When you push an element onto the stack, the element is given the current minimum It sets its “local min” to be the min
 *
 * Problem: There’s just one issue with this: if we have a large stack, we waste a lot of space by keeping track of the min for every single element
 */

public class MinStack extends StackDynamicArray<SinglyNode> {
  @Override
  public void push(Object item) {
    int newMin = Math.min((int) item, min());
    SinglyNode minNode = new SinglyNode(newMin, null);
    super.push(new SinglyNode(item, minNode));
  }
  
  public int min() {
    if (this.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return (int) peek().next.value;
    }
  }
  
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(15);
    minStack.push(99);
    minStack.push(3);
    minStack.push(15000);
    minStack.push(20);
  
    System.out.println("Min in original stack ==>  ");
    System.out.println(minStack.min());
    minStack.pop();
    minStack.pop();
    minStack.pop();
    minStack.pop();
  
    System.out.println("\nMin after in popping 4 elements stack ==>  ");
    System.out.println(minStack.min());
  }
}
