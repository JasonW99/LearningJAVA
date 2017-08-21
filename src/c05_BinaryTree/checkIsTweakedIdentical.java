package c05_BinaryTree;

public class checkIsTweakedIdentical {
    public boolean solve(TreeNode one, TreeNode two) {
        if (one == null || two == null) {
            return one == two;
        }
        return (one.key == two.key) && ((solve(one.left, two.left) && solve(one.right, two.right)) || (solve(one.left, two.right) && solve(one.right, two.left)));
    }
}
