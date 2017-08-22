package c19_AdvBinaryTree;

import c05_BinaryTree.TreeNode;

public class MaxSumPath {
    public int solve(TreeNode root) {
        int[] result = new int[] {Integer.MIN_VALUE};
        findPath(root, result);
        return result[0];
    }

    private int findPath(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = findPath(root.left, result);
        int right = findPath(root.right, result);
        result[0] = Math.max(result[0], root.key + Math.max(left, 0) + Math.max(right, 0));
        return root.key + Math.max(Math.max(left, right), 0);
    }
}
