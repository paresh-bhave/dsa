/**
 * Stack is a linear data structure which follows a particular order in which the operations are performed.
 * The order may be LIFO(Last In First Out) or FILO(First In Last Out).
 *
 * Note: In JS, a simple array can perform pretty much all of stack operations such a push(), pop(),
 * for peek you can do arr[arr.length-1] and array size is also dynamic
 * Following implementation is just to showcase how stack can be implemented in other languages
 * Also, You may need to consider additional implementation changes in strongly typed languages
 */

/**
 * Stack implementation using array
 */
class StackArray {
  constructor() { this.stack = [] }

  push(element) {
    this.stack.push(element);
  }

  pop() {
    if (this.isEmpty())
      throw new Error("Stack is underflow");
    return this.stack.pop();
  }

  peek() {
    if (this.isEmpty())
      throw new Error("Stack is empty");
    return this.stack[this.stack.length-1];
  }

  size() {
    return this.stack.length;
  }

  isEmpty() {
    return this.stack.length == 0;
  }
}



/**
 * Stack implementation using linked list
 */
const { Node, LinkedList } = require('../list/LinkedList');

class StackList {
  constructor() {
    this.stack = new LinkedList();
  }

  push(element) {
    this.stack.insert(element);
  }

  pop() {
    if (this.isEmpty())
      throw new Error("Stack is underflow");
    return this.stack.removeFrom(this.stack.sizeOf() - 1);
  }

  peek() {
    if (this.isEmpty())
      throw new Error("Stack is empty");
    return this.stack.get(this.stack.sizeOf() - 1).element;
  }

  size() {
    return this.stack.sizeOf();
  }

  isEmpty() {
    return this.stack.sizeOf() == 0;
  }
}

module.exports = { StackArray, StackList };
