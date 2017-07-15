package c15_Probability;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTrack {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    public MedianTrack() {
        left = new PriorityQueue<Integer>(Collections.reverseOrder());
        right = new PriorityQueue<Integer>();
    }

    public void read(int value) {
        if (left.isEmpty() && right.isEmpty()) {
            left.offer(value);
        } else if (value >= left.peek()) {
            right.offer(value);
            if (right.size() > left.size() + 1) {
                left.offer(right.poll());
            }
        } else {
            left.offer(value);
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            }
        }
    }

    public Double median() {
        if (right.isEmpty()) {
            return left.isEmpty() ? null : (double) left.peek();
        }
        if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2;
        }
        return left.size() > right.size() ? (double) left.peek() : (double) right.peek();
    }
}





/**
public class Solution {
    private PriorityQueue<Integer> minHeap; //larger half
    private PriorityQueue<Integer> maxHeap; // smaller half
    int count = 0;

    public Solution() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2? -1: 1;
            }
        });
        count = 0;
    }

    public void read(int value) {
        count++;
        maxHeap.offer(value);
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int larger = maxHeap.poll();
            int smaller = minHeap.poll();
            maxHeap.offer(smaller);
            minHeap.offer(larger);
        }
    }

    public Double median() {
        if (count == 0) {
            return null;
        }
        return maxHeap.size() > minHeap.size() ? (double) maxHeap.peek(): (double) (maxHeap.peek() + minHeap.peek())/2.0;
    }
}
 **/
