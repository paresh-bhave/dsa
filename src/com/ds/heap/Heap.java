package com.ds.heap;

public class Heap {
  public int[] heap;
  public int size;
  public boolean isMinHeap;
  
  public Heap(int capacity, boolean isMinHeap) {
    this.heap = new int[capacity];
    this.isMinHeap = isMinHeap;
  }
  
  private boolean isFull() {
    return heap.length == size;
  }
  
  private int parent(int index) {
    return (index - 1) / 2;
  }
  
  private int leftChild(int index) {
    return 2 * index + 1;
  }
  
  private int rightChild(int index) {
    return 2 * index + 2;
  }

  private boolean isLeaf(int index) {
    return index >= size / 2 && index <= size;
  }
  
  private void swap(int source, int destination) {
    int tmp = heap[source];
    heap[source] = heap[destination];
    heap[destination] = tmp;
  }
  
  private void maxHeapify(int i) {
    if (isLeaf(i))
      return;
    
    if (heap[i] < heap[leftChild(i)] || heap[i] < heap[rightChild(i)]) {
      if (heap[leftChild(i)] > heap[rightChild(i)]) {
        swap(i, leftChild(i));
        maxHeapify(leftChild(i));
      } else {
        swap(i, rightChild(i));
        maxHeapify(rightChild(i));
      }
    }
  }
  
  private void minHepify(int i) {
    if (isLeaf(i))
      return;
    
    if (heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)]) {
      if (heap[leftChild(i)] < heap[rightChild(i)]) {
        swap(i, leftChild(i));
        minHepify(leftChild(i));
      } else {
        swap(i, rightChild(i));
        minHepify(rightChild(i));
      }
    }
  }
  
  private void fixAboveHeap(int i) {
    int newValue = heap[i];
    
    while (i > 0 &&
      (
        (isMinHeap && newValue < heap[parent(i)]) ||
        (!isMinHeap && newValue > heap[parent(i)])
      )
    ) {
      heap[i] = heap[parent(i)];
      i = parent(i);
    }
    heap[i] = newValue;
  }
  
  public void insert(int value) {
    if (isFull()) {
      System.out.println("Heap is full");
      return;
    }
    
    heap[size] = value;
    fixAboveHeap(size);
    size++;
  }
  
  public int extractMax() {
    int max = heap[0];
    heap[0] = heap[size-2];
    maxHeapify(0);
    return max;
  }
  
  public int extractMin() {
    int min = heap[0];
    heap[0] = heap[size-2];
    minHepify(0);
    return min;
  }
  
  public void print() {
    for (int i = 0; i < size / 2; i++) {
      System.out.print(" PARENT => " + heap[i]
        + " | LC => " + heap[2 * i + 1]
        + " | RC => " + heap[2 * i + 2]);
      System.out.println();
    }
  }
}
