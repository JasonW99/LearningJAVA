package c02_BinarySearch;

import java.util.Arrays;

public class searchMatrix {
    public int[] solve(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{-1, -1};
        }
        int[] result = new int[2];


        return new int[]{-1, -1};
    }







    public static void main(String[] args){
        searchMatrix test = new searchMatrix();
        int[][] input = {{1, 2, 3}, {4, 5, 7}, {8, 9, 10}};
        int T = 7;
        int[] result = test.solve(input, T);
        System.out.println(Arrays.toString(result));
    }
}
