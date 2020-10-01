const { Node, LinkedList } = require('./CLinkedList');


const list = new LinkedList();

console.log("Is list empty => ", list.isEmpty());

list.insert(10);
list.insert(20);
list.insert(30);
list.insert(40);
list.insert(50);

list.print();

