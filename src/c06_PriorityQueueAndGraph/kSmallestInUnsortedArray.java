package c06_PriorityQueueAndGraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class kSmallestInUnsortedArray {
    public int[] solve(int[] array, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }
        for (int i = k; i < array.length; i++) {
            if (array[i] <= maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result[k - 1 - i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        kSmallestInUnsortedArray test = new kSmallestInUnsortedArray();
        int[] input = {5, 3, 1, 0, 2, 9};
        int[] result = test.solve(input, 4);
        System.out.println(Arrays.toString(result));
    }
}
