package com.ds.tree;

import java.util.List;

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
  
    System.out.println("--- BINARY TREE FIND ELEMENT ---");
    binaryTree.find(12, binaryTree.root);
    binaryTree.find(100, binaryTree.root);
    binaryTree.find(4, binaryTree.root);
    binaryTree.find(63, binaryTree.root);
  
    System.out.println("");
    
    BinarySearchTree bst = new BinarySearchTree();
    
    bst.put(10);
    bst.put(15);
    bst.put(21);
    bst.put(37);
    bst.put(5);
    bst.put(1);
    bst.put(68);
    bst.put(72);
    bst.put(99);
    bst.put(85);
  
    System.out.println("BST MIN ==> " + bst.getMin(bst.root));
    System.out.println("BST MAX ==> " + bst.getMax(bst.root));
    System.out.println("");
    
//    Node node = bst.get(bst.root, 68);
//    System.out.println("BST SUB-TREE COUNT FOR 68 ==> " + node.count);
//    if (node.left != null) {
//      System.out.println("BST LEFT CHILD VALUE 68 ==> " + node.left.value);
//    }
//    if (node.right != null) {
//      System.out.println("BST RIGHT CHILD VALUE 68 ==> " + node.right.value);
//    }
//
//    System.out.println("");
//    System.out.println("BST INORDER TRAVERSAL => ");
//    bst.traverse(bst.root);
//
//    System.out.println("");
//    System.out.println("BST AFTER DELETING MIN ==> ");
//    bst.deleteMin();
//    bst.traverse(bst.root);
//
//    System.out.println("");
//    System.out.println("BST AFTER DELETING MAX ==> ");
//    bst.deleteMax();
//    bst.traverse(bst.root);
//
//    System.out.println("");
//    System.out.println("BST AFTER DELETING KEY 68 ==> ");
//    bst.delete(68);
//    bst.printInorder(bst.root);
  
    List<Integer> list = bst.inorderTraversal(bst.root);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
