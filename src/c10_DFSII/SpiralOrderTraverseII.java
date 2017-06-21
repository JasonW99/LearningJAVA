package c10_DFSII;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII {
    public List<Integer> solve(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int size = matrix.length * matrix[0].length;
        SpiralRecur(matrix, result, 0, matrix.length - 1, 0, matrix[0].length - 1, size);
        return result;
    }

    private void SpiralRecur(int[][] matrix, List<Integer> result, int up, int down, int left, int right, int size) {
        if (result.size() == size) {
            return;
        }
        if (up == down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            return;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][left]);
            }
            return;
        }
        for (int i = left; i < right; i++) {
            result.add(matrix[up][i]);
        }
        for (int i = up; i < down; i++) {
            result.add(matrix[i][right]);
        }
        for (int i = right; i > left; i--) {
            result.add(matrix[down][i]);
        }
        for (int i = down; i > up; i--) {
            result.add(matrix[i][left]);
        }
        SpiralRecur(matrix, result, up + 1, down - 1, left + 1, right - 1, size);
    }

    public static void main(String[] args) {
        SpiralOrderTraverseII test = new SpiralOrderTraverseII();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = test.solve(matrix);
        for(int i : result) {
            System.out.print(i);
        }
    }
}
