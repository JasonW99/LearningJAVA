package c04_LinkedList;

public class partitionList {
    public ListNode solve(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode Sdummyhead = small;
        ListNode Ldummyhead = large;
        while (head != null) {
            if (head.value < target) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        small.next = Ldummyhead.next;
        large.next = null;
        return Sdummyhead.next;
    }
}
