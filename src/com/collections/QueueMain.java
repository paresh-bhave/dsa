package com.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Queue DS implementation in java collections using DynamicArray
 */

public class QueueMain {
  public static void main(String[] args) {
    System.out.println("--- BASIC QUEUE ---");
    Queue<String> queue = new LinkedList<>();
    queue.add("Bus");
    queue.add("Car");
    queue.add("Bike");
    queue.add("Truck");
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    System.out.println(queue.poll());
    
    System.out.println("--- PRIORITY QUEUE ---");
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(15);
    priorityQueue.add(11);
    priorityQueue.add(10);
    priorityQueue.add(14);
    System.out.println(priorityQueue.poll());
    System.out.println(priorityQueue.poll());
    System.out.println(priorityQueue.poll());
    System.out.println(priorityQueue.poll());
  
    System.out.println("--- PRIORITY QUEUE FOR USER DDEFINED CLASSES---");
    PriorityQueue<Employee> priorityQueueEmp = new PriorityQueue<>();
    priorityQueueEmp.add(new Employee(1, "Barney"));
    priorityQueueEmp.add(new Employee(3, "Marshal"));
    priorityQueueEmp.add(new Employee(2, "Ted"));
    priorityQueueEmp.add(new Employee(4, "Lily"));
    System.out.println(priorityQueueEmp.poll().name);
    System.out.println(priorityQueueEmp.poll().name);
    System.out.println(priorityQueueEmp.poll().name);
    System.out.println(priorityQueueEmp.poll().name);
  }
  
  /**
   * User defined class ref for LinkedList collections
   */
  static class Employee implements Comparable<Employee> {
    int id;
    String name;
    
    Employee(int id, String name) {
      this.id = id;
      this.name = name;
    }
  
    @Override
    public int compareTo(Employee o) {
      if (this.id == o.id) {
        return 0;
      } else if (this.id > o.id) {
        return 1;
      } else {
        return -1;
      }
    }
  }
}
