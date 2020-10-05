/**
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Source: https://leetcode.com/problems/reverse-linked-list/
 *
 *
 * Definition for singly-linked list.
 *
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 *
 */


function reverseList(head) {
  let prev = null,
      curr = head;

  while(curr !== null) {
    let next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
  }

  return prev;
}

// Tests
const { Node, LinkedList } = require('../../js/list/LinkedList');

const list = new LinkedList();

list.insert(1);
list.insert(2);
list.insert(3);
list.insert(4);
list.insert(5);

let reversed = reverseList(list.head);

while(reversed !== null) {
  console.log(reversed.element);
  reversed = reversed.next;
};
