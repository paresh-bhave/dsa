/**
 * Two Important Search Techniques:
 *
 * 1. Breadth First Search:
 * BFS starts at the tree root, and explores all of the neighbor nodes at the present depth
 * prior to moving on to the nodes at the next depth level.
 *
 * 2. Depth First Search:
 * DFS starts at the root node and explores as far as possible along each branch before backtracking
 */


/**
 * BFS Or Level Order Traversal requires two supportive function
 *
 * 1. Function that computes height of the tree
 */
function computeTreeHeight(root) {
  if (root === null) return 0;

  /** Compute height of each subtree */
  let leftSubTreeHeight = computeTreeHeight(root.left);
  let rightSubTreeHeight = computeTreeHeight(root.right);

  /** Use the larger one */
  if (leftSubTreeHeight > rightSubTreeHeight) return leftSubTreeHeight + 1;
  else return rightSubTreeHeight + 1;
}

/**
 * 2. Function that visits the nodes of each level of height
 */
function visitNodesOnLevel(root, level, i) {
  if (root === null) return;

  if (level === 1) {
    console.log(`Visited node at level[${i}] => `, root.value)
  } else {
    visitNodesOnLevel(root.left, level - 1, i);
    visitNodesOnLevel(root.right, level - 1, i);
  }
}

/**
 * Actual BFS function
 */
function BFS(root) {
  let height = computeTreeHeight(root);
  for (let i = 0; i <= height; i++)
    visitNodesOnLevel(root, i, i);
}



/**
 * As shown in TreeTraversal.js, Depth First Search can use 3 ways to traverse
 * 1. In Order
 * 2. Pre Order
 * 3. Post Order
 */

function DFSInOrder(root, level = 1) {
  if (root !== null) {
    DFSInOrder(root.left, level+1);
    if (level === 1)
      console.log(`Visited root[${level}] => `, root.value);
    else
      console.log(`Visited node at level[${level}] => `, root.value);
    DFSInOrder(root.right, level+1);
  }
}

function DFSPreOrder(root, level = 1) {
  if (root !== null) {
    if (level === 1)
      console.log(`Visited root[${level}] => `, root.value);
    else
      console.log(`Visited node at level[${level}] => `, root.value);
    DFSPreOrder(root.left, level+1);
    DFSPreOrder(root.right, level+1)
  }
}

function DFSPostOrder(root, level = 1) {
  if (root !== null) {
    DFSPostOrder(root.left, level+1);
    DFSPostOrder(root.right, level+1)
    if (level === 1)
      console.log(`Visited root[${level}] => `, root.value);
    else
      console.log(`Visited node at level[${level}] => `, root.value);
  }
}

module.exports = {
  BFS,
  DFSInOrder,
  DFSPreOrder,
  DFSPostOrder
}
