package c05_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IterativePreorderTraversal {
    public List<Integer> solve(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null) {
            result.add(root.key);
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            root = stack.pop();
            root = root.right;
            while (root != null) {
                result.add(root.key);
                stack.push(root);
                root = root.left;
            }
        }
        return result;
    }
}