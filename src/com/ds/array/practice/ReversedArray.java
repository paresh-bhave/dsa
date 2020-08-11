package com.ds.array.practice;

public class ReversedArray {
  static int[] reverseArray(int[] a) {
    int[] temp = new int[a.length];
    int j = 0;
    for (int i = a.length-1; i >= 0; i--) {
      temp[j] = a[i];
      j++;
    }
    return temp;
  }
  
  public static void main(String[] args) {
    int test[] = {1,2,3,5};
    reverseArray(test);
  }
}
