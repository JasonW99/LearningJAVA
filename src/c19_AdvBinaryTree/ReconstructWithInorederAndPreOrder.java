package c19_AdvBinaryTree;

import c05_BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructWithInorederAndPreOrder {
    public TreeNode solve(int[] in, int[] pre) {
        if (in.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return Construct(in, 0, in.length - 1, pre, 0, pre.length - 1, map);
    }

    private TreeNode Construct(int[] in, int inStart, int inEnd, int[] pre, int preStart, int preEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int positionIn = map.get(pre[preStart]);
        root.left = Construct(in, inStart, positionIn - 1, pre, preStart + 1, positionIn - inStart + preStart, map);
        root.right = Construct(in, positionIn + 1, inEnd, pre, preEnd - inEnd + positionIn + 1, preEnd, map);
        return root;
    }
}



/**
public class Solution {
    public TreeNode reconstruct(int[] in, int[] pre) {
        if (in.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return helper(in, 0, in.length-1, pre, 0, pre.length-1, map);
    }

    private TreeNode helper(int[] in, int instart, int inend, int[] pre, int prestart, int preend, Map<Integer, Integer> map) {
        if (instart > inend || prestart > preend) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prestart]);
        int location = map.get(pre[prestart]);
        root.left = helper(in, instart, location-1, pre, prestart+1, prestart+location-instart, map);
        root.right = helper(in, location+1, inend, pre, prestart+location-instart+1, preend, map);
        return root;
    }
}
 **/