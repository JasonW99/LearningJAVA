package c16_Review;


import c05_BinartTree.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor4 {
    public TreeNode solve(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<TreeNode>();
        for (TreeNode curr : nodes) {
            set.add(curr);
        }
        return LCARecur(root, set);
    }

    private TreeNode LCARecur(TreeNode root, Set<TreeNode> set) {
        if (root == null || set.contains(root)) {
            return root;
        }
        TreeNode left = LCARecur(root.left, set);
        TreeNode right = LCARecur(root.right, set);
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        return root;
    }
}
