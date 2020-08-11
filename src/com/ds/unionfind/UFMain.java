package com.ds.unionfind;

public class UFMain {
  public static void main(String[] args) {
    UFQuickFind qF = new UFQuickFind(10);
  
    // Test
    System.out.println("-- QUICK FIND APPROACH --- ");
    qF.union(5, 7);
    qF.union(1, 5);
    qF.union(3, 4);
    qF.union(4, 8);
    qF.union(3, 9);
  
    System.out.println("connected(5, 7) => " + qF.connected(3, 9));
    System.out.println("connected(1, 7) => " + qF.connected(1, 7));
    System.out.println("connected(0, 6) => " + qF.connected(0, 7));
  
    System.out.println("\n-- QUICK UNION APPROACH --- ");
    UFQuickUnion qU = new UFQuickUnion(10);
  
    qU.union(5, 7);
    qU.union(1, 5);
    qU.union(3, 4);
    qU.union(4, 8);
    qU.union(3, 9);
  
    System.out.println("connected(5, 7) => " + qU.connected(3, 9));
    System.out.println("connected(1, 7) => " + qU.connected(1, 7));
    System.out.println("connected(0, 6) => " + qU.connected(0, 7));
  }
}
