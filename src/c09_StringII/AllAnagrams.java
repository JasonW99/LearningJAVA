package c09_StringII;

import java.util.*;

public class AllAnagrams {
    public List<Integer> solve(String s, String l) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() == 0 || l.length() < s.length()) {
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
        findAnagram(l, map, result, s.length());
        return result;
    }

    private void findAnagram(String I, Map<Character, Integer> map, List<Integer> result, int len) {
        int numOfNonZero = map.size();
        int i = 0;
        while (i < I.length()) {
            if (map.get(I.charAt(i)) != null) {
                map.put(I.charAt(i), map.get(I.charAt(i)) - 1);
                if (map.get(I.charAt(i)) == 0) {
                    numOfNonZero--;
                }
            }
            if (numOfNonZero == 0) {
                result.add(i - len + 1);
            }
            if (i >= len - 1 && map.get(I.charAt(i - len + 1)) != null) {
                map.put(I.charAt(i - len + 1), map.get(I.charAt(i - len + 1)) + 1);
                if (map.get(I.charAt(i - len + 1)) == 1) {
                    numOfNonZero++;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        AllAnagrams test = new AllAnagrams();
        List<Integer> result = test.solve("ab", "abcbac");
        for (Integer r : result) {
            System.out.println(r);
        }
    }



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