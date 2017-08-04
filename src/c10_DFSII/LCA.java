package c10_DFSII;

public class LCA {
    public TreeNode lcaMain(TreeNode a, TreeNode b, TreeNode root) {
        TreeNode result = lca(a, b, root);
        if (result != a && result != b) {
            return result;
        }
        if (result == a && lca(b, null, a) == b) {
            return a;
        }
        if (result == b && lca(a, null, b) == a) {
            return b;
        }
        return null;
    }

    private TreeNode lca(TreeNode a, TreeNode b, TreeNode root) {
        if (root == a || root == b || root == null) {
            return root;
        }
        TreeNode left = lca(a, b, root.left);
        TreeNode right = lca(a, b, root.right);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}


/*
* given a very large tree with trillion nodes, and provided 1024 machines. how to utilize the algorithm?
*                          Big Tree
* l1 2 nodes
* L2 4 nodes
* ... ...
* L10 1024 nodes    N1, N2, N3,..., N1024
*
* BFS to find N1, N2, N3,..., N1024, during the procedure let's check if there is A or B within the top 10 level.
*   case 1: if found both A and B, then return LCA(A, B, root, level = 10)
*   case 2: if found only A(or B), then we can preOrder search B among perOreder_M1(N1, B), perOreder_M2(N2, B),...,perOreder_M1024(N1024, B).
*           let's say we find B in Mi, then we just need to return LCA(A, Mi, root, level = 10)
*   case 3: if none of A nor B is found.
*           do LCA_M1(A, B, N1), LCA_M2(A, B, N2),..., LCA_M1024(A, B, N1024)
*           subCase 1: if find only (Mi != A && Mi != B) then return Mi.
*           subcase 2: if find both (Mi == A && Mj == B) then return LCA(Mi, Mj, root, level = 10)
*           subcase 3: if find only (Mi == A) return subTree(chile = B, parent = A) ? Mi : null;
*           subcase 4: if find only (Mi == B) return subTree(chile = A, parent = B) ? Mi : null;
*           subcase 5: only nulls are returned, then return null.
* */
