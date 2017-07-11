package c13_DynamicProgramming02;

import java.util.HashSet;
import java.util.Set;

public class DictionaryWordI {
    public boolean solve(String input, String[] dict) {
        Set<String> set = new HashSet<String>();
        for (String curr : dict) {
            set.add(curr);
        }
        boolean[] result = new boolean[input.length()];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j <= i; j++) {
                if ((j == 0 || result[j - 1]) && set.contains(input.substring(j, i + 1))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[result.length - 1];
    }
}
