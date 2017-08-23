package c20_AdvSubset;

import java.util.ArrayList;
import java.util.List;

public class CommonElementIn3SortedArray {
    public List<Integer> solve(int[] a, int[] b, int[] c) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                result.add(a[i]);
                i++;
                j++;
                k++;
            } else {
                int max = Math.max(Math.max(a[i], b[j]), c[k]);
                if (a[i] != max) {
                    i++;
                }
                if (b[j] != max) {
                    j++;
                }
                if(c[k] != max) {
                    k++;
                }
            }
        }
        return result;
    }
}
