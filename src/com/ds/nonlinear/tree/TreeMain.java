package com.ds.nonlinear.tree;

public class TreeMain {
  public static void main(String[] args) {
    /**
     * Root value
     */
    BinaryTree binaryTree = new BinaryTree(150);
    
    binaryTree.add(binaryTree.root, binaryTree.create(10));
    binaryTree.add(binaryTree.root, binaryTree.create(12));
    binaryTree.add(binaryTree.root, binaryTree.create(45));
    binaryTree.add(binaryTree.root, binaryTree.create(64));
    binaryTree.add(binaryTree.root, binaryTree.create(69));
    binaryTree.add(binaryTree.root, binaryTree.create(38));
    binaryTree.add(binaryTree.root, binaryTree.create(55));
    binaryTree.add(binaryTree.root, binaryTree.create(100));
    binaryTree.add(binaryTree.root, binaryTree.create(4));
    binaryTree.add(binaryTree.root, binaryTree.create(18));
    binaryTree.add(binaryTree.root, binaryTree.create(22));
    binaryTree.add(binaryTree.root, binaryTree.create(23));
  
    System.out.println("--- FIND ELEMENT ---");
    binaryTree.find(12, binaryTree.root);
    binaryTree.find(100, binaryTree.root);
    binaryTree.find(4, binaryTree.root);
    binaryTree.find(63, binaryTree.root);
  }
}
