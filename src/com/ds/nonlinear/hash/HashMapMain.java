package com.ds.nonlinear.hash;

public class HashMapMain {
  public static void main(String[] args) {
    HashTable<String> hashTable = new HashTable<String>(5);
    
    hashTable.put(1, "Barney");
    hashTable.put(2, "Ted");
    hashTable.put(3, "Marshall");
    hashTable.put(4, "Robin");
    hashTable.put(5, "Lily");
    hashTable.put(326783, "Lily");
  
    System.out.println(hashTable.get(4));
    System.out.println(hashTable.get(2));
    System.out.println(hashTable.get(1));
  }
}
