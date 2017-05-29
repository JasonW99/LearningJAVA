package c05_BinartTree;

import java.util.ArrayList;
import java.util.List;

public class getKeysInGivenRange {
    List<Integer> solve(TreeNode root, int min, int max) {
        List<Integer> result = new ArrayList<Integer>();
        getRange(root, min, max, result);
        return result;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (min < root.key) {
            getRange(root.left, min, max, result);
        }
        if (min <= root.key && root.key <= max) {
            result.add(root.key);
        }
        if (root.key < max) {
            getRange(root.right, min, max, result);
        }
    }
}
