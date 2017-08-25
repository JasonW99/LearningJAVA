package c21_AdvString;

import java.util.*;

public class PlaceChair {
    private class Element {
        int row;
        int col;
        Element(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static final char EQ = 'E';
    private static final char OB = 'O';

    public List<Integer> solve(char[][] gym) {
        int m = gym.length;
        int n = gym[0].length;
        int[][] totalCost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] == EQ) {
                    updateCost(gym, totalCost, i, j);
                }
            }
        }
        int[] result = new int[] {0, 0, Integer.MAX_VALUE};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] != OB && gym[i][j] != EQ && totalCost[i][j] < result[2]) {
//                if (gym[i][j] != OB && totalCost[i][j] < result[2]) {
                    result[0] = i;
                    result[1] = j;
                    result[2] = totalCost[i][j];
                }
            }
        }
        return result[2] == Integer.MAX_VALUE ? null : Arrays.asList(result[0], result[1]);
    }

    private void updateCost(char[][] gym, int[][] totalCost, int row, int col) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        visited[row][col] = true;
        int[][] newCost = new int[gym.length][gym[0].length];
        for (int i = 0; i < newCost.length; i++) {
            for (int j = 0; j < newCost[0].length; j++) {
                newCost[i][j] = Integer.MAX_VALUE;
            }
        }
        newCost[row][col] = 0;
        totalCost[row][col] = Integer.MAX_VALUE;
        Deque<Element> queue = new LinkedList<>();
        queue.offer(new Element(row, col));
        while (!queue.isEmpty()) {
            Element curr = queue.poll();
            List<Element> neighbors = findNeighbor(curr.row, curr.col, gym.length, gym[0].length);
            for (Element currNeighbor : neighbors) {
                //if (gym[currNeighbor.row][currNeighbor.col] == OB || gym[currNeighbor.row][currNeighbor.col] == EQ) {
                if (gym[currNeighbor.row][currNeighbor.col] == OB) {
                    newCost[currNeighbor.row][currNeighbor.col] = Integer.MAX_VALUE;
                } else if (!visited[currNeighbor.row][currNeighbor.col]) {
                    queue.offer(currNeighbor);
                    newCost[currNeighbor.row][currNeighbor.col] = newCost[curr.row][curr.col] + 1;
                    updateTotalCost(currNeighbor.row, currNeighbor.col, newCost, totalCost);
                    visited[currNeighbor.row][currNeighbor.col] = true;
                }

            }
        }
    }

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private List<Element> findNeighbor(int row, int col, int m, int n) {
        List<Element> neighbors = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                neighbors.add(new Element(newRow, newCol));
            }
        }
        return neighbors;
    }

    private void updateTotalCost(int row, int col, int[][]newCost, int[][] totalCost) {
        if (totalCost[row][col] == Integer.MAX_VALUE || newCost[row][col] == Integer.MAX_VALUE) {
            totalCost[row][col] = Integer.MAX_VALUE;
        } else {
            totalCost[row][col] += newCost[row][col];
        }
    }

    public static void main(String[] args) {
        PlaceChair test = new PlaceChair();
        List<Integer> result = test.solve(new char[][] {{'E', 'C', 'E', 'O', 'C'}, {'E', 'O', 'C', 'C', 'E'}, {'O', 'O', 'E', 'C', 'C'}, {'C', 'O', 'C', 'E', 'E'}, {'E', 'C', 'C', 'C', 'C'}});
        for (Integer curr : result) {
            System.out.println(curr);
        }
    }
}

/**
public class Solution {
    class Element {
        int row;
        int col;
        int cost;

        Element(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public List<Integer> putChair(char[][] gym) {
        int[][] cost = new int[gym.length][gym[0].length];
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == 'E') {
                    bfs(i, j, gym, cost);
                }
            }
        }
        Element ans = new Element(0, 0, Integer.MAX_VALUE);
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == 'C' && cost[i][j] < ans.cost) {
                    ans.row = i;
                    ans.col = j;
                    ans.cost = cost[i][j];
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(ans.row);
        result.add(ans.col);
        return ans.cost == Integer.MAX_VALUE? null: result;
    }

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void bfs(int row, int col, char[][] gym, int[][] cost) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>(){
            @Override
            public int compare(Element o1, Element o2) {
                int value1 = o1.cost;
                int value2 = o2.cost;
                if (value1 == value2) {
                    return 0;
                }
                return value1 < value2? -1: 1;
            }
        });
        int[][] new_cost = new int[cost.length][cost[0].length];
        boolean[][] visited = new boolean[cost.length][cost[0].length];
        minHeap.offer(new Element(row, col, 0));
        visited[row][col] = true;
        while (!minHeap.isEmpty()) {
            Element cur = minHeap.poll();
            for (int i = 0; i < 4; i++) {
                int new_row = cur.row + dirs[i][0];
                int new_col = cur.col + dirs[i][1];
                if (inRange(new_row, new_col, cost.length, cost[0].length) && gym[new_row][new_col] != 'O' //
                        && !visited[new_row][new_col]) {
                    minHeap.offer(new Element(new_row, new_col, cur.cost + 1));
                    visited[new_row][new_col] = true;
                }
            }
            new_cost[cur.row][cur.col] = gym[cur.row][cur.col] == 'C'? cur.cost: Integer.MAX_VALUE;
        }
        for (int i = 0; i < gym.length; i++) {
            for (int j = 0; j < gym[0].length; j++) {
                if (gym[i][j] == 'C') {
                    cost[i][j] = (cost[i][j] == Integer.MAX_VALUE || new_cost[i][j] == 0) ? //
                            Integer.MAX_VALUE: cost[i][j] + new_cost[i][j];
                }
            }
        }
    }

    private boolean inRange(int cur_row, int cur_col, int row, int col) {
        return cur_row >= 0 && cur_row < row && cur_col >= 0 && cur_col < col;
    }
}
**/
