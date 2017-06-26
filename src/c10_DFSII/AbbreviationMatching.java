package c10_DFSII;

public class AbbreviationMatching {
    public boolean solve(String input, String pattern) {
        char[] array = input.toCharArray();
        char[] target = pattern.toCharArray();
        int i = 0;
        int j = 0;
        while(i < array.length && j < target.length) {
            if (isNum(target[j])) {
                int temp = 0;
                while (j < target.length && isNum(target[j])) {
                    temp = temp * 10 + target[j++] - '0';
                }
                i += temp;
            } else if (array[i] != target[j]) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return i == array.length && j == target.length;
    }

    private boolean isNum(Character c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }
}

/**
public class Solution {
    public boolean match(String input, String pattern) {
        int slow = 0;
        int fast = 0;
        while (slow < pattern.length() && fast < input.length()) {
            if (isNum(pattern.charAt(slow))) {
                int num = 0;
                while (slow < pattern.length() && isNum(pattern.charAt(slow))) {
                    num = num * 10 + pattern.charAt(slow++) - '0';
                }
                fast += num;
            } else if (input.charAt(fast++) != pattern.charAt(slow++)) {
                return false;
            }
        }
        return slow == pattern.length() && fast == input.length();
    }

    private boolean isNum(char c) {
        int temp = c - '0';
        return temp >= 0 && temp <= 9;
    }
}
**/