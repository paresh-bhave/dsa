/**
 * A tree whose elements have at most 2 children is called a binary tree.
 * Since each element in a binary tree can have only 2 children,
 * we typically name them the left and right child.
 *
 */

class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
    this.count = null;
  }
}

class Tree {
  constructor() {
    this.root = null;
    this.depth = 0;
  }

  // Kind of private
  insertUtil(node, newNode) {
    let queue = [];
    queue.push(node);

    while(queue.length > 0) {
      node = queue.pop();

      if (node.left === null) {
        node.left = newNode;
        break;
      } else {
        queue.push(node.left);
      }

      if (node.right === null) {
        node.right = newNode;
        break;
      } else {
        queue.push(node.right);
      }
    }
  }

  insert(element) {
    let newNode = new Node(element);
    if (this.root === null) {
      this.root = newNode;
    } else {
      this.insertUtil(this.root, newNode);
    }
  }

  // Kind of private implementation
  searchUtil(node, value) {
    if (node === null) return null;

    /* If node found, return */
    if (node.value === value) return node;

    /* Then recur on left subtree */
    let foundLeft = this.searchUtil(node.left, value, this.depth++);
    if(foundLeft) return foundLeft;

    this.depth = 0;

    /* Node is not found in left, so recur on right subtree */
    let foundRight = this.searchUtil(node.right, value, this.depth++);
    return foundRight;
  }

  search(value) {
    const search = this.searchUtil(this.root, value);
    if (search !== null) {
      console.log(`\nNode for [${value}] found at level => `, this.depth);
    } else {
      console.log(`\nNode for [${value}] not found => `);
    }
    return search;
  }
}

module.exports = { Node, Tree };
