package c06_PriorityQueueAndGraph;

import c05_BinartTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsCompleteTree {
    public boolean solve(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean bubble = false;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left == null) {
                bubble = true;
            } else if (bubble) {
                return false;
            } else {
                queue.offer(root.left);
            }
            if (root.right == null) {
                bubble = true;
            } else if (bubble) {
                return false;
            } else {
                queue.offer(root.right);
            }
        }
        return true;
    }
}

