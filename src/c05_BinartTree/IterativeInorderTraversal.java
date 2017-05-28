package c05_BinartTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IterativeInorderTraversal {
    public List<Integer> solve(TreeNode root) {
        if (root == null) {
            return new LinkedList<Integer>();
        }
        List<Integer> result = new LinkedList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.key);
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return result;
    }
}
