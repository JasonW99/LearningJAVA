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


