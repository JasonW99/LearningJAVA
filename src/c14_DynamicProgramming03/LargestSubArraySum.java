package c14_DynamicProgramming03;

import java.util.Arrays;

public class LargestSubArraySum {
    public int solve(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] += array[i - 1];
            }
            max = Math.max(max, array[i]);
        }
        return max;
    }
}

/**
public class Solution {
    public int largestSum(int[] array) {
        int[] result = new int[3]; // position0 is the maxSum, position1 is the startingIndex, position2 is the endIndex
        int[] curr = new int[3];
        curr[0] = result[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (curr[0] >= 0) {
                curr[0] += array[i];
                curr[2] = i;
            } else {
                curr[0] = array[i];
                curr[1] = i;
            }
            if (curr[0] > result[0]) {
                result = Arrays.copyOf(curr, 3);
            }
        }
        return result[0];
    }
}
 **/