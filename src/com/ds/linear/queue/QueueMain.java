package com.ds.linear.queue;

public class QueueMain {
  public static void main(String[] args) {
    QueueArray<Integer> queueArray = new QueueArray<Integer>(5);
    queueArray.enqueue(10);
    queueArray.enqueue(5);
    queueArray.enqueue(6);
    System.out.println("De-queued item from QueueArray  ==> " + queueArray.dequeue());
    System.out.println("De-queued item from QueueArray  ==> " + queueArray.dequeue());
    System.out.println("De-queued item from QueueArray  ==> " + queueArray.dequeue());
  
    System.out.println("---");
    
    QueueDynamicArray<String> queueDynamicArray = new QueueDynamicArray<String>();
    queueDynamicArray.enqueue("Barney");
    queueDynamicArray.enqueue("Ted");
    queueDynamicArray.enqueue("Marshall");
    queueDynamicArray.enqueue("Lily");
    queueDynamicArray.enqueue("Robin");
    System.out.println("De-queued Item from QueueDynamicArray ==> " + queueDynamicArray.dequeue());
    System.out.println("De-queued Item from QueueDynamicArray ==> " + queueDynamicArray.dequeue());
    System.out.println("De-queued Item from QueueDynamicArray ==> " + queueDynamicArray.dequeue());
    System.out.println("De-queued Item from QueueDynamicArray ==> " + queueDynamicArray.dequeue());
    System.out.println("De-queued Item from QueueDynamicArray ==> " + queueDynamicArray.dequeue());
  
    System.out.println("---");
    
    QueueLinkedList<Float> queueLinkedList = new QueueLinkedList<Float>();
    queueLinkedList.enqueue(10);
    queueLinkedList.enqueue(5);
    queueLinkedList.enqueue(6);
    System.out.println("De-queued item from queueLinkedList  ==> " + queueLinkedList.dequeue());
    System.out.println("De-queued item from queueLinkedList  ==> " + queueLinkedList.dequeue());
    System.out.println("De-queued item from queueLinkedList  ==> " + queueLinkedList.dequeue());
  }
}
