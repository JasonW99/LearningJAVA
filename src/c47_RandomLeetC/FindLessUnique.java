package c47_RandomLeetC;

public class FindLessUnique {

    private class CounterTreeNode {
        int key;
        int freq;
        int numOfLeftSub;
        CounterTreeNode left;
        CounterTreeNode right;

        CounterTreeNode(int key) {
            this.key = key;
            this.freq = 1;
            this.numOfLeftSub = 0;
            this.left = null;
            this.right = null;
        }
    }

    private class InsertResult {
        CounterTreeNode root;
        boolean duplicate;

        InsertResult(CounterTreeNode root, boolean duplicate) {
            this.root = root;
            this.duplicate = duplicate;
        }
    }

    CounterTreeNode root = null;

    public void insert(int key) {
        InsertResult result = insertNode(root, key);
        root = result.root;
    }

    public InsertResult insertNode(CounterTreeNode root, int key) {
        if (root == null) {
            root = new CounterTreeNode(key);
            return new InsertResult(root, false);
        }
        if (root.key < key) {
            InsertResult rightResult = insertNode(root.right, key);
            root.right = rightResult.root;
            return new InsertResult(root, rightResult.duplicate);
        }
        if (root.key > key) {
            InsertResult leftResult = insertNode(root.left, key);
            root.left = leftResult.root;
            if (!leftResult.duplicate) {
                root.numOfLeftSub++;
            }
            return new InsertResult(root, leftResult.duplicate);
        }
        root.freq++;
        return new InsertResult(root, true);
    }

    public int rank(int target) {
        return findRank(root, target);
    }

    public int findRank(CounterTreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        if (root.key == target) {
            return root.numOfLeftSub;
        } else if (root.key < target) {
            return root.numOfLeftSub + 1 + findRank(root.right, target);
        } else {
            return findRank(root.left, target);
        }
    }

    public static void main(String[] args) {
        FindLessUnique test = new FindLessUnique();
        test.insert(10);
        test.insert(5);
        test.insert(3);
        test.insert(7);
        test.insert(9);
        test.insert(19);
        test.insert(11);
        test.insert(20);
        test.insert(10);
        System.out.println(test.root.key);
        System.out.println(test.rank(9));
        System.out.println(test.rank(11));
        System.out.println(test.rank(16));
    }
}
