package com.ds.tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * LinkedList DS without duplicates and in ordered format implementation in java collections
 */

public class JavaInBuiltTree {
  public static void main(String[] args) {
    TreeSet<String> hashSet = new TreeSet<>();
  
    hashSet.add("Marshall");
    hashSet.add("Alan");
    hashSet.add("Ted");
    hashSet.add("Charlie");
    hashSet.add("Barney");
    hashSet.add("Barney"); // no duplicate
    
    Iterator<String> iterator = hashSet.iterator();
    
    // prints sorted list
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}

