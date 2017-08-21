package c16_Review;

import c05_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PrintTreeZigZag {
    public List<Integer> solve(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offerLast(root);
        boolean left2right = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++){
                if (left2right){
                    TreeNode curr = queue.pollFirst();
                    result.add(curr.key);
                    if (curr.left != null) {
                        queue.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offerLast(curr.right);
                    }
                }else {
                    TreeNode curr = queue.pollLast();
                    result.add(curr.key);
                    if (curr.right != null) {
                        queue.offerFirst(curr.right);
                    }
                    if (curr.left != null) {
                        queue.offerFirst(curr.left);
                    }
                }
            }
            left2right = !left2right;
        }
        return result;
    }
}
