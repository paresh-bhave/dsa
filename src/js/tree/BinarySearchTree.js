/**
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:
 * - The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * - The right subtree of a node contains only nodes with keys greater than the node’s key.
 * - The left and right subtree each must also be a binary search tree.
 *
 */

class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
    this.parent= null;
    this.count = null;
  }
}

class Tree {
  constructor() {
    this.root = null;
  }

  size(node) {
    if (node == null) return 0;
    return node.count;
  }

  /* Insertion into BST*/
  insertUtil(node, value) {
    if (node === null) {
      return new Node(value);
    }
    if (value < node.value) {
      node.left = this.insertUtil(node.left, value);
      node.left.parent = node;
    } else if (value > node.value) {
      node.right = this.insertUtil(node.right, value);
      node.right.parent = node;
    } else {
      node.value = value;
    }
    node.count = this.size(node.left) + this.size(node.right) + 1;
    return node;
  }

  insert(value) {
    this.root = this.insertUtil(this.root, value);
  }

  /*Deletion from BST*/
  deleteUtil(node, value) {
    if (node === null) {
      console.log(`No such node found to delete for value[${value}]`);
      return null;
    };

    if (value < node.value) {
      node.left = this.deleteUtil(node.left, value);
    } else if (value > node.value) {
      node.right = this.deleteUtil(node.right, value);
    } else {
      if (node.left === null) {
        return node.right;
      } else if (node.right === null) {
        return node.left;
      }

      node.value = this.getMin(node.right);
      node.right = this.deleteUtil(node.right, node.value);
    }
    node.count = this.size(node.left) + this.size(node.right) + 1;
    return node;
  }

  delete(value) {
    this.root = this.deleteUtil(this.root, value);
  }

  deleteMinUtil(node) {
    if (node.left === null) return node.right;
    node.left = this.deleteMinUtil(node.left);
    node.count = 1 + this.size(node.left) + this.size(node.right);
    return node;
  }

  deleteMin() {
    this.root = this.deleteMinUtil(this.root);
  }

  deleteMaxUtil(node) {
    if (node.right === null) return node.left;
    node.right = this.deleteMaxUtil(node.right);
    node.count = 1 + this.size(node.right) + this.size(node.left);
    return node;
  }

  deleteMax() {
    this.root = this.deleteMaxUtil(this.root);
  }

  /*Get utils*/
  getUtil(node, value) {
    if (node === null) {
      console.log(`No such node found for value[${value}]`);
      return null;
    } else if (value < node.value) {
      return this.getUtil(node.left, value);
    } else if(value > node.value) {
      return this.getUtil(node.right, value);
    } else {
      return node;
    }
  }

  get(value) {
    return this.getUtil(this.root, value);
  }

  getMinUtil(node) {
    let min = node.value;
    while (node.left !== null) {
      min = node.left.value;
      node = node.left;
    }
    return min;
  }

  getMin() { return this.getMinUtil(this.root) }

  getMaxUtil(node) {
    let max = node.value;
    while (node.right != null) {
      max = node.right.value;
      node = node.right;
    }
    return max;
  }

  getMax() { return this.getMaxUtil(this.root) }
}

module.exports = { Node, Tree };
