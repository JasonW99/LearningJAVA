package c18_AdvTreeAndMerge;

import c05_BinaryTree.TreeNode;

public class ClosestNumInBST {
    public int solve(TreeNode root, int target) {
        int result = Integer.MAX_VALUE;
        while (root != null) {
            result = Math.abs(root.key - target) < Math.abs(result - target) ? root.key : result;
            if (root.key == target) {
                return root.key;
            }
            if (root.key > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return result;
    }
}

/**
public class Solution {
    public int closest(TreeNode root, int target) {
        int ans = Integer.MAX_VALUE;
        while (root != null) {
            ans = closer(ans, root.key, target);
            if (root.key == target) {
                return target;
            } else if (root.key > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }

    private int closer(int one, int two, int target) {
        int diff1 = Math.abs(one - target);
        int diff2 = Math.abs(two - target);
        return diff1 < diff2? one: two;
    }
}
 **/