package com.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
  
  public Node root;
  
  public List<Integer> list = new ArrayList<>();
  
  public BinarySearchTree() {
    root = null;
  }
  
  private int size(Node node) {
    if (node == null) return 0;
    return node.count;
  }
  
  private Node put(Node node, int value) {
    if (node == null) {
      return new Node(value);
    }
  
    if (value < node.value) {
      node.left = put(node.left, value);
      node.left.parent = node;
    } else if (value > node.value) {
      node.right = put(node.right, value);
      node.right.parent = node;
    } else {
      node.value = value;
    }
    node.count = size(node.left) + size(node.right) + 1;
    return node;
  }
  
  private Node deleteMin(Node node) {
    if (node.left == null) return node.right;
    node.left = deleteMin(node.left);
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }
  
  private Node deleteMax(Node node) {
    if (node.right == null) return node.left;
    node.right = deleteMax(node.right);
    node.count = 1 + size(node.right) + size(node.left);
    return node;
  }
  
  private Node delete(Node node, int value) {
    if (node == null) return null;
    
    if (value < node.value) {
      node.left = delete(node.left, value);
    } else if (value > node.value) {
      node.right = delete(node.right, value);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      }
  
      node.value = getMin(node.right);
      node.right = delete(node.right, node.value);
    }
    node.count = size(node.left) + size(node.right) + 1;
    return node;
  }
  
  public void put(int value) {
    root = put(root, value);
  }
  
  public void delete(int value) {
    root = delete(root, value);
  }
  
  public void deleteMin() {
    root = deleteMin(root);
  }
  
  public void deleteMax() {
    root = deleteMax(root);
  }
  
  public Node get(Node root, int value) {
    Node node = root;
    if (node.value == value) {
      return node;
    } else if (value < node.value) {
      node = node.left;
      get(node, value);
    } else {
      node = node.right;
      get(node, value);
    }
    return node;
  }
  
  public int getMin(Node root) {
    int min = root.value;
    while (root.left != null) {
      min = root.left.value;
      root = root.left;
    }
    return min;
  }
  
  public int getMax(Node root) {
    int max = root.value;
    while (root.right != null) {
      max = root.right.value;
      root = root.right;
    }
    return max;
  }
  
  public void traverse(Node root) {
    if (root != null) {
      traverse(root.left);
      System.out.println(("VALUE => " + root.value + " | SUB-TREE COUNT => " + root.count));
      traverse(root.right);
    }
  }
  
  void printPostorder(Node node) {
    if (node == null)
      return;
    
    printPostorder(node.left);
    printPostorder(node.right);
    System.out.print(node.value + " ");
  }
  
  void printInorder(Node node) {
    if (node == null)
      return;
    
    printInorder(node.left);
    System.out.print(node.value + " ");
    printInorder(node.right);
  }
  
  void printPreorder(Node node) {
    if (node == null)
      return;
    
    System.out.print(node.value + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }
  
  /**
   * Getting list of integers
   */
  
  public List<Integer> inorderTraversal(Node root) {
    if (root == null) return list;
    
    inorderTraversal(root.left);
    list.add(root.value);
    inorderTraversal(root.right);
    
    return list;
  }
}
