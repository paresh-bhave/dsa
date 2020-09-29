/**
 * Linked List:
 * A linked list is a linear data structure, in which the elements are not stored at
 * contiguous memory locations. The elements in a linked list are linked using pointers
 *
 *
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

  /**
   *
   * In the order to insert an element at the end of the list we consider the following :
   * - If the list is empty then insert an element and it will be head
   * - If the list is not empty then iterate to the end of the list and insert an element at the end of the list
   */
  insert(element) {
    const node = new Node(element);
    let curr;
    if (this.head === null) {
      this.head = node;
    } else {
      curr = this.head;

      while(curr.next)
        curr = curr.next;

      curr.next = node;
    }
    this.size++;
  }


  /**
  * In order to add an element at the end of the list we consider three conditions as follows:
  * - if the index is zero we add an element at the front of the list and make it head
  * - If the index is the last position of the list we append the element at the end of the list
  * - if the index is inbetween 0 or size – 1 we iterate over to the index and add an element at that index
  */

  insertAt(element, index) {
    if (index > 0 && index > this.size) {
      return false;
    } else {
      const node = new Node(element);
      let curr, prev;

      curr = this.head;

      // add the element to first index

      if (index === 0) {
        node.next = this.head;
        this.head = node;
      } else {
        curr = this.head;
        let iterator = 0;

        // iterate over list to find out the position to insert
        while(iterator < index) {
          iterator++;
          prev = curr;
          curr = curr.next;
        }

        // adding an element
        node.next = curr;
        prev.next = node;
      }
      this.size++;
    }
  }

  /**
   * To remove element from list
   * - iterate over list until current is null (basically search)
   * - if element found, return the element
   */
  remove(element) {
    let curr = this.head;
    let prev = null;

    // iterate over the list
    while (curr !== null) {

      // compare lement with current
      // if found, then remove and return
      if (curr.element === element) {
        if (prev === null) {
          this.head = curr.next;
        } else {
          prev.next = curr.next;
        }
        this.size--;
        return curr.element;
      }

      prev = curr;
      curr = curr.next;
    }
    return -1;
  }


  /**
  * In order to remove an element from the list we consider three condition:
  * - if the index is 0 then we remove head and make next node head of the list
  * - if the index is size – 1 then we remove the last element form the list and make prev the last element
  * - if its in between 0 to size – 1 we remove the element by using prev and current node
 */
  removeFrom(index) {
    if (index > 0 && index > this.size) {
      return - 1;
    } else {
      let curr, prev, iterator = 0;

      curr = this.head;
      prev = curr;

      // if index is 0, delete first element
      if (index === 0) {
        this.head = curr.next;
      } else {
        // iterate over the list to the index position to remove the element
        while(iterator < index) {
          iterator++;
          prev = curr;
          curr = curr.next;
        }

        // remove the element
        prev.next = curr.next;
      }
      this.size--;

      // return the removed element
      return curr.element;
    }
  }

  /**
   * Helper methods
   */

  // get element at index
  get(index) {
    if (index === 0) {
      return this.head;
    }
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
    let count = 0;
    let curr = this.head;

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
      str += curr.element + (curr.next === null ? "" : " -> ");
      curr = curr.next;
    }
    console.log(str);
  }
}


module.exports = { Node, LinkedList }
