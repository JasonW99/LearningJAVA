package c15_Probability;

public class R7UsingR5 {
    private R5 RandomFive = new R5();
    public int solve() {
        int propose = 24; // need the proposed number within range [0, 23)
        while (propose > 20) { // suppose the proposed number is generated from a 5x5 matrix, with equal probability. (ignore the last 4 digits)
            int row = RandomFive.random5();
            int col = RandomFive.random5();
            propose = 5 * row + col;
        }
        return propose % 7;
    }
}



/**
public class Solution {
    public int random7() {
        // write your solution here
        // you can use R5.random5() for generating
        // 0 - 4 with equal probability.
        int sol = 21;
        while (sol > 20) {
            sol = R5.random5() * 5 + R5.random5();
        }
        return sol % 7;
    }
}
**/