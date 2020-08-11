package com.ds.stack.practice;

import java.util.Stack;

public class GameOfTwoStacks {
  static int twoStacks(int x, int[] a, int[] b) {
    int counter = 0;
    
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2= new Stack<>();
  
    for (int i = a.length - 1; i >= 0; i--) {
      s1.push(a[i]);
    }
  
    for (int i = b.length - 1; i >= 0; i--) {
      s2.push(b[i]);
    }
  
    for (int sum = 0; sum <= x;) {
      if (!s1.isEmpty() && !s2.isEmpty()) {
        if (s1.peek() < s2.peek()) sum += s1.pop();
        else sum += s2.pop();
        ++counter;
      } else if (s2.isEmpty()) {
        sum += s1.pop();
        ++counter;
      } else if (s1.isEmpty()) {
        sum += s2.pop();
        ++counter;
      }
    }
    
    return counter;
  }
  
  public static void main(String[] args) {
    int a[] = {7, 15, 12, 0, 5, 18, 17, 2, 10, 15, 4, 2, 9, 15, 13, 12, 16};
    int b[] = {12, 16, 6, 8, 16, 15, 18, 3, 11, 0, 17, 17, 6, 11, 14, 13, 15, 6, 18, 6, 16, 12, 16, 11, 16, 11};
    System.out.println(twoStacks(62, a, b));
  }
}
