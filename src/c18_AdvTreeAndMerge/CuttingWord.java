package c18_AdvTreeAndMerge;

public class CuttingWord {
    public int solve(int[] cuts, int length) {
        if (cuts.length == 0) {
            return 0;
        }
        int n = cuts.length + 2;

        int[] index = new int[n];
        for(int i = 0; i < cuts.length; i++) {
            index[i + 1] = cuts[i];
        }
        index[n - 1] = length;

        int[][] minCost = new int[n][n];

        for (int diff = 2; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    min = Math.min(min, minCost[i][k] + minCost[k][j] + index[j] - index[i]);
                }
                minCost[i][j] = min;
            }
        }
        return minCost[0][n - 1];
    }
}











/*cost[i][j] represents the min cost for wood segment from cutting point i to cutting point j
include the starting and ending point to the original input.
when i = j or i = j - 1, cost[i][j] = 0;
cost[i][j] = min(cost[i][k] + cost[k][j]) + input[j] - input[i], where k in range of [i + 1, j - 1]
result is cost[0][n + 1], n is the size of the cutting points.*/

/**
public class Solution {
    public int minCost(int[] cuts, int length) {
        if (cuts == null || cuts.length == 0) {
            return 0;
        }
        int[] input = new int[cuts.length + 2];
        input[0] = 0;
        input[input.length - 1] = length;
        for (int i = 1; i <= cuts.length; i++) {
            input[i] = cuts[i - 1];
        }
        int[][] cost = new int[input.length][input.length];
        for (int diff = 2; diff < input.length; diff++) {
            for (int start = 0; start < input.length - diff; start++) {
                int end = start + diff;
                cost[start][end] = Integer.MAX_VALUE;
                for (int k = start + 1; k < end; k++) {
                    cost[start][end] = Math.min(cost[start][end], cost[start][k] + cost[k][end]);
                }
                cost[start][end] += input[end] - input[start];
            }
        }
        return cost[0][input.length - 1];
    }
}
****/