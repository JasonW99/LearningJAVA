package c04_LinkedList;

public class reverseListRecursion {
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = solve(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
