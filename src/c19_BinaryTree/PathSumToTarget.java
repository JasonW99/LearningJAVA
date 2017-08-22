package c19_BinaryTree;

import c05_BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class PathSumToTarget {
    public boolean solve(TreeNode root, int target) {
        Set<Integer> prefSum = new HashSet<>();
        prefSum.add(0);
        return findPath(root, target, prefSum, 0);
    }

    private boolean findPath(TreeNode root, int target, Set<Integer> prefSum, int lastSum) {
        if (root == null) {
            return false;
        }
        int currSum = lastSum + root.key;
        if (prefSum.contains(currSum - target)) {
            return true;
        }
        boolean need_remove = prefSum.add(currSum);
        boolean left = findPath(root.left, target, prefSum, currSum);
        boolean right = findPath(root.right, target, prefSum, currSum);
        if (need_remove) {
            prefSum.remove(currSum);
        }
        return left || right;
    }
}




public class Solution {
    public boolean exist(TreeNode root, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        return containsSum(root, 0, target, set);
    }

    private boolean containsSum(TreeNode root, int sum, int target, Set<Integer> set) {
        if (root == null || set.contains(sum + root.key - target)) {
            return root != null;
        }
        sum += root.key;
        boolean need_remove = set.add(sum);
        if (containsSum(root.left, sum, target, set) || containsSum(root.right, sum, target, set)) {
            return true;
        }
        if (need_remove) {
            set.remove(sum);
        }
        return false;
    }
}
