package com.algo.sort;

/**
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
 *
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 * Pick median as pivot.
 * The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time.
 *
 *
 * Complexity: O(n Log n)
 */

public class Quick {
  
  static int partition(int arr[], int low, int high) {
    int pivot = arr[high],
        i = (low - 1);
  
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
    
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
  }
  
  static void sort(int arr[], int low, int high) {
    if (low < high) {
      int partition = partition(arr, low, high);
      sort(arr, low, partition - 1);
      sort(arr, partition + 1, high);
    }
  }
}
