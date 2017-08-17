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

/**
public class Solution {
    public int percentile95(List<Integer> lengths) {
        int[] histogram = new int[4097];
        for (Integer curr : lengths) {
            histogram[curr]++;
        }
        double accumCount = lengths.size() * 0.95;
        for (int i = 0; i < histogram.length - 1; i++) {
            accumCount -= histogram[i];
            if (accumCount <= 0) {
                return i;
            }
        }
        return -1;
    }
}
**/