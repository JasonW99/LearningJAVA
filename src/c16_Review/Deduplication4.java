package c16_Review;

import java.util.Arrays;

public class Deduplication4 {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = -1;
        int fast = 0;
        while (fast < array.length) {
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast++];
            } else {
                while (fast < array.length && array[fast] == array[slow]) {
                    fast++;
                }
                slow--;
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
