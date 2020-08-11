package com.ds.stack.practice;

import java.util.Stack;

public class EqualHeights {
  static int equalStacks(int[] h1, int[] h2, int[] h3) {
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    
    boolean equal = false;
    
    int index1 = 0;
    int index2 = 0;
    int index3 = 0;
  
  
    for (int i = 0; i < h1.length; i++) {
      sum1 += h1[i];
    }
  
    for (int i = 0; i < h2.length; i++) {
      sum2 += h2[i];
    }
  
    for (int i = 0; i < h3.length; i++) {
      sum3 += h3[i];
    }
    
    while(!equal) {
      if((sum1 == sum2) && ( sum1 == sum3)) {
        equal = true;
      } else {
        if(sum1 > sum2) {
          if(sum1 > sum3) {
            sum1 -= h1[index1];
            index1++;
          } else {
            sum3 -=h3[index3];
            index3++;
          }
        } else {
          if(sum2 > sum3) {
            sum2 -= h2[index2];
            index2++;
          } else {
            sum3 -= h3[index3];
            index3++;
          }
        }
      }
    }
    return sum1;
  }
  
  public static void main(String[] args) {
    int n1[] = { 3, 2, 1, 1, 1 };
    int n2[] = { 4, 3, 2 };
    int n3[] = { 1, 1, 4, 1 };
  
    System.out.println(equalStacks(n1, n2, n3));
  }
}
