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

    public static void main(String[] args) {
        Deduplication1 test = new Deduplication1();
        int[] input = {2, 3, 3, 4};
        int[] result = test.solve(input);
        for(int i: result) {
            System.out.println(i);
        }
    }
}
