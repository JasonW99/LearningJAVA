package c09_StringII;

public class ShiftN {
    public String slove(String input, int n) {
        if (input == null || input.length() <= 1 || n == 0) {
            return input;
        }
        n = n % input.length();
        char[] result = input.toCharArray();
        reverse(result, 0, result.length - n - 1);
        reverse(result, result.length - n, result.length - 1);
        reverse(result, 0, result.length - 1);
        return new String(result);
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }
}

/**
public class Solution {
    public String rightShift(String input, int n) {
        if (input.length() == 0 || n == 0) {
            return input;
        }
        n = n % input.length();
        char[] letter = input.toCharArray();
        swap(letter, 0, letter.length - 1 - n);
        swap(letter, letter.length - n, letter.length - 1);
        swap(letter, 0, letter.length - 1);
        return new String(letter);
    }

    private void swap(char[] letter, int start, int end) {
        while (start < end) {
            char temp = letter[start];
            letter[start] = letter[end];
            letter[end] = temp;
            start++;
            end--;
        }
    }
}
 **/
