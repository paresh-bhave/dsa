/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 *
 * merging them into one sorted list: 1->1->2->3->4->4->5->6
 *
 * Example 2:
 * Input: lists = []
 * Output: []
 *
 * Definition for singly-linked list:
 * function ListNode(val, next) {
 *   this.val = (val===undefined ? 0 : val)
 *   this.next = (next===undefined ? null : next)
 * }
 *
 * Source: https://leetcode.com/problems/merge-k-sorted-lists/
 */

const { Node, LinkedList } = require('./LinkedList');

// print util
function print(head) {
  if (head === null) return null;

  let str = '';
  while(head !== null) {
    str += `${head.element} -> `;
    head = head.next;
  };
  console.log(str);
}

/**
 * Approach 1: Divide and Conquer
 *
 * It is known that merging of two linked lists can be done in O(n) time and
 * O(1) space (For arrays O(n) space is required).
 *
 * - The idea is to pair up K lists and merge each pair in linear time using O(1) space.
 * - After first cycle, K/2 lists are left each of size 2*N.
 *   After second cycle, K/4 lists are left each of size 4*N and so on.
 * - Repeat the procedure until we have only one list left.
 *
 * Source: https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
 *
 * Time Complexity: O(nk logk)
 * Auxiliary Space: O(1)
 */
function mergeKLists(lists) {
  if (lists.length === 0) return [];
  /**
   * Takes two sorted list in increasing order,
   * and merge them into 1 big list
   */
  const sortedMerge = (a, b) => {
    let result;

    if (a === null) return b;
    if (b === null) return a;

    if (a.element <= b.element) {
      result = a;
      result.next = sortedMerge(a.next, b);
    } else {
      result = b;
      result.next = sortedMerge(a, b.next);
    }
    return result;
  };

  let last = lists.length - 1;

  // repeat until only one list is left
  while(last != 0) {
    let i = 0, j = last;

    while(i < j) {
      // Merge list from ith and jth index and store them i
      lists[i] = sortedMerge(lists[i], lists[j]);
      i++; j--;

      // If all pairs are merged, update last
      if (i >= j) last = j;
    }
  }

  return lists[0];
}



/**
 * Approach 2: Using Min Heap
 *
 * MinHeap: A Min-Heap is a complete binary tree in which the value in each internal node
 * is smaller than or equal to the values in the children of that node. Mapping the elements of a heap
 * into an array is trivial: if a node is stored at index k, then its left child is stored at
 * index 2k + 1 and its right child at index 2k + 2.
 *
 * - Create a min Heap and insert the first element of all k arrays.
 * - Run a loop until the size of MinHeap is greater than zero.
 * - Remove the top element of the MinHeap and print the element.
 * - Now insert the next element from the same array in which the removed element belonged.
 * - If the array doesn’t have any more elements, then replace root with infinite.
 *   After replacing the root, heapify the tree.
 *
 *
 * Source: https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
 *
 * Time Complexity: O(nk logk)
 * Auxiliary Space: O(k)
 */
function mergeKListsHeap(lists) {
  let head = new Node(),
      last = new Node();
  let heap = [];

  /**
   * Push the head of all nodes into heap
   */
  for (let i = 0; i < lists.length; i++) {
    if (lists[i] !== null) heap.push(lists[i]);
  }

  let len = heap.length;
  while(len > 0) {
    heap.sort((a, b) => a.element - b.element);

    let top = heap[0];

    heap.pop();

    if (top.next !== null) {
      heap.push(top.next);
    }

    if (head === null) {
      head = top;
      last = top;
    } else {
      last.next = top;
      last = top;
    }
    len--;
  }

    console.log(heap);
}

l1 = new LinkedList();
l1.insert(1);
l1.insert(4);
l1.insert(5);

l2 = new LinkedList();
l2.insert(1);
l2.insert(3);
l2.insert(4);

l3 = new LinkedList();
l3.insert(2);
l3.insert(6);

// console.log("-- K-MERGE USING DIVIDE AND CONQUER --");
// let merged = mergeKLists([l1.head, l2.head, l3.head]);
// print(merged);

// console.log(mergeKLists([]));
// console.log(mergeKLists([[]]));

console.log("\n-- K-MERGE USING MIN HEAP --");
let merged2 = mergeKListsHeap([l1.head, l2.head, l3.head]);
// print(merged2);
