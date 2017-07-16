package c16_Review;

import java.util.Arrays;

public class Deduplication1 {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 1;
        while (fast < array.length) {
            if (array[fast] != array[fast - 1]) {
                array[++slow] = array[fast];
            }
            fast++;
        }
        return Arrays.copyOf(array, slow + 1);
    }
}

/**
public class Solution {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow - 1]) {
                continue;
            }
            array[slow++] = array[fast];
        }
        return Arrays.copyOf(array, slow);
    }
}
**/