package c00_HelloWorld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int a = 123;
        sb.append(a);
        System.out.println(new String(sb));
        List<String> xx = new ArrayList<>();
        xx.add("001");
        xx.add("002");
        xx.add("003");
        System.out.println(Arrays.toString(xx.toArray()));
        String[] kk = xx.toArray(new String[3]);
        System.out.println(Arrays.toString(kk));
        int x = -8;
        System.out.println((x - 1) ^ -1);
//        x = x ^ -1;
        x >>= 1;
        int[] result = new int[32];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = x & 1;
            x >>>= 1;
        }
        System.out.println(Arrays.toString(result));

        int[][]  matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = matrix.length;
        for (int level = 0; level < n; level++) {
            for (int row = 0; row < n; row++) {
                int col = row + level;
                if (col >= n) {
                    break;
                }
                System.out.println(matrix[row][col]);
            }
        }

        for (int diff = 0; diff < n; diff++) {
            for (int row = 0; row < n - diff; row++) {
                System.out.println(matrix[row][row + diff]);
            }
        }
    }
}
