package c19_AdvBinaryTree;

import c05_BinaryTree.TreeNode;

public class ReconstructBSTWithPostorderTrII {
    public TreeNode solve(int[] post) {
        if (post.length == 0) {
            return null;
        }
        return constructRecur(post, 0, post.length - 1);
    }

    private TreeNode constructRecur(int[] post, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(post[end]);
        if (start == end) {
            return root;
        }
        int rightStart = findMinLarge(post, start, end, root.key);
        root.right = constructRecur(post, rightStart, end - 1);
        root.left = constructRecur(post, start, rightStart - 1);
        return root;
    }

    private int findMinLarge(int[] array, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}


/**
public class Solution {
    public TreeNode reconstruct(int[] post) {
        if (post.length == 0) {
            return null;
        }
        return helper(post, 0, post.length - 1);
    }

    private TreeNode helper(int[] array, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(array[end]);
        }
        TreeNode root = new TreeNode(array[end]);
        int firstLarge = find(array, start, end-1, array[end]);
        root.left = helper(array, start, firstLarge-1);
        root.right = helper(array, firstLarge, end-1);
        return root;
    }

    private int find(int[] array, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return array[start] < target? start+1: start; // if all the values are smaller than target
    }
}
 **/