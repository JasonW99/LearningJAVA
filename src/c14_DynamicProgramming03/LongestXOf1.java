package c14_DynamicProgramming03;

public class LongestXOf1 {
    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] leftUp = new int[n][m];
        int[][] leftDown = new int[n][m];
        int[][] rightUp = new int[n][m];
        int[][] rightDown = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    leftUp[i][j] = matrix[i][j];
                    leftDown[n - i - 1][j] = matrix[n - i - 1][j];
                    rightUp[i][j] = matrix[i][j];
                    rightDown[n - i - 1][j] = matrix[n - i - 1][j];
                } else if (j == 0) {
                    leftUp[i][j] = matrix[i][j];
                    leftDown[i][j] = matrix[i][j];
                    rightUp[i][m - j - 1] = matrix[i][m - j - 1];
                    rightDown[i][m - j - 1] = matrix[i][m - j - 1];
                } else {
                    if (matrix[i][j] == 1) {
                        leftUp[i][j] = leftUp[i-1][j-1] + 1;
                    }
                    if (matrix[n-1-i][j] == 1) {
                        leftDown[n-1-i][j] = leftDown[n-i][j-1] + 1;
                    }
                    if (matrix[i][m-1-j] == 1) {
                        rightUp[i][m-1-j] = rightUp[i-1][m-j] + 1;
                    }
                    if (matrix[n-1-i][m-1-j] == 1) {
                        rightDown[n-1-i][m-1-j] = rightDown[n-i][m-j] + 1;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = Math.min(Math.min(leftUp[i][j], leftDown[i][j]), Math.min(rightUp[i][j], rightDown[i][j]));
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}

