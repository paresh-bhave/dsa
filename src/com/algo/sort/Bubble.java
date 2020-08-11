package com.algo.sort;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 *
 * Time Complexity: O(n^2)
 */

public class Bubble {
  static void sort(int[] arr, boolean descending) {
    boolean swapped;
    for (int i = 0; i < arr.length - 1; i++) {
      swapped = false;
      for (int j = 0; j < ((arr.length - i) - 1); j++) {
        if (!descending && arr[j] > arr[j+1] || descending && arr[j] < arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
          swapped = true;
        }
      }
      if (swapped == false) {
        break;
      }
    }
  }
}
