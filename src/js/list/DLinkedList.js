/**
 * Doubly Linked List
 */

class Node {
  constructor(element) {
    this.element = element;
    this.next = null;
    this.prev = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * Simple insertion is easier in linked list
   * Since, we maintain tail, all we need to do is handle two condition
   * - If head is empty, point head to new node
   * - If not, point tail's next to new node and new node's prev to tail
   * - update tail
   */
  insert(element) {
    const node = new Node(element);

    if (this.head === null) {
      this.head = node;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
    }

    this.tail = node;
    this.size++;
  }

  /**
   * Inserting at specfic position is depends on 3 condition
   * - If index is 0, insert at begining an update head
   * - Else If index is at the end, insert at the end and update tail
   * - Else iterate to the index and insert node at the position
   */
  insertAt(element, index) {
    if (index > 0 && index > this.size) {
      return false;
    } else {
      const node = new Node(element);
      let curr;

      curr = this.head;

      // add the element to first index
      if (index === 0) {
        node.next = this.head;
        this.head = node;
      } else if (index === this.size) {
        node.prev = this.tail;
        this.tail = node;
      } else {
        curr = this.head.next;
        let iterator = 1;

        // iterate over list to find out the position to insert
        while(curr.next !== null && iterator < index - 1) {
          iterator++;
          curr = curr.next;
        }

        // Make new node point to next node in the list
        node.next = curr.next;

        // Make next node's prev node point to new node
        if (curr.next !== null)
          curr.next.prev = node;

        // Make our new node point to prev node
        node.prev = curr;

        // Make previous node's next point to new node
        curr.next = node;

        // check if inserted element was at the tail, if yes then make tail point to it
        if (this.tail.next != null)
          this.tail = this.tail.next;
      }
      this.size++;
    }
  }

  /**
   * Removing element is similar to singly list
   * - If element matches to head, remove from beginning and update head
   * - Else If element matches to tail, remove from end and update tail
   * - Else iterate till element matches with desired element and remove at position
   */
  remove(element) {
    let curr = this.head;

    if (element === this.head.element) {
      curr = this.head.next;
      curr.prev = null;
      this.head = curr;
      this.size--;
    } else if (element === this.tail.element) {
      curr = this.tail.prev;
      curr.next = null;
      this.tail = curr;
      this.size--;
    } else {
      while(curr.next !== null) {
        if (curr.element === element) {
          let temp = curr;
          curr.prev.next = temp.next;
          curr.next.prev = temp.prev;
          if (curr.prev.next === null) {
            this.tail = temp;
          }
          break;
        }
        curr = curr.next;
      }
      this.size--;
      return curr;
    }
    return -1;
  }


  removeFrom(index) {
    if (index < 0 || index > 0 && index > this.size) {
      return -1;
    } else {
      let curr = this.head;
      if (index === 0) {
        curr = this.head.next;
        curr.prev = null;
        this.head = curr;
        this.size--;
      } else if (index === this.size) {
        curr = this.tail.prev;
        curr.next = null;
        this.tail = curr;
        this.size--;
      } else {
        let iterator = 1;
        curr = this.head.next;

        while(iterator < index) {
          iterator++;
          curr = curr.next;
        }

        let temp = curr;
        curr.prev.next = temp.next;
        curr.next.prev = temp.prev;
        if (curr.prev.next === null) {
          this.tail = temp;
        }
        this.size--;
        return curr;
      }
    }
    return -1;
  }


  /**
   * Helper functions
   */

  // get element at index
  get(index) {
    if (index === 0) return this.head;

    if (index === this.size) return this.tail;

    let curr = this.head.next,
        iterator = 1;

    while(iterator < index) {
      iterator++;
      curr = curr.next;
    }
    return curr;
  }

  // returns index of the element
  indexOf(element) {

    if (this.head.element === element) return 0;

    if (this.tail.element === element) return this.size;

    let count = 1;
    let curr = this.head.next;

    // iterate over list until curr is null
    while(curr !== null) {
      // compare curr element with element to be removed
      if (curr.element === element)
        return count;
      count++;
      curr = curr.next;
    }

    // not found
    return -1;
  }

  // returns size of the list
  sizeOf() { return this.size; }

  // returns if list is is empty or not
  isEmpty() { return this.size === 0 }

  // prints the list
  print() {
    let curr = this.head;
    let str = "";
    while (curr) {
      str += (curr.element !== this.head.element ? " <- " : "NULL <- ") +
            curr.element +
            (curr.next === null ? " -> NULL" : " -> ");
      curr = curr.next;
    }
    console.log(str);
  }
}

module.exports = { Node, LinkedList }
