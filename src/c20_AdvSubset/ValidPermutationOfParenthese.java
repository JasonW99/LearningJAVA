package c20_AdvSubset;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ValidPermutationOfParenthese {
    private char[] Par = new char[] {'(', '[', '{', ')', ']', '}'};
    public List<String> solve(int l, int m, int n) {
        List<String> result = new ArrayList<>();
        int len = 2 * (l + m + n);
        char[] subResult = new char[len];
        Deque<Integer> stack = new LinkedList<>();
        int[] num = new int[] {l, m, n};
        findPar(subResult, result, num, stack, 0);
        return result;
    }

    private void findPar(char[] subResult, List<String> result, int[] num, Deque<Integer> stack, int level) {
        if (level == subResult.length) {
            result.add(new String(subResult));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (num[i] > 0) {
                subResult[level] = Par[i];
                num[i]--;
                stack.push(i + 3);
                findPar(subResult, result, num, stack, level + 1);
                stack.pop();
                num[i]++;
            }
        }
        if (!stack.isEmpty()) {
            int rightPar = stack.pop();
            subResult[level] = Par[rightPar];
            findPar(subResult, result, num, stack, level + 1);
            stack.push(rightPar);
        }
    }
}




/**
public class Solution {

    private static char[] Par = {'(', '[', '{', ')', ']', '}'};

    public List<String> validParentheses(int l, int m, int n) {
        List<String> result = new ArrayList<String>();
        char[] subResult = new char[2 * (l + m + n)];
        int[] numOfPar = new int[] {l, m, n};
        Deque<Character> stack = new LinkedList<Character>();
        permuRecur(subResult, result, numOfPar, Par, stack, 0);
        return result;
    }

    private void permuRecur(char[] subResult, List<String> result, int[] numOfPar, //
                            char[] Par, Deque<Character> stack, int level) {
        if (level == subResult.length) {
            result.add(new String(subResult));
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (numOfPar[i] > 0) {
                subResult[level] = Par[i];
                stack.push(Par[i]);
                numOfPar[i]--;
                permuRecur(subResult, result, numOfPar, Par, stack, level + 1);
                stack.pop();
                numOfPar[i]++;
            }
            if (!stack.isEmpty() && stack.peek() == Par[i]) {
                subResult[level] = Par[i + numOfPar.length];
                stack.pop();
                permuRecur(subResult, result, numOfPar, Par, stack, level + 1);
                stack.push(Par[i]);
            }
        }
    }
}
 **/