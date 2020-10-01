
const { Node, LinkedList } = require('../LinkedList');

function removeNthFromEnd(head, n) {
  let fast = head,
    slow = head;

  for(let i = 0; i <= n; i++) {
    if (fast === null) return null;
    fast = fast.next;
  }

  console.log(fast);

  while(fast !== null) {
    slow = slow.next;
    fast = fast.next;
  }

  slow.next = slow.next.next;

  return head;
}

const list = new LinkedList();

list.insert(10);
list.insert(20);
list.insert(30);
list.insert(60);
list.insert(40);
list.insert(50);

removeNthFromEnd(list.head, 3);

list.print();
