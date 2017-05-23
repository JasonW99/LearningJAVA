package c03_BinarySearch;

import java.util.Arrays;

public class searchMatrix {
    public int[] solve(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if(matrix[row][col] == target){
                return new int[]{row, col};
            }else if (matrix[row][col] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        searchMatrix test = new searchMatrix();
        int[][] input = {{1, 2, 3}, {4, 5, 7}, {8, 9, 10}};
        int T = 4;
        int[] result = test.solve(input, T);
        System.out.println(Arrays.toString(result));
    }
}
