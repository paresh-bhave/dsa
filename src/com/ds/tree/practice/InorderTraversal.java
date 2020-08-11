package com.ds.tree.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
  
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  
  List<Integer> list = new ArrayList<>();
  
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return list;
    
    inorderTraversal(root.left);
    list.add(root.val);
    inorderTraversal(root.right);
    
    return list;
  }
  
  public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) return list;
  
    list.add(root.val);
    preorderTraversal(root.left);
    preorderTraversal(root.right);
    
    return list;
  }
}
