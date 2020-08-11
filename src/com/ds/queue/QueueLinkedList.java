package com.ds.queue;

import com.ds.linkedlist.DoublyNode;

public class QueueLinkedList<T> {
  DoublyNode rear;
  DoublyNode front;
  
  public QueueLinkedList() {
    rear = null;
    front = null;
  }
  
  public void enqueue(Object value) {
    DoublyNode newNode = new DoublyNode(value, null, null);
    if (rear == null || front == null) {
      rear = newNode;
      front = newNode;
    } else {
      newNode.next = null;
      newNode.previous = rear;
      rear.next = newNode;
      rear = newNode;
    }
  }
  
  public T dequeue() {
    if (rear == null || front == null) {
      System.out.println("queue is emplty");
      return null;
    }
    T value = (T) front.value;
    front = front.next;
    if (front != null) front.previous = null;
    return value;
  }
}
