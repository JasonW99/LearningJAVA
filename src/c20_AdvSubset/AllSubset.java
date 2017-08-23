package c20_AdvSubset;

import java.util.*;

public class AllSubset {
    public List<String> solve(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        StringBuilder subResult = new StringBuilder();
        char[] array = set.toCharArray();
        Arrays.sort(array);
        helper(array, subResult, result, 0);
        return result;
    }

    private void helper(char[] array, StringBuilder subResult, List<String> result, int level) {
        if (level == array.length) {
            result.add(new String(subResult));
            return;
        }
        subResult.append(array[level]);
        helper(array, subResult, result, level + 1);
        subResult.deleteCharAt(subResult.length() - 1);
        while (level + 1 < array.length && array[level] == array[level + 1]) {
            level++;
        }
        helper(array, subResult, result, level + 1);
    }
}

/**
public class Solution {
    public List<String> solve(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < set.length(); i++) {
            char curr = set.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            } else {
                map.put(curr, map.get(curr) + 1);
            }
        }
        char[] array = new char[map.size()];
        int i = 0;
        for (char curr : map.keySet()) {
            array[i++] = curr;
        }
        Arrays.sort(array);

        StringBuilder subResult = new StringBuilder();
        subSet(array, subResult, result, map, 0);
        return result;
    }

    private void subSet(char[] array, StringBuilder subResult, List<String> result, Map<Character, Integer> map, int level) {
        if (level == array.length) {
            result.add(new String(subResult));
            return;
        }
        for (int i = 0; i <= map.get(array[level]); i++) {
            for (int rep = 0; rep < i; rep++) {
                subResult.append(array[level]);
            }
            subSet(array, subResult, result, map, level + 1);
            for (int rep = 0; rep < i; rep++) {
                subResult.deleteCharAt(subResult.length() - 1);
            }
        }
    }
}
**/