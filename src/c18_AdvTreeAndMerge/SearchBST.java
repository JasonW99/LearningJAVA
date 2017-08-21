package c18_AdvTreeAndMerge;

import c05_BinaryTree.TreeNode;

public class SearchBST {
    public TreeNode solve(TreeNode root, int key) {
        while (root != null) {
            if (root.key == key) {
                return root;
            }
            root = root.key > key ? root.left : root.right;
        }
        return root;
    }
}

/**
public class Solution {
    public TreeNode search(TreeNode root, int key) {
        while (root != null) {
            if (root.key == key) {
                return root;
            } else if (root.key > key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
**/