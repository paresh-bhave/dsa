package com.ds.queue;

import java.util.Arrays;

public class QueueDynamicArray<T> {
  Object[] queue;
  int rear, front, size;
  
  public QueueDynamicArray() {
    this.size = 3;
    queue = new Object[3];
    rear = -1;
    front = -1;
  }
  
  public boolean isEmpty() {
    return front == -1 || front > rear;
  }
  
  public void enqueue(Object item) {
    ensureCapacity(rear + 2);
    rear += 1;
    queue[rear] = item;
    if (front == -1) front = 0;
  }
  
  public T dequeue() {
    if(isEmpty()){
      System.out.println("queue is empty");
      return null;
    }
    T out=(T) queue[front];
    front += 1;
    return out;
  }
  
  private int getSize() {
    return queue.length;
  }
  
  private void ensureCapacity(int minSize) {
    int oldSize = getSize();
    if (minSize > oldSize) {
      int newSize = oldSize * 2;
      if (newSize < minSize) {
        newSize = minSize;
      }
      queue = Arrays.copyOf(queue, newSize);
    }
  }
}
