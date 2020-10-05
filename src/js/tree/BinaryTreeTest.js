const { Node, Tree } = require('./BinaryTree');

console.log("-- BT CONSTRUCTION & SEARCH --");

let tree = new Tree();

tree.insert(10);
tree.insert(15);
tree.insert(5);
tree.insert(50);
tree.insert(3);
tree.insert(12);
tree.insert(7);

console.log("Search for [5] => ", tree.search(5));
console.log("Search for [12] => ", tree.search(12));
console.log("Search for [50] => ", tree.search(50));
console.log("Search for [100] => ", tree.search(100));


const {
  BFS,
  DFSInOrder,
  DFSPreOrder,
  DFSPostOrder
} = require('./TreeSearch');

console.log("\n-- BT LEVEL ORDER TRAVERSE --");
BFS(tree.root);

console.log("\n-- BT IN-ORDER TRAVERSE --");
DFSInOrder(tree.root);

console.log("\n-- BT PRE-ORDER TRAVERSE --");
DFSPreOrder(tree.root);

console.log("\n-- BT POST-ORDER TRAVERSE --");
DFSPostOrder(tree.root);
