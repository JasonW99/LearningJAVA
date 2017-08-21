package c18_AdvTreeAndMerge;

import c05_BinaryTree.TreeNode;

public class DeleteBST {
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.key > key) {
            root.left = delete(root.left, key);
        } else if (root.key < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.right == null || root.left == null) {
                return root.right == null ? root.left : root.right;
            }
            root.key = findLargest(root.left);
            root.left = delete(root.left, root.key);
        }
        return root;
    }

    private int findLargest(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }


}


/**
public class Solution {
    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.key > key) {
            root.left = delete(root.left, key);
        } else if (root.key < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                return root.right == null? root.left: root.right;
            }
            root.key = findSmallest(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    private int findSmallest(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }
}
 **/