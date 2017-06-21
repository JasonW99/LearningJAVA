package DFSII;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<Integer>> solve (int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subResult = new ArrayList<Integer>();
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        boolean[] left2right = new boolean[2 * n - 1];
        boolean[] right2left = new boolean[2 * n - 1];



    }




}



/**
public class Solution {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] pos_diag = new boolean[2 * n - 1];
        boolean[] neg_diag = new boolean[2 * n - 1];
        dfs(0, n, cur, result, col, pos_diag, neg_diag);
        return result;
    }

    private void dfs(int level, int n, List<Integer> cur, List<List<Integer>> result, //
                     boolean[] col, boolean[] pos_diag, boolean[] neg_diag) {
        if (level == n) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !pos_diag[level + i] && !neg_diag[level - i + n - 1]) {
                col[i] = true;
                pos_diag[level + i] = true;
                neg_diag[level - i + n - 1] = true;
                cur.add(i);
                dfs(level + 1, n, cur, result, col, pos_diag, neg_diag);
                cur.remove(cur.size() - 1);
                col[i] = false;
                pos_diag[level + i] = false;
                neg_diag[level - i + n - 1] = false;
            }
        }
    }
}
**/