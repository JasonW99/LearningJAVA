package c09_StringII;


import java.util.ArrayList;
import java.util.List;

public class StringReplaceII {
    public String solve(String input, String s, String t) {
        if (input == null || input.length() == 0 || input.length() < s.length()) {
            return input;
        }
        List<Integer> index = new ArrayList<Integer>();
        findMatch(input, s, index);
        if (index.isEmpty()) {
            return input;
        }
        if (s.length() > t.length()) {
            return shortReplace(input, s.length(), t, index);
        } else {
            return longReplace(input, s.length(), t, index);
        }
    }

    private void findMatch(String input, String s, List<Integer> index) {
        int i = 0;
        while (i <= input.length() - s.length()) {
            if (match(input, s, i)) {
                index.add(i);
                i += s.length();
            } else {
                i++;
            }
        }
    }

    private boolean match(String input, String s, int i) {
        for (int j = 0; j < s.length(); j++) {
            if (input.charAt(i + j) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private String shortReplace(String input, int len, String t, List<Integer> index) {
        char[] array = input.toCharArray();
        char[] target = t.toCharArray();
        int currOld = 0;
        int currNew = 0;
        int i = 0;
        while (currOld < array.length) {
            if (i < index.size() && currOld == index.get(i)) {
                for (int j = 0; j < target.length; j++) {
                    array[currNew++] = target[j];
                }
                currOld += len;
                i++;
            } else {
                array[currNew++] = array[currOld++];
            }
        }
        return new String(array, 0, currNew);
    }

    private String longReplace(String input, int len, String t, List<Integer> index) {
        char[] array = input.toCharArray();
        char[] target = t.toCharArray();
        int finalLen = array.length + index.size() * (target.length - len);
        char[] result = new char[finalLen];
        int currOld = array.length - 1;
        int currNew = finalLen - 1;
        int i = index.size() - 1;
        while (currOld >= 0) {
            if (i >= 0 && currOld == index.get(i) + len - 1) {
                for (int j = target.length - 1; j >= 0; j--) {
                    result[currNew--] = target[j];
                }
                currOld -= len;
                i--;
            } else {
                result[currNew--] = array[currOld--];
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        StringReplaceII test = new StringReplaceII();
        System.out.println(test.solve("aaabbbcccaaacc", "aaa", "xxxx"));
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