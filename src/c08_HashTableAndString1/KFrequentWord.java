package c08_HashTableAndString1;

public class KFrequentWord {



}


/**
public class Solution {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < combo.length; i++) {
            Integer count = map.get(combo[i]);
            if (count == null) {
                count = 0;
            }
            map.put(combo[i], count+1);
        }
        k = Math.min(k, map.size());
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>(){
            @Override
            public int compare (String o1, String o2) {
                if (map.get(o1) == map.get(o2)) {
                    return 0;
                }
                return map.get(o1) < map.get(o2) ? -1: 1;
            }
        });
        for (String cur: map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(cur);
            } else if (map.get(cur) > map.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.offer(cur);
            }
        }
        String[] result = new String[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}
 **/
