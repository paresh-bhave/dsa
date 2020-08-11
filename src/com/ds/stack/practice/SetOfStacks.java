package com.ds.stack.practice;

import java.util.ArrayList;

/**
 * Imagine a (literal) stack of plates If the stack gets too high, it might topple There- fore, in real life, we would likely start a new stack when
 * the previous stack exceeds some threshold Implement a data structure SetOfStacks that mimics this SetOf- Stacks should be composed of several
 * stacks, and should create a new stack once the previous one exceeds capacity SetOfStacks push() and SetOfStacks pop() should behave identically to a
 * single stack (that is, pop() should return the same values as it would if there were just a single stack)
 * <p>
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack
 */

public class SetOfStacks {
  ArrayList<Stack> stacks = new ArrayList<>();
  public int capacity;
  
  public SetOfStacks(int capacity) {
    this.capacity = capacity;
  }
  
  public Stack getLastStack() {
    if (stacks.size() == 0) return null;
    return stacks.get(stacks.size() - 1);
  }
  
  public void push(int v) {
    Stack lastStack = getLastStack();
    if (lastStack != null && !lastStack.isAtCapacity()) {
      lastStack.push(v);
    } else {
      Stack stack = new Stack(capacity);
      stack.push(v);
      stacks.add(stack);
    }
  }
  
  public int pop() {
    Stack last = getLastStack();
    int v = last.pop();
    if (last.size == 0) stacks.remove(stacks.size() - 1);
    return v;
  }
  
  public int popAt(int index) {
    return leftShift(index, true);
  }
  
  public int leftShift(int index, boolean removeTop) {
    Stack stack = stacks.get(index);
    int removed_item;
    if (removeTop) removed_item = stack.pop();
    else removed_item = stack.removeBottom();
    if (stack.isEmpty()) {
      stacks.remove(index);
    } else if (stacks.size() > index + 1) {
      int v = leftShift(index + 1, false);
      stack.push(v);
    }
    return removed_item;
  }
}
