package com.algo.sort;

/**
 * Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining element.
 *
 * A Binary Heap is a Complete Binary Tree where items are stored in a special order such that value in a parent node is greater(or smaller) than the values in its two children nodes. The former is called as max heap and the latter is called min heap. The heap can be represented by binary tree or array.
 *
 * Complexity: O(n log n)
 */

public class Heap {
  public static void buildHeap(int arr[], int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) {
      largest = left;
    }
    if (right < n && arr[right] > arr[largest]) {
      largest = right;
    }
    if (largest != i) {
      int temp = arr[i];
      arr[i] = arr[largest];
      arr[largest] = temp;
      buildHeap(arr, n, largest);
    }
  }
  
  public static void sort(int arr[]) {
    for (int i = arr.length / 2; i >= 0; i--) {
      buildHeap(arr, arr.length, i);
    }
    for (int j = arr.length - 1; j >= 0; j--) {
      // Move current root to end
      int temp = arr[0];
      arr[0] = arr[j];
      arr[j] = temp;
      buildHeap(arr, j, 0);
    }
  }
}
