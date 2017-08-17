package c17_ReviewII;

public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][]  matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = matrix.length;

        for (int diff = 0; diff < n; diff++) {
            for (int row = 0; row < n - diff; row++) {
                int col = row + diff;
                System.out.println(matrix[row][col]);
            }
        }
    }

}
