package com.ds.tree.practice;

import com.ds.tree.BinaryTree;
import com.ds.tree.Node;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes
 * Create an algorithm to decide if T2 is a subtree of T1
 *
 * Note that the problem here specifies that T1 has millions of nodes—this means that we should be careful of how much space we use Let’s say,
 * for example, T1 has 10 million nodes — this means that the data alone is about 40mb. We could create a string representing the inorder and
 * preorder traversals If T2’s preorder traversal is a substring of T1’s preorder traversal, and T2’s inorder traversal is a substring of T1’s
 * inorder traversal, then T2 is a sub- string of T1 We can check this using a suffix tree However, we may hit memory limitations
 * because suffix trees are extremely memory intensive If this become an issue, we can use an alternative approach
 *
 * Alternative Approach: The treeMatch procedure visits each node in the small tree at most once and is called no more than once per
 * node of the large tree Worst case runtime is at most O(n * m), where n and m are the sizes of trees T1 and T2,
 * respectively If k is the number of occurrences of T2’s root in T1, the worst case runtime can be characterized as O(n + k * m)
 */

public class SubTreeCheck {
  static boolean treeMatches(Node r1, Node r2) {
    if (r2 == null && r1 == null) return true; // nothing left in the subtree
    if (r1 == null || r2 == null) return false; // big tree empty & subtree still not found
    if (r1.value != r2.value) return false; // data doesn’t match
    return (treeMatches(r1.left, r2.left) && treeMatches(r1.right, r2.right));
  }
  
  static boolean isSubtree(Node r1, Node r2) {
    if (r1 == null) return false; // big tree empty & subtree still not found.
    if (r1.value == r2.value)
      if (treeMatches(r1, r2)) return true;
      
    return isSubtree(r1.left, r2) || isSubtree(r1.right, r2);
  }
  
  static boolean containsTree(Node t1, Node t2) {
    if (t2 == null) return true; // The empty tree is always a subtree
    else return isSubtree(t1, t2);
  }
  
  public static void main(String[] args) { }
}
