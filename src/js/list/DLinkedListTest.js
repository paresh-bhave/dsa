const { Node, LinkedList } = require('./DLinkedList');


const list = new LinkedList();

console.log("Is list empty => ", list.isEmpty());

list.insert(10);
list.insert(20);
list.insert(30);
list.insert(40);
list.insert(50);

console.log("\nList after adding elements");

list.print();

console.log("List size => ", list.sizeOf());

list.insert(70);

console.log("\nList after inserting element at the end");

list.print();

console.log("List size => ", list.sizeOf());

console.log("\nList after inserting element at 6th index");

list.insertAt(60, 5);

list.print();

console.log("List size => ", list.sizeOf());

list.removeFrom(2);
list.removeFrom(4);

console.log("\nList after removing elements from 2nd and 4th index");

list.print();

console.log("List size => ", list.sizeOf());


console.log("\nElement at index 3 => ", list.get(3).element);

console.log("\nIndex of element 70 => ", list.indexOf(70));
