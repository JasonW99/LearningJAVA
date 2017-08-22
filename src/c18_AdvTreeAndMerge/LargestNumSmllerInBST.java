package c18_AdvTreeAndMerge;

import c05_BinaryTree.TreeNode;

public class LargestNumSmllerInBST {
    public int solve(TreeNode root, int target) {
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key < target) {
                result = Math.max(root.key, result);
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return result;
    }
}

