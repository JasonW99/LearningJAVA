package c10_DFSII;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> solve(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        SpiralRecur(matrix, result, 0);
        return result;
    }

    private void SpiralRecur(int[][] matrix, List<Integer> result, int level) {
        if (level == matrix.length / 2 + matrix.length % 2) {
            return;
        }
        if (level == matrix[0].length - level - 1) {
            result.add(matrix[level][matrix[0].length - level - 1]);
        } else {
            for (int i = level; i < matrix[0].length - level - 1; i++) {
                result.add(matrix[level][i]);
            }
            for (int i = level; i < matrix.length - level - 1; i++) {
                result.add(matrix[i][matrix[0].length - level - 1]);
            }
            for (int i = matrix[0].length - level - 1; i > level; i--) {
                result.add(matrix[matrix.length - level - 1][i]);
            }
            for (int i = matrix.length - level - 1; i > level; i--) {
                result.add(matrix[i][level]);
            }
        }
        SpiralRecur(matrix, result, level + 1);
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
/**
public class Solution {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        spiralRecur(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1, result);
        return result;
    }

    private void spiralRecur(int[][] matrix, int left, int right, int up, int down, List<Integer> result) {
        if (left > right) {
            return;
        }
        if (left == right) {
            result.add(matrix[up][left]);
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
        spiralRecur(matrix, left + 1, right - 1, up + 1, down - 1, result);
    }
}
**/