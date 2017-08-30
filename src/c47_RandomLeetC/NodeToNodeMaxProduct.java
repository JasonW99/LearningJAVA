package c47_RandomLeetC;

import c05_BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NodeToNodeMaxProduct {
    static private int result = Integer.MIN_VALUE;
    private class Element {
        int minN;
        int maxP;
        Element(int minN, int maxP) {
            this.maxP = maxP;
            this.minN = minN;
        }
    }
    public int solve(TreeNode root) {
        if (root == null) {
            return result;
        }
        findMaxProduct(root);
        return result;
    }

    private Element findMaxProduct(TreeNode root) {
        if (root == null) {
            return new Element(0, 0);
        }
        Element left = findMaxProduct(root.left);
        Element right = findMaxProduct(root.right);

        List<Integer> potentialReturn = new ArrayList<>();
        potentialReturn.add(root.key);
        potentialReturn.add(left.maxP * root.key);
        potentialReturn.add(left.minN * root.key);
        potentialReturn.add(right.maxP * root.key);
        potentialReturn.add(right.minN * root.key);
        int maxP = 0;
        int minN = 0;
        for (Integer curr : potentialReturn) {
            if (curr > 0) {
                maxP = Math.max(curr, maxP);
            }
            if (curr < 0) {
                minN = Math.min(curr, minN);
            }
        }

        List<Integer> potentialResult = new ArrayList<>();
        potentialResult.add(root.key);
        potentialResult.add(left.maxP * right.maxP * root.key);
        potentialResult.add(left.minN * right.maxP * root.key);
        potentialResult.add(left.maxP * right.minN * root.key);
        potentialResult.add(left.minN * right.minN * root.key);
        for (Integer curr : potentialResult) {
            result = Math.max(result, curr);
        }

        return new Element(minN, maxP);
    }

    public static void main(String[] args) {
        NodeToNodeMaxProduct test = new NodeToNodeMaxProduct();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(-3);
        TreeNode f = new TreeNode(0);
        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;
        System.out.println(test.solve(a));
    }
}
