package c18_AdvTreeAndMerge;


import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    public int value;
    public RandomListNode next;
    public RandomListNode random;
    public RandomListNode(int value) {
        this.value = value;
    }
}

public class CopyRandomPointerList {
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode resultDummyHead = new RandomListNode(0);
        RandomListNode resultCurr = resultDummyHead;
        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new RandomListNode(head.value));
            }
            resultCurr.next = map.get(head);
            resultCurr = resultCurr.next;
            if (head.random != null && !map.containsKey(head.random)) {
                map.put(head.random, new RandomListNode(head.random.value));
            }
            resultCurr.random = map.get(head.random);
            head = head.next;
        }
        //resultCurr.next = null;
        return resultDummyHead.next;
    }
}


/**
public class Solution {
    public RandomListNode copy(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, new RandomListNode(head.value));
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode copy = map.get(cur);
            RandomListNode next = map.get(cur.next);
            if (cur.next != null && next == null) {
                next = new RandomListNode(cur.next.value);
                map.put(cur.next, next);
            }
            copy.next = next;
            RandomListNode random = map.get(cur.random);
            if (cur.random != null && random == null) {
                random = new RandomListNode(cur.random.value);
                map.put(cur.random, random);
            }
            copy.random = random;
            cur = cur.next;
        }
        return map.get(head);
    }
}
 **/