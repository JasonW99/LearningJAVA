package DFSII;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> solve(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        SpiralRecur(matrix, 0, 0, result, visited);
        return result;
    }

    private void SpiralRecur(int[][] matrix, int row, int col, List<Integer> result, boolean[][] visited) {
        if (result.size() == matrix.length * matrix[0].length) {
            return;
        }
        result.add(matrix[row][col]);
        visited[row][col] = true;
        if (col + 1 < matrix[0].length && !visited[row][col + 1]) {
            SpiralRecur(matrix, row, col + 1, result, visited);
        } else if (row + 1 < matrix.length && !visited[row + 1][col]) {
            SpiralRecur(matrix, row + 1, col, result, visited);
        } else if (col - 1 >= 0 && !visited[row][col - 1]) {
            SpiralRecur(matrix, row, col - 1, result, visited);
        } else {
            SpiralRecur(matrix, row - 1, col, result, visited);
        }
    }
}

/**
public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        helper(matrix, 0, matrix.length-1, result);
        return result;
    }

    private void helper(int[][] matrix, int start, int end, List<Integer> result) {
        if (start >= end) {
            if (start == end) {
                result.add(matrix[start][start]);
            }
            return;
        }
        for (int i = start; i < end; i++) {
            result.add(matrix[start][i]);
        }
        for (int i = start; i < end; i++) {
            result.add(matrix[i][end]);
        }
        for (int i = end; i > start; i--) {
            result.add(matrix[end][i]);
        }
        for (int i = end; i > start; i--) {
            result.add(matrix[i][start]);
        }
        helper(matrix, start+1, end-1, result);
    }
}
**/