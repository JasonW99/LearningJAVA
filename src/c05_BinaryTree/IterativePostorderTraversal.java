package c05_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IterativePostorderTraversal {
    public List<Integer> solve(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode latest = null; // the latest number printed in the traversal list.
        while (!stack.isEmpty()) {
            root = stack.peek();
            if (root.right == null || root.right == latest) {
                latest = stack.pop();
                result.add(latest.key);
            } else {
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        return result;
    }
}
