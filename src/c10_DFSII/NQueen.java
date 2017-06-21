package c10_DFSII;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<Integer>> solve (int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subResult = new ArrayList<Integer>();
        boolean[] col = new boolean[n];
        boolean[] left2right = new boolean[2 * n - 1];
        boolean[] right2left = new boolean[2 * n - 1];
        NQRecur(n, subResult, result, col, left2right, right2left, 0);
        return result;
    }

    private void NQRecur(int n, List<Integer> subResult, List<List<Integer>> result, boolean[] col, boolean[] left2right, boolean[] right2left, int level) {
        if (level == n) {
            result.add(new ArrayList<Integer>(subResult));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !left2right[level + n - i - 1] && !right2left[level + i]) {
                col[i] = true;
                left2right[level + n - i - 1] = true;
                right2left[level + i] = true;
                subResult.add(i);
                NQRecur(n, subResult, result, col, left2right, right2left, level + 1);
                col[i] = false;
                left2right[level + n - i - 1] = false;
                right2left[level + i] = false;
                subResult.remove(subResult.size() - 1);
            }
        }
    }
}

