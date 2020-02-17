package com.ds.linear.queue;

public class QueueArray<T> {
  Object[] queue;
  int rear, front, size;
  
  public QueueArray(int s) {
    this.size = s;
    queue = new Object[s];
    rear = -1;
    front = -1;
  }
  
  public boolean isFull() {
    return rear == size - 1;
  }
  
  public boolean isEmpty() {
    return front == -1 || front > rear;
  }
  
  public void enqueue(Object item) {
    if (isFull()) {
      System.out.println("Queue is full");
      return;
    }
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
}
