package c14_DynamicProgramming03;

public class LargestSubArraySum {
    public int solve(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] += array[i - 1];
            }
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
