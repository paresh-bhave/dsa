package com.ds.stack.practice;

import com.ds.stack.StackDynamicArray;

/**
 * Evaluating math expression with 2 stacks
 */

public class TwoStackDikstra {
  public static void main(String[] args) {
    String expression = "(1+((2+3)*(4*5)))";
    
    StackDynamicArray<String> operators = new StackDynamicArray<>();
    StackDynamicArray<Double> operands = new StackDynamicArray<>();
  
    for (int i = 0; i < expression.length(); i++) {
      char c = expression.charAt(i);
      if (c == '(') {
        System.out.println("continuing..." + c);
        continue;
      } else if (c == '+' || c == '-' || c == '*' || c == '/') {
        System.out.println("operators..." + c);
        operators.push(c);
      } else if (c == ')') {
        
        double v1 = operands.pop();
        double v2 = operands.pop();
        String operator = String.valueOf(operators.pop());
        
        System.out.println("operands operation..." + v1 + " " + v2);
        
        switch (operator) {
          case "+": operands.push(v1 + v2); break;
          case "-": operands.push(v1 - v2); break;
          case "/": operands.push(v1 / v2); break;
          case "*": operands.push(v1 * v2); break;
        }
      } else if (Character.isDigit(c)){
        System.out.println("operands pushing..." + c);
        String operator = String.valueOf(c);
        operands.push(Double.valueOf(operator));
      }
    }
  
    System.out.printf("%s %.2f", expression, operands.pop());
  }
}
