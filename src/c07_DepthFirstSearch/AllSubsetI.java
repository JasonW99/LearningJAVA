package c07_DepthFirstSearch;

public class AllSubsetI {



}




/**
public class Solution {
    public List<String> subSets(String set) {
        if (set == null) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        char[] input = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        dfs(input, 0, sb, result);
        return result;
    }

    private void dfs(char[] input, int level, StringBuilder sb, List<String> result) {
        if (level == input.length) {
            result.add(new String(sb));
            return;
        }
        sb.append(input[level]);
        dfs(input, level + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        dfs(input, level + 1, sb, result);
    }
}
**/