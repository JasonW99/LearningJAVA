package c09_StringII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII {
    public List<String> solve(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        permutationRecur(array, result, 0);
        return result;
    }

    private void permutationRecur(char[] array, List<String> result, int level) {
        if (level == array.length) {
            result.add(new String(array));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = level; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                swap(array, level, i);
                permutationRecur(array, result, level + 1);
                swap(array, level, i);
            }
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        PermutationII test = new PermutationII();
        List<String> result = test.solve("bbaa");
        for (String curr : result) {
            System.out.println(curr);
        }
    }
}


