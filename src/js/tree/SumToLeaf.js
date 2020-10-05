/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers % 1003.
 *
 * Example:
 *    1
 *   / \
 *  2   3
 *
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 *
 * Source: https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
 */

function sumToLeaf(root) {
  let result = 0;
  const preOrderTraverse = (node, currentNumber) => {
    // if (node === null) return null;

    if (!node.left && !node.right) {
      result = result + currentNumber;
      return;
    }

    if (node.left)
      preOrderTraverse(node.left, ((currentNumber * 10 + node.left.value) % 1003));

    if (node.right)
      preOrderTraverse(node.right, ((currentNumber * 10 + node.right.value) % 1003));
  }
  preOrderTraverse(root, root.value);
  console.log(result % 1003);
  // return Math.round(result);
}

const BT = require('./BinaryTree');
const tree1 = new BT.Tree();

tree1.insert(5);
tree1.insert(1);
tree1.insert(-1);
tree1.insert(2);
tree1.insert(-1);
tree1.insert(-1);
//
// tree1.insert(1);
// tree1.insert(2);
// tree1.insert(3);
//
//
const {
  BFS,
  DFSInOrder,
  DFSPreOrder,
  DFSPostOrder
} = require('./TreeSearch');

// console.log("\n-- BT PRE-ORDER TRAVERSE --");
// DFSPreOrder(tree1.root);

console.log(sumToLeaf(tree1.root));
