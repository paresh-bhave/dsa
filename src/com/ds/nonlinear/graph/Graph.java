package com.ds.nonlinear.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
  int size;
  AdjecancyList list[];
  
  public Graph(int size) {
    this.size = size;
    list = new AdjecancyList[this.size];
  
    for (int i = 0; i < this.size; i++) {
      list[i] = new AdjecancyList();
      list[i].head = null;
    }
  }
  
  public void add(int src, int dest) {
    Node node = new Node(dest, null);
    node.next = list[src].head;
    list[src].head = node;
  }
  
  public void breadthFirstSearch(int vertex) {
    boolean visited[] = new boolean[size];
    for (int i = 0; i < size; i++) {
      visited[i] = false;
    }
  
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(vertex);
    
    while (!queue.isEmpty()) {
      int queueIndex = queue.poll();
      System.out.println("VISITED NODE ==> " + queueIndex);
      visited[queueIndex] = true;
      Node head = list[queueIndex].head;
      
      while (head != null) {
        if (!visited[head.value]) {
          queue.add(head.value);
          visited[head.value] = true;
        } else {
          head = head.next;
        }
      }
    }
  }
  
  public void depthFirstSearch(int vertex) {
    boolean visited[] = new boolean[size];
    for (int i = 0; i < size; i++) {
      visited[i] = false;
    }
    
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(vertex);
    while (!stack.isEmpty()) {
      int stackIndex = stack.pop();
      stack.push(stackIndex);
      visited[stackIndex] = true;
      Node head = list[stackIndex].head;
      
      boolean isDone = true;
      while (head != null) {
        if (!visited[head.value]) {
          stack.push(head.value);
          visited[head.value] = true;
          isDone = false;
          break;
        } else {
          head = head.next;
        }
      }
      if (isDone) {
        int out = stack.pop();
        System.out.println("VISITED NODE ==> " + out);
      }
    }
  }
}
