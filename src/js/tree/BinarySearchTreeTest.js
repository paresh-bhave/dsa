const { Node, Tree } = require('./BinarySearchTree');
const {
  BFS,
  DFSInOrder,
  DFSPreOrder,
  DFSPostOrder
} = require('./TreeSearch');

console.log("-- BST CONSTRUCTION & SEARCH --");

let tree = new Tree();

tree.insert(10);
tree.insert(15);
tree.insert(5);
tree.insert(50);
tree.insert(3);
tree.insert(12);
tree.insert(7);

console.log("\n-- BST IN-ORDER TRAVERSE --");
DFSInOrder(tree.root);

console.log("\nSearch for [5] => ", tree.get(5).value);
console.log("Search for [12] => ", tree.get(12).value);
console.log("Search for [50] => ", tree.get(50).value);
console.log("Search for [100] => ", tree.get(100)); // must be null

console.log("\nTree Min => ", tree.getMin());
console.log("\nTree Max => ", tree.getMax());

tree.deleteMin();
tree.deleteMax();
// tree.delete(3);

console.log("\n-- BST IN-ORDER TRAVERSE AFTER DELETION --");
DFSInOrder(tree.root);


console.log("\n-- BST LEVEL ORDER TRAVERSE --");
BFS(tree.root);

console.log("\n-- BST PRE-ORDER TRAVERSE --");
DFSPreOrder(tree.root);

console.log("\n-- BST POST-ORDER TRAVERSE --");
DFSPostOrder(tree.root);
