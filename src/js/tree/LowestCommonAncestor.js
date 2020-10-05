/**
 *
 * Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or
 * directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 *
 * Example:
 *         _______3______
 *      /              \
 *   ___5__          ___1__
 *  /      \        /      \
 *  6      _2_     0        8
 *        /   \
 *        7    4
 * For the above tree, the LCA of nodes 5 and 1 is 3.
 *
 */



/**
 * Problem 1: Find the lowest common ancestor in an binary search tree given two values in the tree.
 *
 * Approach:
 *  For Binary search tree, while traversing the tree from top to bottom the first node which lies in between the two numbers n1 and n2 is the LCA of the nodes, i.e. the first node n with the lowest depth which lies in between n1 and n2 (n1<=n<=n2) n1 < n2. So just recursively traverse the BST in, if node's value is greater than both n1 and n2 then our LCA lies in the left side of the node, if it's is smaller than both n1 and n2, then LCA lies on the right side. Otherwise, the root is LCA (assuming that both n1 and n2 are present in BST).
 *
 * 1. Create a recursive function that takes a node and the two values n1 and n2.
 * 2. If the value of the current node is less than both n1 and n2, then LCA lies in the right subtree. Call the recursive function for thr right subtree.
 * 3. If the value of the current node is greater than both n1 and n2, then LCA lies in the left subtree. Call the recursive function for thr left subtree.
 * 4. If both the above cases are false then return the current node as LCA.
 *
 * Ref: https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */

function LCA_BST(node, valA, valB) {
  if (node === null)
      return null;

  // Case 1: If both valA and valA are smaller than the root, the LCA lies in the left
  if (node.value > valA && node.value > valB)
    return LCA_BST(node.left, valA, valB);

  // Case 2: If both valA and valA are greater than the root, the LCA lies in the right
  if (node.value < valA && node.value < valB)
    return LCA_BST(node.right, valA, valB);

  return node;
}

// Test
// const BST = require('./BinarySearchTree');
// const tree = new BST.Tree();

// tree.insert(3);
// tree.insert(5);
// tree.insert(1);
// tree.insert(6);
// tree.insert(2);
// tree.insert(7);
// tree.insert(4);
// tree.insert(0);
// tree.insert(8);

// const tests = [
//   LCA_BST(tree.root, 5, 1),
//   LCA_BST(tree.root, 5, 4),
//   LCA_BST(tree.root, 0, 8),
//   LCA_BST(tree.root, 7, 4),
//   LCA_BST(tree.root, 7, 6)
// ];


// for (let i = 0; i < tests.length; i++) {
//   if (tests[i]) console.log(tests[i].value);
// }


/**
 * Problem 2: Find the lowest common ancestor in an unordered binary tree given two values in the tree.
 * Source: https://www.interviewbit.com/problems/least-common-ancestor/
 */

/**
 * Approach:
 * If we assume that the keys n1 and n2 are present in Binary Tree, we can find LCA using single traversal of
 * Binary Tree and without extra storage for path arrays.
 * The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root,
 * then root is LCA (assuming that both keys are present). If root doesn’t match with any of the keys, we recur
 * for left and right subtree. The node which has one key present in its left subtree and the other key present
 * in right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA
 * lies in right subtree.
 */
function LCA_BT(node, valA, valB) {
  if (node === null) return null;

  /*If either valA or valB matches with root's key, report the presence by returning root */
  if (node.value === valA || node.value === valB)
    return node;

  /*Look for keys in left and right subtree*/
  const leftLCA = LCA_BT(node.left, valA, valB);
  const rightLCA = LCA_BT(node.right, valA, valB);

  /*If both of the above calls return non-null node both keys present in left and right subtree. So this node is LCA*/
  if (leftLCA !== null && rightLCA !== null)
    return node;

  /*Otherwise check if left subtree or right subtree is LCA*/
  return (leftLCA !== null) ? leftLCA : rightLCA;
}

// tests
const BT = require('./BinaryTree');
const tree1 = new BT.Tree();

tree1.insert(3);
tree1.insert(5);
tree1.insert(-1);
tree1.insert(6);
tree1.insert(2);
tree1.insert(7);
tree1.insert(8);
tree1.insert(4);
tree1.insert(0);

const tests1 = [
  LCA_BT(tree1.root, 5, -1),
  LCA_BT(tree1.root, 5, 4),
  LCA_BT(tree1.root, 0, 8),
  LCA_BT(tree1.root, 7, 4),
  LCA_BT(tree1.root, 7, 6)
];


for (let i = 0; i < tests1.length; i++) {
  if (tests1[i]) console.log(tests1[i].value);
}
