package c12_DynamicProgramming01;

import c09_StringII.LongestSubString;

public class LongestAscendingSubstring {
    public int solve(int[] array) {
        if (array.length <= 0) {
            return array.length;
        }
        int result = 1;
        int curr = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                curr++;
                result = Math.max(curr, result);
            } else {
                curr = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestAscendingSubstring test = new LongestAscendingSubstring();
        int[] array = new int[] {7, 2, 3, 1, 5, 8, 9, 6};
        System.out.println(test.solve(array));
    }
}

/**
public class Solution {
    public int longest(int[] array) {
        if (array.length <= 1) {
            return array.length;
        }
        int result = 1;
        int last = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                last++;
                result = Math.max(result, last);
            } else {
                last = 1;
            }
        }
        return result;
    }
}
**/