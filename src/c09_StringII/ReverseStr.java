package c09_StringII;

public class ReverseStr {
    public String solve(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] result = input.toCharArray();
        int start = 0;
        int end = result.length - 1;
        while (start < end) {
            char temp = result[start];
            result[start++] = result[end];
            result[end--] = temp;
        }
        return new String(result);
    }

}
