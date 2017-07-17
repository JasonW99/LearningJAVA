package c16_Review;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SpecifiedOrder {
    public int[] solve(int[] A1, int[] A2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A2.length; i++) {
            map.put(A2[i], i);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(A1.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer one, Integer two) {
                if (one.equals(two)) {
                    return 0;
                }
                if (map.get(one) == null && map.get(two) == null) {
                    return one < two ? -1 : 1;
                }
                if (map.get(one) == null || map.get(two) == null) {
                    return map.get(one) == null ? 1 : -1;
                }
                return map.get(one) < map.get(two) ? -1 : 1;
            }
        });
        for (int i = 0; i < A1.length; i++) {
            heap.offer(A1[i]);
        }
        for (int i = 0; i < A1.length; i++) {
            A1[i] = heap.poll();
        }
        return A1;
    }
}


/**
public class Solution {
    public int[] sortSpecial(int[] A1, int[] A2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A2.length; i++) {
            map.put(A2[i], i);
        }
        int[] helper = new int[A1.length];
        sort(A1, helper, map, 0, A1.length - 1);
        return A1;
    }

    private void sort(int[] array, int[] helper, Map<Integer, Integer> map, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(array, helper, map, start, mid);
        sort(array, helper, map, mid+1, end);
        merge(array, helper, map, start, mid, end);
    }

    private void merge(int[] array, int[] helper, Map<Integer, Integer> map, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            helper[i] = array[i];
        }
        int i = start;
        int j = mid + 1;
        int cur = start;
        while (i <= mid && j <= end) {
            if (smaller(helper, i, j, map)) {
                array[cur++] = helper[i++];
            } else {
                array[cur++] = helper[j++];
            }
        }
        while (i <= mid) {
            array[cur++] = helper[i++];
        }
    }

    private boolean smaller(int[] array, int i, int j, Map<Integer, Integer> map) {
        int a = array[i];
        int b = array[j];
        if (!map.containsKey(a) && !map.containsKey(b)) {
            return a < b;
        } else if (!map.containsKey(a) || !map.containsKey(b)) {
            return map.containsKey(a);
        } else {
            return map.get(a) < map.get(b);
        }
    }
}
 **/