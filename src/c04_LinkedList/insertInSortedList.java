package c04_LinkedList;

public class insertInSortedList {
    public ListNode solve(ListNode head, int value) {
        ListNode newnode = new ListNode(value);
        if(head == null || head.value >= value) {
            newnode.next = head;
            return newnode;
        }
        ListNode result = head;
        while(head.next != null && head.next.value < value){
            head = head.next;
        }
        newnode.next = head.next;
        head.next = newnode;
        return result;
    }
}

/**
public class Solution {
    public ListNode insert(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.value < value) {
            prev = head;
            head = head.next;
        }
        ListNode cur = new ListNode(value);
        prev.next = cur;
        cur.next = head;
        return dummy.next;
    }
}
**/
