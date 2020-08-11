package com.ds.tree.practice;

import com.ds.tree.BinarySearchTree;
import com.ds.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (eg, if you have a tree with depth D, you’ll have D linked lists)
 *
 * Solution:
 * We can do a simple level by level traversal of the tree, with a slight modification of the breath- first traversal of the tree
 * In a usual breath first search traversal, we simply traverse the nodes without caring which level we are on In this case, it is critical to know the level We thus use a dummy node to indicate when we have finished one level and are starting on the next
 *
 */

public class BSTList {
  static ArrayList<LinkedList<Node>> findLevelLinks(Node root) {
    int level = 0;
    ArrayList<LinkedList<Node>> result = new ArrayList<>();
    
    LinkedList<Node> nodes = new LinkedList<>();
    
    nodes.add(root);
    
    result.add(level, nodes);
    
    while (true) {
    
      nodes = new LinkedList<>();
  
      for (int i = 0; i < result.get(level).size(); i++) {
        Node node = (Node) result.get(level).get(i);
        
        if (node != null) {
          if (node.left != null) nodes.add(node.left);
          if (node.right != null) nodes.add(node.left);
        }
      }
      if (nodes.size() > 0) {
        result.add(level + 1, nodes);
      } else {
        break;
      }
      level++;
    }
    return result;
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
    
    ArrayList<LinkedList<Node>> list = findLevelLinks(bst.root);
  
    for (int i = 0; i < list.size(); i++) {
      LinkedList<Node> listNode = list.get(i);
  
      for (int j = 0; j < listNode.size(); j++) {
        if (listNode.get(j) != null) {
          if (listNode.get(j).left == null && listNode.get(j).right == null) {
            System.out.printf(" ROOT => %d \n", listNode.get(j).value);
          } else if (listNode.get(j).left == null && listNode.get(j).right != null) {
            System.out.printf(" ROOT => %d | RIGHT => %d \n", listNode.get(j).value, listNode.get(j).right.value);
          } else if (listNode.get(j).left != null && listNode.get(j).right == null) {
            System.out.printf(" ROOT => %d | LEFT => %d \n", listNode.get(j).value, listNode.get(j).left.value);
          } else {
            System.out.printf(" ROOT => %d | LEFT => %d | RIGHT => %d \n", listNode.get(j).value, listNode.get(j).left.value, listNode.get(j).right.value);
          }
        }
        
      }
    }
  }
}
