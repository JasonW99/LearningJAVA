package c18_AdvTreeAndMerge;

import c04_LinkedList.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode merge(List<ListNode> listOfLists) {
        ListNode resultDummyHead = new ListNode(0);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        for (ListNode curr : listOfLists) {
            if (curr != null) {
                minHeap.offer(curr);
            }
        }
        ListNode resultCurr = resultDummyHead;
        while (!minHeap.isEmpty()){
            resultCurr.next = minHeap.poll();
            resultCurr = resultCurr.next;
            if (resultCurr.next != null) {
                minHeap.offer(resultCurr.next);
            }
        }
        resultCurr.next = null;
        return resultDummyHead.next;
    }
}


/**
public class Solution {
    public ListNode merge(List<ListNode> listOfLists) {
        if (listOfLists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listOfLists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value? -1: 1;
            }
        });
        for (ListNode node: listOfLists) {
            minHeap.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            cur.next = minHeap.poll();
            cur = cur.next;
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
 **/
