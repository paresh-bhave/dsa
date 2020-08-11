package com.ds.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * DynamicArray DS implementation in java collections
 */

public class JavaInBuiltArrayList {
  public static void main(String[] args) {
    ArrayList<String> characters = new ArrayList<>();
    
    characters.add("Barney");
    characters.add("Ted");
    characters.add("Marshall");
    characters.add("Lily");
    characters.add("Robin");
  
    System.out.println("---HIMYM CHARACTERS BEFORE SORT---");
    print(characters);
  
    // Sorting ArrayList of strings or numbers
    System.out.println("\n---HIMYM CHARACTERS AFTER SORT---");
    Collections.sort(characters);
    print(characters);
    
    ArrayList<Student> students = new ArrayList<>();
    students.add(new Student(1, "John"));
    students.add(new Student(2, "Jane"));
    students.add(new Student(3, "Jack"));
    students.add(new Student(4, "Jake"));
  
    System.out.println("\n---LIST OF ALL STUDENTS BEFORE SORT---");
    printS(students);
    
    Collections.sort(students);
    System.out.println("\n---LIST OF ALL STUDENTS AFTER SORT---");
    printS(students);
  }
  
  static void print(ArrayList<String> list) {
    for (String item: list) {
      System.out.println(item);
    }
  }
  
  static void printS(ArrayList<Student> list) {
    for (Student student: list) {
      System.out.println(" ID = " + student.id + " | NAME = " + student.name);
    }
  }
  
  /**
   * User defined class ref for ArrayList collections
   */
  static class Student implements Comparable<Student> {
    int id;
    String name;
    
    Student(int id, String name) {
      this.id = id;
      this.name = name;
    }
  
    @Override
    public int compareTo(Student o) {
      return o.id - this.id;
    }
  }
}
