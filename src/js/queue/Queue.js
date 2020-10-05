/**
 * A Queue is a linear structure which follows a particular order in which the operations are performed.
 * The order is First In First Out (FIFO).
 *
 * Note: In JS, a simple array can perform pretty much all of queue operations with simple tricks
 * Following implementation is just to showcase how queue can be implemented in other languages
 * Also, You may need to consider additional implementation changes in strongly typed languages
 */

/**
 * Queue implementation is using array
 */
class QueueArray {
  constructor() {
    this.items = [];
  }

  enqueue(element) {
    this.items.push(element);
  }

  dequeue() {
    if(this.isEmpty())
      throw new Error("Queue is underflow");
    return this.items.shift();
  }

  front() {
    if(this.isEmpty())
      throw new Error("No elements in the queue");
    return this.items[0];
  }

  size() {
    return this.items.length;
  }

  isEmpty() {
    return this.items.length == 0;
  }
}


/**
 * Stack implementation using linked list
 */
const { Node, LinkedList } = require('../list/LinkedList');

class QueueList {
  constructor() {
    this.items = new LinkedList();
  }

  enqueue(element) {
    this.items.insert(element);
  }

  dequeue() {
    if(this.isEmpty())
      throw new Error("Queue is underflow");
    return this.items.removeFrom(0);
  }

  front() {
    if(this.isEmpty())
      throw new Error("No elements in the queue");
    return this.items.get(0).element;
  }

  size() { return this.items.sizeOf(); }

  isEmpty() { return this.items.sizeOf() == 0; }
}

module.exports = { QueueArray, QueueList };
