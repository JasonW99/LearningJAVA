package c18_AdvTreeAndMerge;

import c05_BinaryTree.TreeNode;

public class InsertBST {
    public TreeNode solve(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            return newNode;
        }
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            if (curr.key == key) {
                return root;
            }
            prev = curr;
            curr = curr.key > key ? curr.left : curr.right;
        }
        if (key < prev.key) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
        return root;
    }
}




/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
/**
public class Solution {
    public TreeNode insertNode(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null) {
            prev = cur;
            if (cur.key == key) {
                return root;
            } else if (cur.key > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (key > prev.key) {
            prev.right = new TreeNode(key);
        } else {
            prev.left = new TreeNode(key);
        }
        return root;
    }
}
**/