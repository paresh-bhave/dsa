package com.algo.search;

import java.util.Arrays;

/**
 * The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n).
 *
 * We basically ignore half of the elements just after one comparison.
 *
 *  Compare x with the middle element.
 *  If x matches with middle element, we return the mid index.
 *  Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element. So we recur for right half.
 *  Else (x is smaller) recur for the left half.
 *
 * Complexity: O(log n)
 */

public class BinarySearchMain {
  
  static int search(int[] arr, int left, int right, int x) {
    if (right >= left) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == x) {
        return mid;
      }
      if (arr[mid] > x) {
        return search(arr, left, mid-1, x);
      }
      return search(arr, mid + 1, right, x);
    }
    return -1;
  }
  
  public static void main(String[] args) {
    int[] arr = {2,3,48,95,65,100,78,53,47,49,36,50};
    
    Arrays.sort(arr);
    
    int result = search(arr, 0, arr.length - 1, 65);
    
    if (result == -1) {
      System.out.println("Element is not present in the array");
    } else {
      System.out.println("Element is found at index: " + result);
    }
  }
}
