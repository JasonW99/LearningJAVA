package c06_PriorityQueueAndGraph;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kSmallestInSortedMatrix {
    static class Element {
        int row;
        int col;
        Element(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int solve(int[][] matrix, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2) {
                if (matrix[e1.row][e1.col] == matrix[e2.row][e2.col]) {
                    return 0;
                }
                return matrix[e1.row][e1.col] < matrix[e2.row][e2.col] ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        int[] result = new int[k];
        minHeap.offer(new Element(0,0));
        for (int i = 0; i < k; i++) {
            Element curr = minHeap.poll();
            result[i] = matrix[curr.row][curr.col];
            if (curr.col + 1 < matrix[0].length && !visited[curr.row][curr.col + 1]){
                minHeap.offer(new Element(curr.row, curr.col + 1));
                visited[curr.row][curr.col + 1] = true;
            }
            if (curr.row + 1 < matrix.length && !visited[curr.row + 1][curr.col]){
                minHeap.offer(new Element(curr.row + 1, curr.col));
                visited[curr.row + 1][curr.col] = true;
            }
        }
        return result[k - 1];
    }

    public static void main(String[] args) {
        kSmallestInSortedMatrix test = new kSmallestInSortedMatrix();
        int[][] matrix = {{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
        int result = test.solve(matrix, 12);
        System.out.println(result);
    }
}
