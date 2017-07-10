package c12_DynamicProgramming01;

import java.util.Arrays;

public class MaxProductOfCuttingRope {
    public int solve(int length) {
        if (length <= 3) {
            return length - 1;
        }
        int[] result = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            result[i] = i;
            for (int j = 1; j <= 1 + (i - 1) / 2; j++) {
                result[i] = Math.max(result[i], j * result[i - j]);
            }
        }
        return result[length];
    }

    public static void main(String[] args) {
        MaxProductOfCuttingRope test = new MaxProductOfCuttingRope();
        System.out.println(test.solve(12));
    }
}
