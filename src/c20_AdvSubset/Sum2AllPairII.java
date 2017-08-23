package c20_AdvSubset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum2AllPairII {
    public List<List<Integer>> solve(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> setArray = new HashSet<>();
        Set<Integer> setSubResult = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (setArray.contains(target - array[i]) && setSubResult.add(Math.min(array[i], target - array[i]))) {
                List<Integer> subResult = new ArrayList<>();
                // subResult.add(Math.min(array[i], target - array[i]));
                // subResult.add(Math.max(array[i], target - array[i]));
                subResult.add(target - array[i]);
                subResult.add(array[i]);
                result.add(subResult);
            }
            setArray.add(array[i]);
        }
        return result;
    }
}

/**
public class Sum2AllPairII {
    public List<List<Integer>> solve(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> setArray = new HashSet<>();
        Set<Integer> setSubResult = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (setArray.contains(target - array[i])) {
                int small = Math.min(array[i], target - array[i]);
                if (!setSubResult.contains(small)) {
                    setSubResult.add(small);
                    List<Integer> subResult = new ArrayList<>();
                    subResult.add(small);
                    subResult.add(Math.max(array[i], target - array[i]));
                    result.add(subResult);
                }
            }
            setArray.add(array[i]);
        }
        return result;
    }
}
**/