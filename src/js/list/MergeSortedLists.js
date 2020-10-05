/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 *
 * Source: https://leetcode.com/problems/merge-two-sorted-lists/
 *
 */

// Tests
const { Node, LinkedList } = require('./LinkedList');

/**
 * Approach:
 * - Initialize a new list for result and through both lists in a single loop
 * - At each iteration
 *   - If both list have not reached end, compare the element and attach it to new list
 *   - Else If L2 has reached end, attached remaining L1
 *   - Else attach remaining L2
 */
function mergeTwoLists(l1, l2) {
  if (l1 === null && l2 === null) return null;
  if (l1 === null) return l1;
  if (l2 === null) return l2;

  let newList = new Node();
  let head = newList;

  while(l1 || l2) {
    if (l1 && l2) {
      if (l1.element < l2.element) {
        newList.next = l1;
        l1 = l1.next;
      } else {
        newList.next = l2;
        l2 = l2.next;
      }
    } else if (l1) {
      newList.next = l1;
      l1 = l1.next;
    } else {
      newList.next = l2;
      l2 = l2.next;
    }
    newList = newList.next;
  }

  const temp = head.next;
  head = null;
  head = temp;

  return head;
}

const l1 = new LinkedList();

l1.insert(1);
l1.insert(3);
l1.insert(5);
l1.insert(7);
l1.insert(9);

const l2 = new LinkedList();

l2.insert(2);
l2.insert(4);
l2.insert(6);
l2.insert(8);
l2.insert(10);

let merged = mergeTwoLists(l1.head, l2.head);

let str = '';
while(merged !== null) {
  str += `${merged.element} -> `;
  merged = merged.next;
};
console.log(str);
