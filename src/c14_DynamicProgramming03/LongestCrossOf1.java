package c14_DynamicProgramming03;

public class LongestCrossOf1 {
    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] left2right = new int[n][m];
        int[][] right2left = new int[n][m];
        int[][] up2down = new int[n][m];
        int[][] down2up = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    up2down[i][j] = matrix[i][j];
                    down2up[n - i - 1][j] = matrix[n - i - 1][j];
                } else if (j == 0) {
                    left2right[i][j] = matrix[i][j];
                    right2left[i][m - j - 1] = matrix[i][m - j - 1];
                } else {
                    if (matrix[i][j] == 1) {
                        left2right[i][j] = left2right[i][j - 1] + 1;
                    }
                    if (matrix[i][m - j - 1] == 1) {
                        right2left[i][m - j - 1] = right2left[i][m - j] + 1;
                    }
                    if (matrix[i][j] == 1) {
                        up2down[i][j] = up2down[i - 1][j] + 1;
                    }
                    if (matrix[n - i - 1][j] == 1) {
                        down2up[n - i - 1][j] = down2up[n - i][j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = Math.min(Math.min(down2up[i][j], up2down[i][j]), Math.min(right2left[i][j], left2right[i][j]));
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}