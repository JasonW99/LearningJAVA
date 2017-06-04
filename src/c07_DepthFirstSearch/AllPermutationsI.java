package c07_DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {
    public List<String> solve(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] input = set.toCharArray();
        permutationRecur(input, result, 0);
        return result;
    }

    private void permutationRecur(char[] input, List<String> result, int level) {
        if (level == input.length - 1) {
            result.add(new String(input));
            return;
        }
        for (int i = level; i < input.length; i++) {
            swap(input, level, i);
            permutationRecur(input, result, level + 1);
            swap(input, level, i);
        }
    }

    private void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        AllPermutationsI test = new AllPermutationsI();
        String set = "abc";
        List<String> result = test.solve(set);
        for (String sub : result) {
            System.out.println(sub);
        }
    }
}
