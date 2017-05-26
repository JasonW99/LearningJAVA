package c04_LinkedList;

/**
 Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

 Examples
 L = null, is reordered to null
 L = 1 -> null, is reordered to 1 -> null
 L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
 L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

 * */

public class reorderList {
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode middle = mid(head);
        ListNode secondpart = reverse(middle.next);
        middle.next = null;
        return merge(head, secondpart);
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummyhead = new ListNode(0);
        ListNode curr = dummyhead;
        while (first != null) {
            curr.next = first;
            first = first.next;
            if (second != null) {
                curr.next.next = second;
                second = second.next;
            }
            curr = curr.next.next;
        }
        return dummyhead.next;
    }
}