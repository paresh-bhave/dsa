/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Example
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 *
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 *
 * Source: https://leetcode.com/problems/linked-list-cycle/
 */

function hasCycle(head) {
  let slowPtr = head,
      fastPtr = head;

  while(fastPtr !== null || fastPtr.next !== null) {
    slowPtr = slowPtr.next;
    fastPtr = fastPtr.next.next;
    if (fastPtr === slowPtr) return true;
  }
  return false;
}



