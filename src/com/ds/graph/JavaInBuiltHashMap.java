package com.ds.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * HashTable DS implementation in java collections
 */

public class JavaInBuiltHashMap {
  public static void main(String[] args) {
    HashMap<String, User> userMap = new HashMap<>();
    
    userMap.put("Admin", new User(1, "John"));
    userMap.put("Customer", new User(2, "Jane"));
    userMap.put("Sales", new User(3, "Josh"));
    
    for (Map.Entry user: userMap.entrySet()) {
      User user1 = ((User) user.getValue());
      user1.display();
    }
  }
  
  static class User {
    int id;
    String name;
    
    User(int id, String name) {
      this.id = id;
      this.name = name;
    }
    
    void display() {
      System.out.println("ID: " + id + " | " + " NAME: " + name);
    }
  }
}
