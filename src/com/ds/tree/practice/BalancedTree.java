package com.ds.tree.practice;

import com.ds.tree.BinaryTree;
import com.ds.tree.Node;

/**
 * Implement a function to check if a tree is balanced For the purposes of this question,
 * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one
 *
 * Solution:
 * The idea is very simple: the difference of min depth and max depth should not exceed 1,
 * since the difference of the min and the max depth is the maximum distance difference pos- sible in the tree
 */

public class BalancedTree {
  static int maxDepth(Node root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
  
  static int minDepth(Node root) {
    if (root == null) return 0;
    return 1 + Math.min(maxDepth(root.left), maxDepth(root.right));
  }
  
  public static boolean isBalanced(Node root) {
    return (maxDepth(root) - minDepth(root) <= 1);
  }
  
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(1);
    
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
  
    System.out.println(isBalanced(tree.root));
  }
}
