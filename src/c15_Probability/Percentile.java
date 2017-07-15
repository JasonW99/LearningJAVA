package c15_Probability;


import java.util.List;

public class Percentile {
    public int solve(List<Integer> lengths) {
        int[] count = new int[4097];
        for (Integer curr : lengths) {
            count[curr]++;
        }
        // double requiredCounts = lengths.size() * 95 / 100;  // wrong
        double requiredCounts = lengths.size() * 0.95;
        int accumulatedCounts = 0;
        int index = 0;
        while (accumulatedCounts < requiredCounts) {
            accumulatedCounts += count[index++];
        }
        return index - 1;
    }
}
