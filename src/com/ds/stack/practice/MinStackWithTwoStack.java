package com.ds.stack.practice;

/**
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time
 *
 * Solution 2:
 *
 * We can (maybe) do a bit better than this by using an additional stack which keeps track of the mins
 */

import com.ds.stack.StackDynamicArray;

public class MinStackWithTwoStack extends StackDynamicArray<Integer> {
  StackDynamicArray minStack = new StackDynamicArray();
  
  @Override
  public void push(Object item) {
    if ((int) item <= min()) {
      minStack.push(item);
    }
    super.push(item);
  }
  
  @Override
  public Integer pop() {
    int value = super.pop();
    if (value == min()) {
      minStack.pop();
    }
    return value;
  }
  
  public int min() {
    if (minStack.isEmpty()) {
      return Integer.MAX_VALUE;
    } else {
      return (int) minStack.peek();
    }
  }
  
  public static void main(String[] args) {
    MinStackWithTwoStack minStack = new MinStackWithTwoStack();
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
