package c09_StringII;

public class ReverseWordI {
    public String solve(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        while (start < array.length) {
            while (start < array.length && array[start] == ' ') {
                start++;
            }
            int end = start + 1;
            while (end < array.length && array[end] != ' ') {
                end++;
            }
            reverse(array, start, end - 1);
            start = end + 1;
        }
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseWordI test = new ReverseWordI();
        System.out.print(test.solve("miao miao   love mao mao   "));
    }




}

/**
    public String solve(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i == 0) || (array[i] != ' ' && array[i - 1] == ' ')) {
                start = i;
            }
            if ((i + 1== array.length) || (array[i] != ' ' && array[i + 1] == ' ')) {
                if (start != -1) {
                    reverse(array, start, i);
                    start = -1;
                }

            }
        }
        reverse(array, 0, array.length - 1);
        return new String(array);
    }
 */



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