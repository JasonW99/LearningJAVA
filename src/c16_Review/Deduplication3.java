package c16_Review;

import java.util.Arrays;

public class Deduplication3 {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (fast == array.length - 1 || array[fast] != array[fast + 1]) {
                array[slow++] = array[fast++];
            } else {
                while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                    fast++;
                }
                fast++;
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
