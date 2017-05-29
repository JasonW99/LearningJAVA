package c05_BinartTree;

public class checkIsBalanced {
    public boolean solve(TreeNode root) {
        return depth(root)!= -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth_left = depth(root.left);
        int depth_right = depth(root.right);
        if (depth_left == -1 || depth_right == -1 || Math.abs(depth_left - depth_right) > 1) {
            return -1;
        }
        return 1 + Math.max(depth_left, depth_right);
    }
}
