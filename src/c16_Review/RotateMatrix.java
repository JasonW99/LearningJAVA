package c16_Review;

public class RotateMatrix {
    public void solve(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        rotateRecur(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
    }

    private void rotateRecur(int[][] matrix, int left, int right, int up, int down) {
        if (left >= right) {
            return;
        }
        int[] temp = new int[right - left];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = matrix[up][left + i];
            matrix[up][left + i] = matrix[down - i][left];
            matrix[down - i][left] = matrix[down][right - i];
            matrix[down][right - i] = matrix[up + i][right];
            matrix[up + i][right] = temp[i];
        }
        rotateRecur(matrix, left + 1, right - 1, up + 1, down - 1);
    }
}