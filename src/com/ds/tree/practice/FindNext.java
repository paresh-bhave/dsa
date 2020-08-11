package com.ds.tree.practice;

import com.ds.tree.BinarySearchTree;
import com.ds.tree.Node;

/**
 * Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given node in a binary search tree
 * where each node has a link to its parent
 *
 * We approach this problem by thinking very, very carefully about what happens on an in- order traversal On an in-order traversal,
 *  we visit X left, then X, then X right
 *
 * So, if we want to find X successor(), we do the following:
 * 1 If X has a right child, then the successor must be on the right side of X (because of the order in which we visit nodes) Specifically,
 *  the left-most child must be the first node visited in that subtree
 * 2 Else, we go to X’s parent (call it P)
 *  2.a If X was a left child (Pleft = X), then P is the successor of X
 *  2.b If X was a right child (Pright = X), then we have fully visited P, so we call successor(P)
 */

public class FindNext {
  public static Node inorderSucc(Node node) {
    if (node != null) {
      Node parent;
      
      // Found right children -> return 1st inorder node on right
      if (node.parent == null || node.right != null) {
        parent = leftMostChild(node.right);
      } else {
      
      // Go up until we’re on left instead of right (case 2b)
        while ((parent = node.parent) != null) {
          if (parent.left == node) {
            break;
          }
          node = parent;
        }
      }
      return parent;
    }
    return null;
  }
  
  public static Node leftMostChild(Node node) {
    if (node == null) return null;
    while (node.left != null) node = node.left;
    return node;
  }
  
  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
  
    bst.put(6);
    bst.put(7);
    bst.put(10);
    bst.put(11);
    bst.put(4);
    bst.put(3);
    bst.put(2);
  
    System.out.println("BST ==> ");
    bst.traverse(bst.root);
    System.out.println();
  
    Node node = bst.get(bst.root, 3);
    System.out.println("Inorder Successor of 3 ==> " + inorderSucc(node).value);
  }
}
