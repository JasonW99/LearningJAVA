package c09_StringII;

public class ReverseWordI {
    public String solve(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        while (array[start] == ' ') {
            start++;
        }
        int end = start + 1;
        while (start < end && end < array.length) {
            while (array[end] != ' ') {
                end++;
            }
            reverse(array, start, end - 1);
            start = end;
        }
        reverse(array, 0, array.length - 1);
        return new String(array);
    }




}

/**
public class Solution {
    public String reverseWords(String input) {
        if (input == null) {
            return input;
        }
        int slow = 0;
        char[] array = input.toCharArray();
        while (slow < array.length) {
            int fast = wordEnd(array, slow);
            reverse(array, slow, fast);
            slow = fast + 2;
        }
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private int wordEnd(char[] array, int start) {
        while (start < array.length && array[start] != ' ') {
            start++;
        }
        return start - 1;
    }
}
 **/