package c16_Review;

public class LowestCommonAncestor2 {
    public TreeNodeP solve(TreeNodeP one, TreeNodeP two) {
        int depthOne = findDepth(one);
        int depthTwo = findDepth(two);
        if (depthOne > depthTwo) {
            one = liftUp(one, depthOne - depthTwo);
        } else {
            two = liftUp(two, depthTwo - depthOne);
        }
        while (one != two) {
          one = one.parent;
          two = two.parent;
        }
        return one;
    }

    private int findDepth(TreeNodeP leaf) {
        int depth = 0;
        while (leaf != null) {
            depth++;
            leaf = leaf.parent;
        }
        return depth;
    }

    private TreeNodeP liftUp(TreeNodeP leaf, int level) {
        for (int i = 0; i < level; i++) {
            leaf = leaf.parent;
        }
        return leaf;
    }
}

/**
 * another approach
 * time O(height)
 * space O(height)
 *
 * step 1: find all the ancestor of One, store them in a HashSet
 * step 2: check if the ancestor of Two was in that HashSet*
 *
 * **/



/**
public class Solution {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        if (one == null || two == null) {
            return null;
        }
        int oneHeight = getHeight(one);
        int twoHeight = getHeight(two);
        if (oneHeight > twoHeight) {
            one = up(one, oneHeight - twoHeight);
        } else {
            two = up(two, twoHeight - oneHeight);
        }
        while (one != two) {
            one = one.parent;
            two = two.parent;
        }
        return one;
    }

    private int getHeight(TreeNodeP node) {
        int height = 0;
        while (node != null) {
            node = node.parent;
            height++;
        }
        return height;
    }

    private TreeNodeP up(TreeNodeP node, int level) {
        while (level > 0) {
            node = node.parent;
            level--;
        }
        return node;
    }
}
**/