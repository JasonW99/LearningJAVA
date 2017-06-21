package c10_DFSII;

import c04_LinkedList.ListNode;

/**
 Reverse pairs of elements in a singly-linked list.

 Examples
 L = null, after reverse is null
 L = 1 -> null, after reverse is 1 -> null
 L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
 L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
 */

public class ReverseLLPairs {
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode helper = solve(head.next.next);
        ListNode result = head.next;
        result.next = head;
        head.next = helper;
        return result;
    }
}
