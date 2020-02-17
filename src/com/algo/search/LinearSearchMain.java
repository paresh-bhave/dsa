package com.algo.search;

/**
 * A simple approach is to do linear search
 *
 * Start from the leftmost element of arr[] and one by one compare x with each element of arr[]
 * If x matches with an element, return the index.
 * If x doesn’t match with any of elements, return -1.
 *
 * Complexity: O(n)
 */

public class LinearSearchMain {
  public static int search(int[] arr, int x) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      if (arr[i] == x) return i;
    }
    return -1;
  }
  
  public static void main(String[] args) {
    int[] arr = {2,3,48,95,65,100,78,53,47,49,36,50};
    
    int result = search(arr, 65);
    
    if (result == -1) {
      System.out.println("Element is not present in the array");
    } else {
      System.out.println("Element is found at index: " + result);
    }
  }
}
