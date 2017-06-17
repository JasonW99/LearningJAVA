package c09_StringII;

import java.util.Arrays;

public class Shuffle {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 3) {
            return array;
        }
        shuffleRecur(array, 0, array.length / 2 * 2 - 1, array.length / 2);
        return array;
    }

    private void shuffleRecur(int[] array, int start, int end, int level) {
        if (level == 0) {
            return;
        }
        shift(array, start + 1, end - 1);
        shuffleRecur(array, start + 1, end - 1, level - 1);
    }

    private void shift(int[] array, int start, int end) {
        int k = (end - start + 1) / 2;
        reverse(array, start, start + k - 1);
        reverse(array, start + k, end);
        reverse(array, start, end);
    }

    private void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Shuffle test = new Shuffle();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(test.solve(input)));
    }
}
