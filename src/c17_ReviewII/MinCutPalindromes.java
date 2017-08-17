package c17_ReviewII;

public class MinCutPalindromes {
    public int solve(String input) {
        if (input == null || input.length() <= 1) {
            return 0;
        }
        int n = input.length();
        boolean[][] valid = new boolean[n][n];
        for (int diff = 0; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                if (diff == 0) {
                    valid[i][j] = true;
                } else if (diff == 1) {
                    valid[i][j] = (input.charAt(i) == input.charAt(j));
                } else if (input.charAt(i) == input.charAt(j)) {
                    valid[i][j] = valid[i + 1][j - 1];
                }
            }
        }
        int[] minCut = new int[n];
        for (int j = 1; j < n; j++) {
            if (valid[0][j]) {
                minCut[j] = 0;
            } else {
                minCut[j] = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    if (valid[k + 1][j]) {
                        minCut[j] = Math.min(minCut[j], minCut[k] + 1);
                    }
                }
            }
        }
        return minCut[n - 1];
    }

    public static void main(String[] args) {
        MinCutPalindromes test = new MinCutPalindromes();
        System.out.print(test.solve("abcbd"));
    }
}




/*
pal[i][j] represents if sub-string from i-th to j-th characters is a palindrome or not.
Initialization: when i == j, pal[i][j] = true;
General rule: if char[i] != char[j], pal[i][j] = false;
              else, pal[i][j] = i == j-1 ? true: pal[i+1][j-1];

M[i][j] represents the min cuts for palindromes from i-th to j-th character.
Initialization:
if pal[i][j], M[i][j] = 0;
else if the first cut happens at k-th character (i <= k < j), it has to fulfill
M[i][j] = min(1 + M[k+1][j])
*/
/**
public class Solution {
    public int minCuts(String input) {
        if (input == null || input.length() <= 1) {
            return 0;
        }
        char[] letter = input.toCharArray();
        boolean[][] pal = new boolean[letter.length][letter.length];
        for (int diff = 0; diff < letter.length; diff++) {
            for (int start = 0; start < letter.length - diff; start++) {
                if (diff == 0) {
                    pal[start][start+diff] = true;
                } else if (letter[start] == letter[start+diff]) {
                    pal[start][start+diff] = diff == 1 ? true: pal[start+1][start+diff-1];
                }
            }
        }
        if (pal[0][letter.length - 1]) {
            return 0;
        }
        int[][] M = new int[letter.length][letter.length];
        for (int diff = 1; diff < letter.length; diff++) {
            for (int start = 0; start < letter.length - diff; start++) {
                if (!pal[start][start+diff]) {
                    M[start][start+diff] = min(pal, M, start, start+diff);
                }
            }
        }
        return M[0][letter.length-1];
    }

    private int min(boolean[][] pal, int[][] M, int start, int end) {
        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (pal[start][i]) {
                ans = Math.min(ans, 1 + M[i+1][end]);
            }
        }
        return ans;
    }
}
**/