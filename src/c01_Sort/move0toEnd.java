package c01_Sort;

import java.util.Arrays;

public class move0toEnd {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int start = 0;
        int end = 0;
        while (end < array.length) {
            if (array[end] == 0) {
                end++;
            } else {
                swap(array, end++, start++);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        move0toEnd test = new move0toEnd();
        int[] input = {1, 1, 0, 0, 3, 2};
        input = test.solve(input);
        System.out.println(Arrays.toString(input));
    }
}
