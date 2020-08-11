package com.ds.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList DS implementation in java collections
 */

public class JavaInBuiltLinkedList {
  public static void main(String[] args) {
    LinkedList<Employee> employees = new LinkedList<>();
    
    employees.add(new Employee(1, "John"));
    employees.add(new Employee(2, "Jake"));
    employees.add(new Employee(3, "Jack"));
  
    Iterator<Employee> iterator = employees.iterator();
  
    System.out.println("-- LIST OF EMPLOYEES -- ");
    while (iterator.hasNext()) {
      Employee employee = iterator.next();
      System.out.println(" ID = " + employee.id + " | NAME = " + employee.name);
    }
  }
  
  /**
   * User defined class ref for LinkedList collections
   */
  static class Employee {
    int id;
    String name;
  
    Employee(int id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}
