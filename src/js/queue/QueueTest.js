const { QueueArray, QueueList } = require('./Queue');

console.log("-- QUEUE ARRAY TEST --");

const queueA = new QueueArray();
queueA.enqueue(10);
queueA.enqueue(20);
queueA.enqueue(30);
queueA.enqueue(40);

console.log("QueueA size => ", queueA.size());
console.log("QueueA front => ", queueA.front());
console.log("QueueA dequeue => ", queueA.dequeue());
console.log("QueueA size after dequeueping => ", queueA.size());

queueA.enqueue(70);
queueA.enqueue(80);
queueA.enqueue(100);

console.log("\n-- QUEUE ARRAY ITERATION --");

while(queueA.size() > 0) {
  console.log("queue => ", queueA.dequeue());
}
console.log("\nIs QueueA empty? => ", queueA.isEmpty());

const queueL = new QueueList();
queueL.enqueue(10);
queueL.enqueue(20);
queueL.enqueue(30);
queueL.enqueue(40);

console.log("\n-- QUEUE LIST TEST --");
console.log("QueueL size => ", queueL.size());
console.log("QueueL front => ", queueL.front());
console.log("QueueL dequeue => ", queueL.dequeue());
console.log("QueueL size after dequeueping => ", queueL.size());

queueL.enqueue(70);
queueL.enqueue(80);
queueL.enqueue(100);

console.log("\n-- QUEUE LIST ITERATION --");

while(queueL.size() > 0) {
  console.log("queue => ", queueL.dequeue());
}
console.log("\nIs QueueL empty? => ", queueL.isEmpty());


