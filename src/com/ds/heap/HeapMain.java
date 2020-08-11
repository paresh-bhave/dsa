package com.ds.heap;

import java.util.Arrays;

public class HeapMain {
  public static void main(String[] args) {
    Heap minHeap = new Heap(7, true);
  
    minHeap.insert(72);
    minHeap.insert(63);
    minHeap.insert(54);
    minHeap.insert(36);
    minHeap.insert(27);
    minHeap.insert(45);
    minHeap.insert(18);
    minHeap.insert(9);
  
    System.out.println("MIN HEAP ==> ");
    minHeap.print();
    System.out.println("EXTRACT MIN ==> " + minHeap.extractMin());
    System.out.println("\nMIN HEAP AFTER EXTRACTING MIN ==> ");
    minHeap.print();
    System.out.println("");
  
  
    Heap maxHeap = new Heap(7, false);
  
    maxHeap.insert(9);
    maxHeap.insert(18);
    maxHeap.insert(27);
    maxHeap.insert(36);
    maxHeap.insert(45);
    maxHeap.insert(54);
    maxHeap.insert(63);
    maxHeap.insert(72);
  
    System.out.println("MAX HEAP ==> ");
    maxHeap.print();
    System.out.println("EXTRACT MAX ==> " + maxHeap.extractMax());
    System.out.println("\nMAX HEAP AFTER EXTRACTING MAX ==> ");
    maxHeap.print();
  }
}
