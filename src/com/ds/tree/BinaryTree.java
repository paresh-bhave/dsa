package com.ds.tree;

public class BinaryTree {
  public Node root;
  int depth = 0;
  
  public BinaryTree(int value) {
    root = new Node(value);
  }
  
  public Node create(int value) {
    return new Node(value);
  }
  
  public void add(Node start, Node newNode) {
    if (newNode.value > start.value) {
      if (start.right == null) {
        start.right = newNode;
      }
      add(start.right, newNode);
    }
  
    if (newNode.value < start.value) {
      if (start.left == null) {
        start.left = newNode;
      }
      add(start.left, newNode);
    }
  }
  
  public void find(int value, Node start) {
    if (start == null) {
      System.out.println("NODE IS NOT FOUND");
      return;
    }
    
    if (start.value == value) {
      System.out.println("NODE IS FOUND AT DEPTH => " + depth);
      depth = 0;
      return;
    }
  
    if (value > start.value) {
      depth++;
      find(value, start.right);
    }
    if (value < start.value) {
      depth++;
      find(value, start.left);
    }
  }
}
