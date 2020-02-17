package com.algo.sort;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 */

public class BubbleSortMain {
  static void sort(int[] arr, boolean descending) {
    boolean swapped;
    for (int i = 0; i < arr.length - 1; i++) {
      swapped = false;
      for (int j = 0; j < ((arr.length - i) - 1); j++) {
        /**
         * Handling condition for descending sort
         */
        if (!descending && arr[j] > arr[j+1] || descending && arr[j] < arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          swapped = true;
        }
      }
  
      /**
       * Optimisation: The above loop always runs O(n^2) time even if the array is sorted.
       * It can be optimized by stopping the algorithm if inner loop didn’t cause any swap
       * If no two elements swapped by inner loop, then break
       */
      if (swapped == false) {
        break;
      }
    }
  }
  
  static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(" arr[" + i +"] => " + arr[i]);
    }
  }
  
  public static void main(String[] args) {
    int[] arr = {2,3,48,95,65,100,78,53,47,49,36,50};
  
    System.out.println("---BEFORE SORT---");
    print(arr);
  
    System.out.println("\n---AFTER ASCENDING SORT---");
    sort(arr, false);
    print(arr);
  
    System.out.println("\n---AFTER DESCENDING SORT---");
    sort(arr, true);
    print(arr);
  }
  
}
