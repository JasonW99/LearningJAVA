package c09_StringII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    public List<Integer> solve(String s, String I) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() == 0 || I.length() < s.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] target = s.toCharArray();
        for (char t : target) {
            if (map.get(t) == null) {
                map.put(t, 1);
            } else {
                map.put(t, map.get(t) + 1);
            }
        }
        findAnagram(I, map, result);
        return result;
    }

    private



}


/**
public class Solution {
    List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
        if (s.length() > l.length()) {
            return result;
        }
        char[] small = s.toCharArray();
        char[] large = l.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            if (map.containsKey(small[i])) {
                map.put(small[i], map.get(small[i])+1);
            } else {
                map.put(small[i], 1);
            }
        }
        int insufficient = map.size();
        for (int i = 0; i< large.length; i++) {
            if (map.containsKey(large[i])) {
                map.put(large[i], map.get(large[i])-1);
                if (map.get(large[i]) == 0) {
                    insufficient--;
                }
            }
            if (i >= small.length) {
                if (map.containsKey(large[i-small.length])) {
                    map.put(large[i-small.length], map.get(large[i-small.length])+1);
                    if (map.get(large[i-small.length]) == 1) {
                        insufficient++;
                    }
                }
            }
            if (insufficient == 0) {
                result.add(i - small.length + 1);
            }
        }
        return result;
    }
}
**/