package c09_StringII;


import java.util.ArrayList;
import java.util.List;

public class StringReplaceII {
    public String solve(String input, String s, String t) {
        if (input == null || input.length() == 0 || input.length() < s.length()) {
            return input;
        }
        List<Integer> index = findMatch(input, s);
        if (index.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        if (s.length() >= t.length()) {
            return shortReplace(array, s.length(), t, index);
        }
        return longReplace(array, s.length(), t, index);
    }

    private List<Integer> findMatch(String input, String s) {
        List<Integer> result = new ArrayList<Integer>();
        int curr = 0;
        while (curr <= input.length() - s.length()) {
            if (match(input, s, curr)) {
                result.add(curr);
                curr += s.length();
            } else {
                curr++;
            }
        }
        return result;
    }

    private boolean match(String input, String s, int i) {
        for (int j = 0; j < s.length(); j++) {
            if (input.charAt(i + j) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private String shortReplace(char[] array, int len, String target, List<Integer> index) {
        int newCurr = 0;
        int oldCurr = 0;
        int flagCurr = 0;
        while (oldCurr < array.length) {
            if (flagCurr < index.size() && oldCurr == index.get(flagCurr)) {
                for (int i = 0; i < target.length(); i++) {
                    array[newCurr++] = target.charAt(i);
                }
                oldCurr += len;
                flagCurr++;
            } else {
                array[newCurr++] = array[oldCurr++];
            }
        }
        return new String(array, 0, newCurr);
    }

    private String longReplace(char[] array, int len, String target, List<Integer> index) {
        int finalLen = array.length + index.size() * (target.length() - len);
        char[] result = new char[finalLen];
        int newCurr = finalLen - 1;
        int oldCurr = array.length - 1;
        int flagCurr = index.size() - 1;
        while (oldCurr >= 0) {
            if (flagCurr >= 0 && oldCurr == index.get(flagCurr) + len - 1) {
                for (int i = target.length() - 1; i >= 0; i--) {
                    result[newCurr--] = target.charAt(i);
                }
                oldCurr -= len;
                flagCurr--;
            } else {
                result[newCurr--] = array[oldCurr--];
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        StringReplaceII test = new StringReplaceII();
        System.out.println(test.solve("aaabbbcccaaacc", "aaa", "x"));
    }
}

/**
public class Solution {
    public String replace(String input, String s, String t) {
        if (s.length() > input.length()) {
            return input;
        }
        if (s.length() >= t.length()) {
            return shorter(input, s, t);
        }
        List<Integer> location = find(input, s);
        if (location.size() == 0) {
            return input;
        }
        char[] letter = new char[input.length() + location.size() * (t.length() - s.length())];
        int slow = letter.length - 1;
        int fast = input.length() - 1;
        int last = location.size() - 1;
        while (fast >= 0) {
            if (last >= 0 && location.get(last) == fast) {
                rep(letter, t, slow);
                fast = fast - s.length();
                slow = slow - t.length();
                last--;
            } else {
                letter[slow--] = input.charAt(fast);
                fast--;
            }
        }
        return new String(letter);
    }

    private String shorter(String input, String target, String rep) {
        char[] letter = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (fast <= input.length() - target.length() && match(input, target, fast)) {
                rep(letter, rep, slow + rep.length() - 1);
                slow = slow + rep.length();
                fast = fast + target.length();
            } else {
                letter[slow++] = input.charAt(fast++);
            }
        }
        return new String(letter, 0, slow);
    }

    private void rep(char[] letter, String target, int end) {
        for (int i = target.length() - 1; i >= 0; i--) {
            letter[end--] = target.charAt(i);
        }
    }

    private List<Integer> find(String input, String target) {
        int index = 0;
        List<Integer> location = new ArrayList<>();
        while (index <= input.length() - target.length()) {
            if (match(input, target, index)) {
                location.add(index + target.length() - 1);
                index = index + target.length();
            } else {
                index++;
            }
        }
        return location;
    }

    private boolean match(String input, String target, int index) {
        if (index + target.length() > input.length()) {
            return false;
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != input.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }
}
**/