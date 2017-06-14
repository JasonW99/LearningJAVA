package c09_StringII;

import java.util.Deque;
import java.util.LinkedList;

public class StringReplaceII {
    public String solve(String input, String s, String t) {
        if (input == null || input.length() == 0) {
            return input;
        }
        Deque<Integer> indexStack = new LinkedList<Integer>();
        char[] array = input.toCharArray();
        findPosition(array, s, indexStack);
        if (indexStack.isEmpty()) {
            return input;
        }
        return replace(array, s.length(), t, indexStack);
    }

    private void findPosition(char[] array, String s, Deque<Integer> indexStack) {
        int i = 0;
        char[] target = s.toCharArray();
        while (i <= array.length - target.length) {
            if (match(array, target, i)) {
                i = i + target.length;
                indexStack.push(i - 1);
            } else {
                i++;
            }
        }
    }

    private boolean match(char[] array, char[] target, int i) {
        for (int j = 0; j < target.length; j++) {
            if (array[i + j] != target[j]) {
                return false;
            }
        }
        return true;
    }

    private String replace(char[] array, int len, String t, Deque<Integer> indexStack) {
        char[] newStr = t.toCharArray();
        int finalLen = array.length - indexStack.size() * (len - newStr.length);
        char[] result = new char[finalLen];
        int currNew = result.length - 1;
        int currOld = array.length - 1;
        int flag = indexStack.pop();
        while (currOld >= 0) {
            if (currOld == flag) {
                for (int i = newStr.length - 1; i >= 0; i--) {
                    result[currNew--] = newStr[i];
                }
                currOld = currOld - len;
                flag = indexStack.peek() == null ? -1 : indexStack.pop();
            } else {
                result[currNew--] = array[currOld--];
            }
        }
        return new String(result);
    }


    public static void main(String[] args) {
        StringReplaceII test = new StringReplaceII();
        System.out.println(test.solve( "aaabbbcccaaacc","aaa","x"));
    }
}
