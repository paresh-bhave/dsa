/**
 * Tags: #LinkedList #TwoPointers
 */

const { Node, LinkedList } = require('../LinkedList');


function findMiddle(head) {
  let fast = head;
      slow = head;

  if (head !== null) {
    while(fast !== null && fast.next !== null) {
      fast = fast.next.next;
      slow = slow.next;
    }
  }

  return slow.element;
}


const list = new LinkedList();

list.insert(10);
list.insert(20);
list.insert(30);
list.insert(60);
list.insert(40);
list.insert(50);

console.log(findMiddle(list.head));
