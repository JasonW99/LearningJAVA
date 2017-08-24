package c21_AdvString;

public class LongestCommonSubString {
    public String solve(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0 || m == 0) {
            return "";
        }
        int maxGlobal = 0;
        int endGlobal = 0;
        int[][] commonMatch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    commonMatch[i][j] = s.charAt(i) == t.charAt(j) ? 1 : 0;
                } else {
                    commonMatch[i][j] = s.charAt(i) == t.charAt(j) ? commonMatch[i - 1][j - 1] + 1 : 0;
                }
                if (commonMatch[i][j] > maxGlobal) {
                    maxGlobal = commonMatch[i][j];
                    endGlobal = j;
                }
            }
        }
        return t.substring(endGlobal - maxGlobal + 1, endGlobal + 1);
//        return t.substring(1, 1);
    }

    public static void main(String[] args) {
        LongestCommonSubString test = new LongestCommonSubString();
        System.out.println(test.solve("ghh", "ghh"));
    }
}
