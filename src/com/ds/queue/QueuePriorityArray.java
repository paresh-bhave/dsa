package com.ds.queue;

public class QueuePriorityArray {
  int[] queue;
  int index;
  
  QueuePriorityArray(int size) {
    queue = new int[size];
    index = 0;
  }
  
  public boolean isEmpty() {
    return index == 0;
  }
  
  public boolean isFull() {
    return index == queue.length;
  }
  
  public void insert(int item) {
    if (isFull()) {
      System.out.println("Queue is full");
      return;
    }
    queue[index] = item;
    index++;
  }
  
  public int remove() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return -1;
    }
    
    int maxIndex = 0;
  
    for (int i = 0; i < index; i++) {
      if (queue[i] > queue[maxIndex]) {
        maxIndex = i;
      }
    }
    int result = queue[maxIndex];
    index--;
    queue[maxIndex] = queue[index];
    return result;
  }
}
