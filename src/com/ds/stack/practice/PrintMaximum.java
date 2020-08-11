package com.ds.stack.practice;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class PrintMaximum {
  private static Stack<Integer> stack = new Stack<>();
  private static Stack<Integer> maxStack = new Stack<>();
  
  private static final Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
  
    for (int i = 0; i < n; i++) {
      String[] n1N2N3 = scanner.nextLine().split(" ");
      int n1, n2 = 0;
      
      n1 = Integer.parseInt(n1N2N3[0].trim());
  
      if (n1N2N3.length >= 2) {
        n2 = Integer.parseInt(n1N2N3[1].trim());
      }
      
      switch (n1) {
        case 1: {
          stack.push(n2);
          if (maxStack.isEmpty() || n2 > maxStack.peek()) {
            maxStack.push(n2);
          } else {
            maxStack.push(maxStack.peek());
          }
          break;
        }
        case 2: {
          stack.pop();
          maxStack.pop();
          break;
        }
        case 3: {
          System.out.println(maxStack.peek());
          break;
        }
      }
      
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    }
  
    scanner.close();
  }
}
