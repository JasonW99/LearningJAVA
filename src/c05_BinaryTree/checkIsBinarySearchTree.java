package c05_BinaryTree;

public class checkIsBinarySearchTree {
    public boolean solve(TreeNode root) {
        return withinRegion(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean withinRegion(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (min < root.key && root.key < max) {
            return withinRegion(root.left, min, root.key) && withinRegion(root.right, root.key, max);
        }
        return false;
    }
}