package c04_LinkedList;

public class merge2sortedList {
    public ListNode solve(ListNode one, ListNode two) {
         if (one == null && two == null) {
             return null;
         }
         ListNode dummyhead = new ListNode(0);
         ListNode walk = dummyhead;
         while (one != null && two != null) {
             if (one.value <= two.value) {
                 walk.next = one;
                 one = one.next;
             } else {
                 walk.next = two;
                 two = two.next;
             }
             walk = walk.next;
         }
         if (one != null) {
             walk.next = one;
         } else {
             walk.next = two;
         }
         return dummyhead.next;
    }
}

