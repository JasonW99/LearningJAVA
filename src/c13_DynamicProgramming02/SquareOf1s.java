package c13_DynamicProgramming02;

public class SquareOf1s {
    public int solve(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int maxSq = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = 1 + Math.min(result[i - 1][j - 1], Math.min(result[i][j - 1], result[i - 1][j]));
                }
                maxSq = Math.max(maxSq, result[i][j]);
            }
        }
        return maxSq;
    }
}


/**
public class Solution {
    public int largest(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));
                    max = Math.max(max, matrix[i][j]);
                }
            }
        }
        return max;
    }
}
**/
/**
public class Solution {
    public int largest(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 0 && j != 0 && matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i][j - 1], matrix[i - 1][j]);
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], matrix[i][j]) + 1;
                }
                result = Math.max(result, matrix[i][j]);
            }
        }
        return result;
    }
}
**/