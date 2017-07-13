package c14_DynamicProgramming03;

public class LargestSubMatrix {
    public int solve(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int down = 0; down < n; down++) {
            for (int up = 0; up <= down; up++) {
                int currMax = Integer.MIN_VALUE;
                for (int col = 0; col < m; col++) {
                    int currCol = up == 0 ? matrix[down][col] : matrix[down][col] - matrix[up - 1][col];
                    currMax = currMax <= 0 ? currCol : currMax + currCol;
                    max = Math.max(max, currMax);
                }
            }
        }
        return max;
    }
}


/**
public class Solution {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] vert_prefix = new int[n][m];
        vert_prefix[0] = matrix[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vert_prefix[i][j] = vert_prefix[i-1][j] + matrix[i][j];
            }
        }
        int max = 0;
        for (int row_end = 0; row_end < n; row_end++) {
            for (int row_start = 0;row_start <= row_end; row_start++) {
                int last = 0;
 for (int col = 0; col < m; col++) {
 int cur = row_start == 0? vert_prefix[row_end][col]: vert_prefix[row_end][col] - vert_prefix[row_start-1][col];
 if (last > 0) {
 cur += last;
 }
 max = Math.max(max, cur);
 last = cur;
                }
            }
        }
        return max;
    }
}
**/