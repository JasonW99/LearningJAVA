package c07_DepthFirstSearch;


import java.util.ArrayList;
import java.util.List;

public class AllValidParentheses {
    public List<String> solve(int n) {
        List<String> result = new ArrayList<String>();
        char[] subResult = new char[2 * n];
        parenthesesRecur(subResult, result, 0, 0, 0);
        return result;
    }

    private void parenthesesRecur(char[] subResult, List<String> result, int level, int left, int right) {
        if (level == subResult.length) {
            result.add(new String(subResult));
            return;
        }
        if (left < subResult.length / 2) {
            subResult[level] = '(';
            parenthesesRecur(subResult, result, level + 1, left + 1, right);
        }
        if (right < left) {
            subResult[level] = ')';
            parenthesesRecur(subResult, result, level + 1, left, right + 1);
        }
    }

    public static void main(String[] args) {
        AllValidParentheses test = new AllValidParentheses();
        List<String> result = test.solve(3);
        for (String sub : result) {
            System.out.println(sub);
        }
    }
}

/**
public class Solution {
    public List<String> validParentheses(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb, result);
        return result;
    }

    private void dfs(int left, int right, StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(sb));
            return;
        }
        if (left > 0) {
            sb.append('(');
            dfs(left - 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            dfs(left, right - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
**/