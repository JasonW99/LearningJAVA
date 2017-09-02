package c47_RandomLeetC;

public class RandomFromIntervals {
    public int solve(int[][] intervals, int total) {
        while (true) {
            int N = total;
            for (int i = 0; i < intervals.length; i++) {
                int a = intervals[i][0];
                int b = intervals[i][1];
                int k = b - a + 1;
                int random = (int) (Math.random() * N);
                if (random < k) {
                    return a + k;
                }
                N -= k;
            }
        }
    }
}
