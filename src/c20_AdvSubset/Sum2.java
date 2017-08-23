package c20_AdvSubset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sum2 {
    public boolean solve(int[] array, int target) {
        if (array == null || array.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(target - array[i])) {
                return true;
            }
            set.add(array[i]);
        }
        return false;
    }
}

/**
public class Solution {
    public boolean existSum(int[] array, int target) {
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (start != end && array[start] + array[end] == target) {
                return true;
            }
            if (array[start] + array[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
**/