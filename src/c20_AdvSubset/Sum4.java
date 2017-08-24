package c20_AdvSubset;

import java.util.HashMap;
import java.util.Map;

public class Sum4 {
    static class Pair {
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public boolean solve(int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                int curr = array[i] + array[j];
                if (map.containsKey(target - curr) && map.get(target - curr).right < i) {
                    return true;
                }
                if (!map.containsKey(curr)) {
                    map.put(curr, new Pair(i, j));
                }
            }
        }
        return false;
    }
}