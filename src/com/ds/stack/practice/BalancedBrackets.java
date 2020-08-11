package com.ds.stack.practice;

import java.util.Stack;

public class BalancedBrackets {
  static String isBalanced(String s) {
    Stack<Character> s1 = new Stack<>();
  
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '{':
        case '[':
        case '(':
          s1.push(c);
          break;
        case '}': {
          if (s1.isEmpty() || s1.peek() != '{') {
            return "NO";
          }
          s1.pop();
          break;
        }
        case ']': {
          if (s1.isEmpty() || s1.peek() != '[') {
            return "NO";
          }
          s1.pop();
          break;
        }
        case ')': {
          if (s1.isEmpty() || s1.peek() != '(') {
            return "NO";
          }
          s1.pop();
          break;
        }
      }
    }
    return !s1.isEmpty() ? "NO" : "YES";
  }
  
  public static void main(String[] args) {
    System.out.println(isBalanced("((]()(]([({]}({[)){}}[}({[{])(]{()[]}}{)}}]]{({)[}{("));
//    System.out.println(isBalanced("{[()]}"));
//    System.out.println(isBalanced("{[(])}"));
//    System.out.println(isBalanced("{{[[(())]]}}"));
//    System.out.println(isBalanced("{{([])}}"));
//    System.out.println(isBalanced("{{)[](}}"));
  }
}
