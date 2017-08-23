package c20_AdvSubset;

import c05_BinaryTree.TreeNode;

public class ReverseBinaryTreeUpsideDown {
    public TreeNode solve(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = solve(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}

/**
public class Solution {
    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        TreeNode curr = newRoot;
        while (curr.left != null) {
            curr = curr.left;
        }
        curr.left = root;
        curr.right = root.right;
        root.right = null;
        root.left = null;
        return newRoot;
    }
}
 **/
