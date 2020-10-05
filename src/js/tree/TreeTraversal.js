/**
 * There are three ways to traverse the binary tree. Inorder, preorder and Postorder.
 * This traversing can also be used for Depth First Search of a tree as we traverse through depths.
 *
 * Until all nodes are traversed, follow 3 steps for each traversal type.
 *
 * A. In Order:
 *   1. Recursively traverse left subtree.
 *   2. Visit root node.
 *   3. Recursively traverse right subtree.
 *
 * B. Pre Order:
 *   1. Visit root node.
 *   2. Recursively traverse left subtree.
 *   3. Recursively traverse right subtree.
 *
 * C. Post Order:
 *   1. Recursively traverse left subtree.
 *   2. Recursively traverse right subtree.
 *   3. Visit root node.
 */

function traverseInOrder(root) {
  if (root !== null) {
    traverseInOrder(root.left);
    console.log('Root visisted => ', root.value);
    traverseInOrder(root.right);
  }
}

function traversePreOrder(root) {
  if (root !== null) {
    console.log('Root visisted => ', root.value);
    traverseInOrder(root.left);
    traverseInOrder(root.right)
  }
}

function traversePostOrder(root) {
  if (root !== null) {
    traverseInOrder(root.left);
    traverseInOrder(root.right)
    console.log('Root visisted => ', root.value);
  }
}

module.exports = {
  traverseInOrder,
  traversePreOrder,
  traversePostOrder
}
