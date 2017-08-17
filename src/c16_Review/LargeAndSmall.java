package c16_Review;

public class LargeAndSmall {
    public int[] solve(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] > array[array.length - 1 - i]) {
                swap(array, i, array.length - 1 - i);
            }
        }
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for (int i = 0; i <= array.length / 2; i++) {
            small = Math.min(small, array[i]);
            large = Math.max(large, array[array.length - 1 - i]);
        }
        return new int[] {large, small};
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

/**
public class Solution {
    public int[] largestAndSmallest(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] > array[right]) {
                swap(array, left, right);
            }
            left++;
            right--;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (left >= 0) {
            min = Math.min(array[left], min);
            left--;
        }
        while(right < array.length) {
            max = Math.max(max, array[right]);
            right++;
        }
        return new int[] {max, min};
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
**/