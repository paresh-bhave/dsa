package com.ds.tree;

public class DFSTree {
  static void inOrder(Node root) {
    if (root == null) return;
  
    inOrder(root.left);
    System.out.print(root.value + " ");
    inOrder(root.right);
  }
  
  static void preOrder(Node root) {
    if (root == null) return;
  
    System.out.print(root.value + " ");
    preOrder(root.left);
    preOrder(root.right);
  }
  
  static void postOrder(Node root) {
    if (root == null) return;
    
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.value + " ");
  }
  
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(1);
    
    tree.add(tree.root, tree.create(3));
    tree.add(tree.root, tree.create(2));
    tree.add(tree.root, tree.create(0));
    tree.add(tree.root, tree.create(4));
    tree.add(tree.root, tree.create(5));
    
    inOrder(tree.root);
    System.out.println();
    preOrder(tree.root);
    System.out.println();
    postOrder(tree.root);
  }
  
}
