package c13_DynamicProgramming02;


// O(n^2) time complecity
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
/**
 * // O(n * k) time complexity
public class Solution {
    public int minJump(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int[] result = new int[array.length];
        for (int i = result.length - 2; i >= 0; i--) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= array[i]; j++) {
                if (i + j < result.length && result[i + j] != Integer.MAX_VALUE) {
                    result[i] = Math.min(result[i + j] + 1, result[i]);
                }
            }
        }
        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }
}
**/
/**
public class Solution {
    public int minJump(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        int[] result = new int[array.length];
        for (int i = result.length - 2; i >= 0; i--) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= array[i]; j++) {
                if (i + j < result.length && result[i + j] + 1 < result[i]) {
 // result[i + j] + 1 < result[i] this step is wrong, because Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
                    result[i] = result[i + j] + 1;
                }
            }
        }
        return result[0] ==  ? -1 : result[0];
    }
}
**/