package com.ds.stack.practice;

import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order You should not make any assump- tions about how the stack is implemented
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty
 *
 * Solution:
 * Sorting can be performed with one more stack The idea is to pull an item from the original stack and push it on the other stack If pushing this
 * item would violate the sort order of the new stack, we need to remove enough items from it so that it’s possible to push the new item Since
 * the items we removed are on the original stack, we’re back where we started The algorithm is O(N^2) and appears below
 */

public class SortingStack {
  public static Stack<Integer> sort(Stack<Integer> stack) {
    Stack<Integer> newStack = new Stack();
    
    while (!stack.isEmpty()) {
      int tmp = stack.pop();
      while (!newStack.isEmpty() && newStack.peek() > tmp) {
        stack.push(newStack.pop());
      }
      newStack.push(tmp);
    }
    
    return newStack;
  }
  
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack();
  
    stack.push(15);
    stack.push(3);
    stack.push(8);
    stack.push(12);
    stack.push(20);
  
    sort(stack).forEach(System.out::println);
  }
  
}
