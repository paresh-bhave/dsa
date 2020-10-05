const { StackArray, StackList } = require('./Stack');

console.log("-- STACK ARRAY TEST --");

const stackA = new StackArray();
stackA.push(10);
stackA.push(20);
stackA.push(30);
stackA.push(40);

console.log("StackA size => ", stackA.size());
console.log("StackA peek => ", stackA.peek());
console.log("StackA pop => ", stackA.pop());
console.log("StackA size after popping => ", stackA.size());

stackA.push(70);
stackA.push(80);
stackA.push(100);

console.log("\n-- STACK ARRAY ITERATION --");

while(stackA.size() > 0) {
  console.log("stack => ", stackA.pop());
}
console.log("\nIs StackA empty? => ", stackA.isEmpty());


const stackL = new StackList();
stackL.push(10);
stackL.push(20);
stackL.push(30);
stackL.push(40);

console.log("\n-- STACK LIST TEST --");
console.log("StackL size => ", stackL.size());
console.log("StackL peek => ", stackL.peek());
console.log("StackL pop => ", stackL.pop());
console.log("StackL size after popping => ", stackL.size());

stackL.push(70);
stackL.push(80);
stackL.push(100);

console.log("\n-- STACK LIST ITERATION --");

while(stackL.size() > 0) {
  console.log("stack => ", stackL.pop());
}
console.log("\nIs StackL empty? => ", stackL.isEmpty());


