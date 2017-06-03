package c06_PriorityQueueAndGraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class kSmallestInUnsortedArray {
    public int[] solve(int[] array, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer int1, Integer int2) {
                if (int1 == int2) {
                    return 0;
                }
                return int1 > int2 ? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
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
