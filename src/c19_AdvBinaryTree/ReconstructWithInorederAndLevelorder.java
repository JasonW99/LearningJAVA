package c19_AdvBinaryTree;

import c05_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructWithInorederAndLevelorder {
    public TreeNode solve(int[] in, int[] level) {
        if (in.length == 0) {
            return null;
        }
        Map<Integer, Integer> mapIn = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            mapIn.put(in[i], i);
        }
        List<Integer> listLevel = new ArrayList<>();
        for (int i = 0; i < level.length; i++) {
            listLevel.add(level[i]);
        }
        return construct(mapIn, listLevel);
    }

    private TreeNode construct(Map<Integer, Integer> mapIn, List<Integer> listLevel) {
        if (listLevel.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(listLevel.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : listLevel) {
            if (mapIn.get(num) < mapIn.get(root.key)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        root.left = construct(mapIn, left);
        root.right = construct(mapIn, right);
        return root;
    }
}

/**
public class Solution {
    public TreeNode reconstruct(int[] in, int[] level) {
        if (in.length == 0) {
            return null;
        }
        return helper(in, 0, in.length-1, level);
    }

    private TreeNode helper(int[] in, int instart, int inend, int[] level) {
        if (instart > inend) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = instart; i <= inend; i++) {
            map.put(in[i], i);
        }
        TreeNode root = new TreeNode(0);
        for (int i = 0; i < level.length; i++) {
            Integer location = map.get(level[i]);
            if (location != null) {
                root.key = level[i];
                root.left = helper(in, instart, location-1, level);
                root.right = helper(in, location+1, inend, level);
                break;
            }
        }
        return root;
    }
}
 **/