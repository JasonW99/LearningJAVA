package c14_DynamicProgramming03;

public class LongestConsecutive1 {
    public int solve(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != 0 && array[i] == 1) {
                array[i] = array[i - 1] + 1;
            }
            max = Math.max(max, array[i]);
        }
        return max;
    }
}