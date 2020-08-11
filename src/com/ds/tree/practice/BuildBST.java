package com.ds.tree.practice;

import com.ds.tree.Node;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height
 *
 * Solution:
 * We will try to create a binary tree such that for each node, the number of nodes in the left subtree and the right subtree are equal, if possible
 *
 * Algorithm:
 * 1. Insert into the tree the middle element of the array
 * 2. Insert (into the left subtree) the left subarray elements
 * 3. Insert (into the right subtree) the right subarray elements
 * 4. Recurse
 */

public class BuildBST {
  public static Node addToTree(int arr[], int start, int end) {
    if (end < start) {
      return null;
    }
    int mid = (start + end) / 2;
    Node n = new Node(arr[mid]);
    n.left = addToTree(arr, start, mid - 1);
    n.right = addToTree(arr, mid + 1, end);
    return n;
  }
  
  public static Node createMinimalBST(int array[]) {
    return addToTree(array, 0, array.length - 1);
  }
  
  static void print(Node root) {
    if (root == null) return;
    
    print(root.left);
    print(root.right);
    System.out.println(root.value);
  }
  
  public static void main(String[] args) {
    int[] tree = {4, 5, 6, 1, 2, 3};
  
    print(createMinimalBST(tree));
  }
}
