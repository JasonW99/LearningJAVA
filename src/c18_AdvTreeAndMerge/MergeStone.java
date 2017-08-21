package c18_AdvTreeAndMerge;

public class MergeStone {
    public int solve(int[] stones) {
        if (stones.length < 1) {
            return 0;
        }
        int n = stones.length;
        int[][] minStep = new int[n][n];
        int[] preSum = new int[n];
        for (int i = 0; i < n; i++) {
            preSum[i] = i == 0 ? stones[i] : preSum[i - 1] + stones[i];
        }
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                int minCurr = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    minCurr = Math.min(minCurr, minStep[i][k] + minStep[k + 1][j]);
                }
                minStep[i][j] = minCurr + preSum[j] - preSum[i] + stones[i];
            }
        }
        return minStep[0][n - 1];
    }
}


// M[i][j] represents the minimum cost to merge stone i to stone j as a group into a more larger pile
// for i = j, M[i][j] = 0 + stones[i]
// for i + 1 == j, M[i][j] = 0 + 0 + stones[i] + stones[j]
// for other M[i][j], M[i][j] = Math.min(M[i][k] + M[k + 1][j]) + stone[i] + stone[i + 1] + ... + stone[j]


/**
public class Solution {
    public int minCost(int[] stones) {
        if (stones.length == 1) {
            return 0;
        }
        int n = stones.length;
        int[][] dp = new int[n][n];
        int[] prefix_sum = getSum(stones);
        for (int size = 2; size <= n; size++) {
            for (int start = 0; start <= n - size; start++) {
                int end = start + size - 1;
                int min = Integer.MAX_VALUE;
                for (int k = start; k < end; k++) {
                    min = Math.min(min, dp[start][k] + dp[k + 1][end]);
                }
                dp[start][end] = start == 0 ? min + prefix_sum[end] : min + prefix_sum[end] - prefix_sum[start - 1];
            }
        }
        return dp[0][n - 1];
    }

    private int[] getSum(int[] stones) {
        int[] ans = new int[stones.length];
        ans[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            ans[i] = ans[i - 1] + stones[i];
        }
        return ans;
    }
}
 **/