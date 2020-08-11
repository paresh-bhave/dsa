package com.ds.tree;

public class BFSTree {
  /* function to print level order traversal of tree*/
  static void printLevelOrder(Node root) {
    int h = height(root);
    for (int i=1; i<=h; i++)
      printGivenLevel(root, i);
  }
  
  /* Compute the "height" of a tree -- the number of
  nodes along the longest path from the root node
  down to the farthest leaf node.*/
  static int height(Node root) {
    if (root == null) {
      return 0;
    } else {
      /* compute  height of each subtree */
      int lheight = height(root.left);
      int rheight = height(root.right);
      
      /* use the larger one */
      if (lheight > rheight) {
        return(lheight+1);
      } else {
        return(rheight+1);
      }
    }
  }
  
  /* Print nodes at the given level */
  static void printGivenLevel (Node root, int level) {
    if (root == null) return;
    
    if (level == 1) {
      System.out.print(root.value + " ");
    } else if (level > 1) {
      printGivenLevel(root.left, level-1);
      printGivenLevel(root.right, level-1);
    }
  }
  
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(1);
  
    tree.add(tree.root, tree.create(3));
    tree.add(tree.root, tree.create(2));
    tree.add(tree.root, tree.create(0));
    tree.add(tree.root, tree.create(4));
    tree.add(tree.root, tree.create(5));
    
    printLevelOrder(tree.root);
  }
}
