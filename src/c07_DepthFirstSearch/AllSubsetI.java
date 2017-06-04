package c07_DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetI {
    public List<String> solve(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] input = set.toCharArray();
        StringBuilder subResult = new StringBuilder();
        subset(input, subResult, result, 0);
        return result;
    }

    private void subset(char[] input, StringBuilder subResult,  List<String> result, int level) {
        if (level == input.length) {
            result.add(subResult.toString());
            return;
        }
        subResult.append(input[level]);
        subset(input, subResult, result, level + 1);
        subResult.deleteCharAt(subResult.length() - 1);
        subset(input, subResult, result, level + 1);
    }

    public static void main(String[] args) {
        AllSubsetI test = new AllSubsetI();
        String set = "abc";
        List<String> result = test.solve(set);
        for (String sub : result) {
            System.out.println(sub);
        }
    }
}


