package c04_LinkedList;

public class middleNodeOfLinkedList {
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }
}
