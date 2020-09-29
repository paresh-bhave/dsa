function removeNthFromEnd(head, n) {
  let fast = head,
    slow = head,
    prev;

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
