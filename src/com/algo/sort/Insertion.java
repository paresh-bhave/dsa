package com.algo.sort;

/**
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 *
 * Complexity: O(n^2)
 */

public class Insertion {
  public static void sort(int[] arr) {
    int lastSortedElement, j;
    for (int i = 1; i < arr.length; i++) {
      lastSortedElement = arr[i];
      j = i - 1;
      while (j >= 0 && arr[j] > lastSortedElement) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = lastSortedElement;
    }
  }
}
