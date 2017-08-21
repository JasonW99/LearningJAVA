package c05_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RecursiveInorderTraversal {
    public List<Integer> solve(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.key);
        inOrder(root.right, result);
    }
}

