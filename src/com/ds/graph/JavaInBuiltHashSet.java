package com.ds.graph;

import java.util.HashSet;
import java.util.Iterator;

/**
 * LinkedList DS without duplicates  implementation in java collections
 */

public class JavaInBuiltHashSet {
  public static void main(String[] args) {
    HashSet<String> hashSet = new HashSet<>();
  
    hashSet.add("Marshall");
    hashSet.add("Alan");
    hashSet.add("Ted");
    hashSet.add("Charlie");
    hashSet.add("Barney");
    hashSet.add("Barney"); // no duplicate
    
  
    Iterator<String> iterator = hashSet.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
