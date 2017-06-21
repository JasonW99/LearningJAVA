package DFSII;

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
        char[] array = input.toCharArray();
        char[] match = pattern.toCharArray();
        int i = 0;
        int j = 0;
        while (i < array.length && j < match.length) {
            if (isNum(match[j])) {
                int num = 0;
                while (j < match.length && isNum(match[j])) {
                    num = num * 10 + (match[j] - '0');
                    j++;
                }
                i += num;
            } else if (array[i] != match[j]) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return i == array.length && j == match.length;
    }

    private boolean isNum(Character c) {
        int i = c - '0';
        return i >= 0 && i <= 9;
    }
}
**/