package c20_AdvSubset;

import java.util.*;

public class Sum2AllPair {
    public List<List<Integer>> solve(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                List<Integer> pair = map.get(target - array[i]);
                for (Integer currPair : pair) {
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(currPair);
                    subResult.add(i);
                    result.add(subResult);
                }
            }
            if (map.containsKey(array[i])) {
                map.get(array[i]).add(i);
            } else {
                List<Integer> newRecord = new ArrayList<>();
                newRecord.add(i);
                map.put(array[i], newRecord);
            }
        }
        return result;
    }
}

/**
public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target-array[i])) {
                List<Integer> indices = map.get(target-array[i]);
                for (int j: indices) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(j);
                    cur.add(i);
                    result.add(cur);
                }
            }
            List<Integer> locations = map.get(array[i]);
            if (locations == null) {
                locations = new ArrayList<Integer>();
            }
            locations.add(i);
            map.put(array[i], locations);
        }
        return result;
    }
}
**/
