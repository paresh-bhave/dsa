package com.ds.tree.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderNaryTreeNoRecu {
  Stack<Node> stack = new Stack<>();
  List<Integer> list = new ArrayList<>();
  
  class Node {
    public int val;
    public List<Node> children;
    
    public Node() {}
    
    public Node(int _val) {
      val = _val;
    }
    
    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };
  
  public List<Integer> preorder(Node root) {
    List<Integer> list = new ArrayList<>();
    helper(root, list);
    return list;
  }
  
  public void helper(Node root, List<Integer> list) {
    if(root==null) return;
    list.add(root.val);
    if(root.children!=null)
      for(Node child : root.children) helper(child, list);
  }
}
