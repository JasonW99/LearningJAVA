package c21_AdvString;

public class LongestCommonSubSequence {
    public int solve(String s, String t) {
        int[][] longest = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < longest.length; i++) {
            for (int j = 1; j < longest[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    longest[i][j] = longest[i - 1][j - 1] + 1;
                } else {
                    longest[i][j] = Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return longest[longest.length - 1][longest[0].length - 1];
    }
}



/**
public class Solution {
    public int longest(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int max = 0;
        int[][] ans = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (i == 0 || j == 0) {
                    if (s.charAt(i) == t.charAt(j) || ((i > 0 && ans[i-1][j] == 1) || (j > 0 && ans[i][j-1] == 1))) {
                        ans[i][j] = 1;
                    }
                } else {
                    ans[i][j] = s.charAt(i) == t.charAt(j) ? ans[i-1][j-1] + 1: Math.max(ans[i-1][j], ans[i][j-1]);
                }
                max = Math.max(max, ans[i][j]);
            }
        }
        return max;
    }
}
 **/
/*
  a b c d e f g
b 0 1 1 1 1 1 1
a 1
b 1
c 1
g 1
f 1
e 1
g 1
h 1*/