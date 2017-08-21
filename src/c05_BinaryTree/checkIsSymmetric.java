package c05_BinaryTree;

public class checkIsSymmetric {
    public boolean solve(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            return one == two;  // if both null then true, if single null then false.
        }
        return one.key == two.key && isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }
}