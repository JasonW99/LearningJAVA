package c10_DFSII;

public class SpiralOrderGenerateII {
    public int[][] solve(int m, int n) {
        int[][] matrix = new int[m][n];
        if (m == 0 || n == 0) {
            return matrix;
        }
        SpiralRecur(matrix, 0, m - 1, 0, n - 1, 1);
        return matrix;
    }

    private void SpiralRecur(int[][] matrix, int up, int down, int left, int right, int num) {
        if (num > matrix.length * matrix[0].length) {
            return;
        }
        if (up == down) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num++;
            }
            return;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                matrix[i][left] = num++;
            }
            return;
        }
        for (int i = left; i < right; i++) {
            matrix[up][i] = num++;
        }
        for (int i = up; i < down; i++) {
            matrix[i][right] = num++;
        }
        for (int i = right; i > left; i--) {
            matrix[down][i] = num++;
        }
        for (int i = down; i > up; i--) {
            matrix[i][left] = num++;
        }
        SpiralRecur(matrix, up + 1, down -1, left + 1, right - 1, num);
    }

    public static void main(String[] args) {
        SpiralOrderGenerateII test = new SpiralOrderGenerateII();
        int[][] result = test.solve(2, 3);
    }
}

/**
public class Solution {
    public int[][] spiralGenerate(int m, int n) {
        int[][] array = new int[m][n];
        if (m == 0 || n == 0) {
            return array;
        }
        helper(array, 0, m, n, 1);
        return array;
    }

    private void helper(int[][] array, int start, int row, int col, int num) {
        if (row <= 1 || col <= 1) {
            if (row == 1) {
                for (int i = 0; i < col; i++) {
                    array[start][start+i] = num++;
                }
            } else if (col == 1) {
                for (int i = 0; i < row; i++) {
                    array[start+i][start] = num++;
                }
            }
            return;
        }
        for (int i = 0; i < col-1; i++) {
            array[start][start+i] = num++;
        }
        for (int i = 0; i < row-1; i++) {
            array[start+i][start+col-1] = num++;
        }
        for (int i = col-1; i > 0; i--) {
            array[start+row-1][start+i] = num++;
        }
        for (int i = row-1; i > 0; i--) {
            array[i][start] = num++;
        }
        helper(array, start+1, row-2, col-2, num);
    }
}
**/