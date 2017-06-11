package c08_HashTableAndString1;

import java.util.*;

public class KFrequentWord {
    public String[] solve(String[] compo, int k) {
        if (compo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String currStr : compo) {
            if (map.get(currStr) == null) {
                map.put(currStr, 1);
            } else {
                map.put(currStr, map.get(currStr) + 1);
            }
        }
        k = Math.min(k, map.size());
        PriorityQueue<String> minHeap = new PriorityQueue<String>(k, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return 0;
                }
                return map.get(s1) < map.get(s2) ? -1 : 1;
            }
        });
        for (String uniqueStr : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(uniqueStr);
            } else if (map.get(uniqueStr) > map.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.offer(uniqueStr);
            }
        }
        String[] result = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}

