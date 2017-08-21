package c17_ReviewII;

import c05_BinaryTree.TreeNode;

public class MaxSumPath {
    public int solve(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }

    private int findMax(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = findMax(root.left, max);
        int right = findMax(root.right, max);
        if (root.left == null || root.right == null) {
            return root.key + right + left;
        }
        max[0] = Math.max(max[0], root.key + left + right);
        return root.key + Math.max(left, right);
    }

}
