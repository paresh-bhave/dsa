/**
 * Circular Linked List
 */

class Node {
  constructor(element) {
    this.element = element;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.size = 0;
  }

  insert(element) {
    const node = new Node(element);
    node.next = this.head;

    let curr = this.head;

    if (this.head !== null) {
      while(curr.next && curr.next.element !== this.head.element)
        curr = curr.next;
      curr.next = node;
    } else {
      node.next = node;
    }

    this.head = node;
    this.size++;
  }

  print() {
    let curr = this.head;
    let str = "";
    while(curr) {
      str += curr.element + (curr.next === null ? "" : " -> ");
      curr = curr.next;
      if (curr.element === this.head.element) break;
    };

    console.log(str);
  }
}


module.exports = { Node, LinkedList }
