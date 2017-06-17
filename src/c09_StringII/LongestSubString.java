package c09_StringII;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public int solve(String input) {
        if (input.length() <= 1) {
            return input.length();
        }
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()) {
            if (distinct.contains(input.charAt(fast))) {
                distinct.remove(input.charAt(slow++));
            } else {
                distinct.add(input.charAt(fast++));
                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubString test = new LongestSubString();
        System.out.print(test.solve("gwbcdfbx"));
    }

}


/**
public class Solution {
    public int longest(String input) {
        if (input.length() <= 1) {
            return input.length();
        }
        char[] letter = input.toCharArray();
        int slow = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int fast = 0; fast < letter.length; fast++) {
            if (!set.contains(letter[fast])) {
                set.add(letter[fast]);
                max = Math.max(max, fast - slow + 1);
            } else {
                while (letter[slow] != letter[fast]) {
                    set.remove(letter[slow]);
                    slow++;
                }
                slow++;
            }
        }
        return max;
    }
}
**/