package c08_HashTableAndString1;

public class RemoveAdjacentRepeatedCharIV {
    public String solve(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }


    }
}


/**
public class Solution {
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        int slow = -1;
        int fast = 0;
        char[] array = input.toCharArray();
        while (fast < array.length) {
            if (slow < 0 || array[fast] != array[slow]) {
                array[++slow] = array[fast++];
            } else {
                while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
                    fast++;
                }
                fast++;
                slow--;
            }
        }
        return new String(array, 0, slow + 1);
    }
}
**/