package c10_DFSII;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int key;
    TreeNode(int key) {
        left = null;
        right = null;
        this.key = key;
    }
}


public class CommonAncestorI {
    public TreeNode solve(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode left = solve(root.left, one, two);
        TreeNode right = solve(root.right, one, two);
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        return root;
    }
}
