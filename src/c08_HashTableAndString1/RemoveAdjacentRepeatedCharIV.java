package c08_HashTableAndString1;

/**
 Repeatedly remove all adjacent, repeated characters in a given string from left to right.
 No adjacent characters should be identified in the final string.

 Examples
 "abbbaaccz" → "aaaccz" → "ccz" → "z"
 "aabccdc" → "bccdc" → "bdc"
 */

public class RemoveAdjacentRepeatedCharIV {
    public String solve(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = -1;
        int fast = 0;
        while (fast < array.length) {
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast++];
            } else {
                while (fast + 1 < array.length && array[fast + 1] == array[fast]) {
                    fast++;
                }
                fast++;
                slow--;
            }
        }
        return new String(array, 0, slow + 1);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharIV test = new RemoveAdjacentRepeatedCharIV();
        String input = "aabbbaccz";
        System.out.println(test.solve(input));
    }
}


