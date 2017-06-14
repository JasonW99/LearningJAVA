package c09_StringII;


public class Decompress {
    public String slove(String input) {
        StringBuilder result = new StringBuilder();
        int curr = 0;
        while (curr < input.length()) {
            for (int i = 0; i < (input.charAt(curr + 1) - '0'); i++) {
                result.append(input.charAt(curr));
            }
            curr += 2;
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Decompress test = new Decompress();
        System.out.println(test.slove("a1c0b2c4"));
    }
}


/**
public class Solution {
    public String decompress(String input) {
        if (input.length() == 0) {
            return input;
        }
        char[] letter = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < letter.length) {
            if (number(letter[index])) {
                int count = 0;
                Character c = letter[index-1];
                while (index < letter.length && number(letter[index])) {
                    count = letter[index] - '0' + 10 * count;
                    index++;
                }
                for (int i = 0; i < count; i++) {
                    sb.append(c);
                }
            } else {
                index++;
            }
        }
        return new String(sb);
    }

    private boolean number(Character c) {
        int value = c - '0';
        return value >= 0 && value <= 9;
    }
}
 **/