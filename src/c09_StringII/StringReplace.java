package c09_StringII;

import java.util.Deque;
import java.util.LinkedList;

public class StringReplace {
    public String solve(String input, String s, String t) {
        if (input == null || input.length() == 0) {
            return input;
        }
        Deque<Integer> indexQ = new LinkedList<Integer>();
        char[] array = input.toCharArray();
        findTarget(array, s, indexQ);
        if (indexQ.isEmpty()) {
            return input;
        }
        if (s.length() >= t.length()) {
            return replaceString(array, s.length(), t, indexQ);
        } else {
            return buildString(array, s.length(), t, indexQ);
        }
    }

    private void findTarget(char[] array, String s, Deque<Integer> index) {
        char[] target = s.toCharArray();
        int len = target.length;
        int curr = 0;
        while (curr <= array.length - len) {
            if (match(array, target, curr)) {
                index.offer(curr);
                curr = curr + len;
            } else {
                curr++;
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

    private String replaceString(char[] array, int len, String t, Deque<Integer> index) {
        char[] repStr = t.toCharArray();
        int finalLen = array.length - index.size() * (len - repStr.length);
        int slow = 0;
        int fast = 0;
        int flag = index.poll();
        while (fast < array.length) {
            if (fast < flag) {
                array[slow++] = array[fast++];
            } else {
                flag = index.peek() == null ? array.length : index.poll();
                fast = fast + len;
                for (int i = 0; i < repStr.length; i++) {
                    array[slow++] = repStr[i];
                }
            }
        }
        return new String(array, 0, finalLen);
    }

    private String buildString(char[] array, int len, String t, Deque<Integer> index) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int flag = index.poll();
        while(i < array.length) {
            if (i < flag) {
                result.append(array[i++]);
            } else {
                result.append(t);
                i = i + len;
                flag = index.peek() == null ? array.length : index.poll();
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        StringReplace test = new StringReplace();
        System.out.println(test.solve( "docomobbomomc","omo","aa"));
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
            if (fast <= input.length() - target.length() && match(input, target, fast)){
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