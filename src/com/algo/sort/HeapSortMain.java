package com.algo.sort;

/**
 * Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection sort where we first find the maximum element and place the maximum element at the end. We repeat the same process for remaining element.
 *
 * A Binary Heap is a Complete Binary Tree where items are stored in a special order such that value in a parent node is greater(or smaller) than the values in its two children nodes. The former is called as max heap and the latter is called min heap. The heap can be represented by binary tree or array.
 */

public class HeapSortMain {
  static void heap(int arr[], int n, int i) {
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
      
      heap(arr, n, largest);
    }
  }
  
  static void sort(int arr[]) {
    for (int i = arr.length / 2; i >= 0; i--) {
      heap(arr, arr.length, i);
    }
    for (int j = arr.length - 1; j >= 0; j--) {
      // Move current root to end
      int temp = arr[0];
      arr[0] = arr[j];
      arr[j] = temp;
  
      heap(arr, j, 0);
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
    
    System.out.println("\n---AFTER SORT---");
    sort(arr);
    print(arr);
  }
}
