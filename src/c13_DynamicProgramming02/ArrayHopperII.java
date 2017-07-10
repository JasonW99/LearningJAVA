package c13_DynamicProgramming02;

public class ArrayHopperII {
    public int solve(int[] array) {
        int[] result = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (result[j] != Integer.MAX_VALUE && j + array[j] >= i) {
                    result[i] = Math.min(result[i], result[j] + 1);
                }
            }
        }
        return result[array.length - 1] == Integer.MAX_VALUE ? -1 : result[array.length - 1];
    }
}
