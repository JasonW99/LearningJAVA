package c13_DynamicProgramming02;

public class EditDistance {
    public int solve(String one, String two) {
        if (one.length() == 0 || two.length() == 0) {
            return one.length() + two.length();
        }
        int[][] result = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = i + j;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.min(result[i - 1][j] + 1, result[i][j - 1] + 1);
                    result[i][j] = Math.min(result[i][j], result[i - 1][j - 1] + 1);
                }
            }
        }
        return result[one.length()][two.length()];
    }
}


/**
public class Solution {
    public int editDistance(String one, String two) {
        char[] array1 = one.toCharArray();
        char[] array2 = two.toCharArray();
        return edit(array1, 0, array2, 0);
    }

    private int edit(char[] array1, int index1, char[] array2, int index2) {
        if (index1 == array1.length || index2 == array2.length) {
            return array1.length + array2.length - index1 - index2;
        }
        if (array1[index1] == array2[index2]) {
            return edit(array1, index1 + 1, array2, index2 + 1);
        } else {
            int replace = edit(array1, index1 + 1, array2, index2 + 1) + 1;
            int delete = edit(array1, index1 + 1, array2, index2) + 1;
            int insert = edit(array1, index1, array2, index2 + 1) + 1;
            return Math.min(replace, Math.min(delete, insert));
        }
    }
}
**/