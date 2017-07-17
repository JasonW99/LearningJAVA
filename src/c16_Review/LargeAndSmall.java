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