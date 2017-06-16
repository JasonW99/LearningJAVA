package c09_StringII;

import java.util.Arrays;

public class Shuffle {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 3) {
            return array;
        }
        shuffleRecur(array, 0, array.length / 2 * 2 - 1);
        return array;
    }

    private void shuffleRecur(int[] array, int start, int end) {
        if(end - start < 2) {
            return;
        }
        int mid = start + (end - start) / 2;
        int lm = start + (end - start) / 4;
        int rm = end - (end - start) / 4;
        reverse(array, lm, rm);
        shuffleRecur(array, start, mid);
        shuffleRecur(array, mid + 1, end);
    }

    private void reverse(int[] array, int start, int end) {
        int start2 = start + (end - start) / 2 + 1;
        while (start2 <= end) {
            int temp = array[start];
            array[start++] = array[start2];
            array[start2++] = temp;
        }
    }

    public static void main(String[] args) {
        Shuffle test = new Shuffle();
        int[] input = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(test.solve(input)));
    }
}
