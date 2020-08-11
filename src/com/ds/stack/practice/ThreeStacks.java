package com.ds.stack.practice;

import java.util.Arrays;

/**
 * Describe how you could use a single array to implement three stacks
 *
 * Solution:
 * Divide the array in three equal parts and allow the individual stack to grow in that limited space (note: “[“ means inclusive, while “(“ means exclusive of the end point)
 * » for stack 1, we will use [0, n/3)
 * » for stack 2, we will use [n/3, 2n/3)
 * » for stack 3, we will use [2n/3, n)
 */

public class ThreeStacks {
  int stackSize = 300;
  int[] buffer = new int[stackSize * 3];
  
  // stack pointers to track top elements
  int[] stackPointer = {0, 0, 0};
  
  void push(int stackNum, int value) {
    /**
     * Find the index of the top element in the array + 1
     * and increment the stack pointer
     */
    
    int index = (stackNum * stackSize) + stackPointer[stackNum] + 1;
    stackPointer[stackNum]++;
    buffer[index] = value;
  }
  
  int pop(int stackNum) {
    int index = stackNum * stackSize + stackPointer[stackNum];
    stackPointer[stackNum]--;
    int value = buffer[index];
    buffer[index]=0;
    return value;
  }
  
  int peek(int stackNum) {
    int index = stackNum * stackSize + stackPointer[stackNum];
    return buffer[index];
  }
  
  boolean isEmpty(int stackNum) {
    return stackPointer[stackNum] == (stackNum * stackSize);
  }
  
  public static void main(String[] args) {
    ThreeStacks stack = new ThreeStacks();
  
    for (int i = 1; i <= 299; i++) {
      stack.push(0, i);
      stack.push(1, i*2);
      stack.push(2, i*3);
    }
  
    System.out.println(Arrays.toString(stack.buffer));
    System.out.println("\nPeek from elements ==> ");
    System.out.println(stack.peek(0));
    System.out.println(stack.peek(1));
    System.out.println(stack.peek(2));
  }
}
