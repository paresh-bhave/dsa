package com.ds.tree.practice;

import com.ds.tree.Node;


/**
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree Avoid storing additional nodes in a
 * data structure NOTE: This is not necessarily a binary search tree
 *
 * Solution:
 * If this were a binary search tree, we could do a modified find on the two nodes and see where the paths diverge Unfortunately, this is not a binary search tree, so we much try other approaches
 *
 * Attempt #1:
 * If each node has a link to its parent, we could trace p and q’s paths up until they intersect
 *
 * Attempt #2:
 * Alternatively, you could follow a chain in which p and q are on the same side That is, if p and q are both on the left of the node,
 * branch left to look for the common ancestor When p and q are no longer on the same side, you must have found the first common ancestor
 *
 * Attempt #3:
 * For any node r, we know the following:
 * 1 If p is on one side and q is on the other, r is the first common ancestor
 * 2 Else, the first common ancestor is on the left or the right side
 *
 * So, we can create a simple recursive algorithm called search that calls search(left side) and search(right side) looking at how many
 * nodes (p or q) are placed from the left side and from the right side of the current node If there are two nodes on one of the sides, then we have
 * to check if the child node on this side is p or q (because in this case the current node is the common ancestor)
 * If the child node is neither p nor q, we should continue to search further (starting from the child)
 * If one of the searched nodes (p or q) is located on the right side of the current node, then the other node is located on the other side
 * Thus the current node is the common ancestor
 */

public class CommonAncestor {
  static int TWO_NODES_FOUND = 2;
  static int ONE_NODE_FOUND = 1;
  static int NO_NODES_FOUND = 0;
  
  // Checks how many “special” nodes are located under this root
  int covers(Node root, Node p, Node q) {
    int covered = NO_NODES_FOUND;
    if (root == null) return covered;
    if (root == p || root == q) covered += 1;
    covered += covers(root.left, p, q);
    if (covered == TWO_NODES_FOUND) // Found p and q
      return covered;
    return covered + covers(root.right, p, q);
  }
  
  Node commonAncestor(Node root, Node p, Node q) {
    if (q == p && (root.left == q || root.right == q)) return root;
    
    int nodesFromLeft = covers(root.left, p, q); // Check left side
    if (nodesFromLeft == TWO_NODES_FOUND) {
      if (root.left == p || root.left == q) return root.left;
      else return commonAncestor(root.left, p, q);
    } else if (nodesFromLeft == ONE_NODE_FOUND) {
      if (root == p) return p;
      else if (root == q) return q;
    }
    
    int nodesFromRight = covers(root.right, p, q); // Check right side
    if (nodesFromRight == TWO_NODES_FOUND) {
      if (root.right == p || root.right == q) return root.right;
      else return commonAncestor(root.right, p, q);
    } else if (nodesFromRight == ONE_NODE_FOUND) {
      if (root == p) return p;
      else if (root == q) return q;
    }
    
    if (nodesFromLeft == ONE_NODE_FOUND && nodesFromRight == ONE_NODE_FOUND) return root;
    else return null;
  }
}
