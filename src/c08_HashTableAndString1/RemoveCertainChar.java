package c08_HashTableAndString1;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainChar {
    public String solve(String input, String t) {
        if (input.length() == 0 || t.length() == 0) {
            return input;
        }
        Set<Character> set = new HashSet<Character>();
        char[] target = t.toCharArray();
        for(char currT : target) {
            set.add(currT);
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }
        return new String(array, 0, slow);
    }

    public static void main(String[] args) {
        RemoveCertainChar test = new RemoveCertainChar();
        System.out.println(test.solve("abcd", "ab"));
    }
}


/**
public class Solution {
    public String remove(String input, String t) {
        if (input.length() == 0 || t.length() == 0) {
            return input;
        }
        Set<Character> set = new HashSet<>();
        char[] target = t.toCharArray();
        for (int i = 0; i < target.length; i++) {
            set.add(target[i]);
        }
        int slow = 0;
        char[] letter = input.toCharArray();
        for (int fast = 0; fast < letter.length; fast++) {
            if (!set.contains(letter[fast])) {
                letter[slow++] = letter[fast];
            }
        }
        return new String(letter, 0, slow);
    }
}
**/