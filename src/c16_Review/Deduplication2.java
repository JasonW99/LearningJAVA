package c16_Review;

import java.util.Arrays;

public class Deduplication2 {
    public int[] solve(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int slow = 1;
        int fast = 2;
        while (fast < array.length) {
            if (array[fast] != array[slow - 1]) {
                array[++slow] = array[fast];
            }
            fast++;
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
