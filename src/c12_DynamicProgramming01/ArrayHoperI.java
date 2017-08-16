package c12_DynamicProgramming01;

// O(n^2) solution
public class ArrayHoperI {
    public boolean solve(int[] array) {
        boolean[] result = new boolean[array.length];
        result[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && j + array[j] >= i) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[array.length - 1];
    }
}

/**
 * O(nk) solution
public class Solution {
    public boolean canJump(int[] array) {
        boolean[] result = new boolean[array.length];
        result[result.length - 1] = true;
        for (int i = result.length - 2; i >= 0; i--) {
            for (int j = 1; j <= array[i]; j++) {
                if (i + j < result.length && result[i + j]) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[0];
    }
}
**/