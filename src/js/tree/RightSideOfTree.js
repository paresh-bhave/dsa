/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Source: https://leetcode.com/problems/binary-tree-right-side-view/submissions/
 *
 * Tag: #Google
 */

function rightSideView(root) {
  let result = [], maxHeight = 0;

  if (!root) return result;

  result.push(root.value)

  const traverse = (node, height) => {
    if (!node) return;

    if (height > maxHeight) {
      result.push(node.value);
      maxHeight = height;
    }

    traverse(node.right, height + 1);
    traverse(node.left, height + 1);
  }

  traverse(root, 0);
  return result;
}

const BT = require('./BinaryTree');
const tree1 = new BT.Tree();

tree1.insert(1);
// tree1.insert(2);
// tree1.insert(3);
// tree1.insert(null);
// tree1.insert(5);
// tree1.insert(null);
// tree1.insert(4);

console.log(rightSideView(tree1.root));
