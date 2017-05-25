package c04_LinkedList;

public class checkCycle {
    public boolean solve(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if(fast == head) {
                return true;
            }
            head = head.next;
            fast = fast.next.next;
        }
        return false;
    }
}
