package c19_BinaryTree;

import c05_BinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ReconstructBSTWithPostorderTr {
    public TreeNode solve(int[] post) {
        if (post.length == 0) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < post.length; i++) {
            stack.push(new TreeNode(post[i]));
        }
        TreeNode root = stack.pop();
        while (!stack.isEmpty()) {
            insert(root, stack.pop());
        }
        return root;
    }

    private void insert(TreeNode root, TreeNode newNode) {
        TreeNode prev = root;
        while (root != null) {
            prev = root;
            root = root.key > newNode.key ? root.left : root.right;
        }
        if (prev.key > newNode.key) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
    }
}