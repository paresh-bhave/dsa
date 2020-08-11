package com.ds.tree;

public class Node {
  public Node left, right;
  public int value;
  public Node parent;
  int count;
  
  public Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
    this.count = 0;
  }
}
