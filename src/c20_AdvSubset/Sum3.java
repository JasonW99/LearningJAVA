package c20_AdvSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> solve(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (array == null || array.length < 3) {
            return result;
        }
        Arrays.sort(array);
        int i = 0;
        while (i < array.length - 2 && array[i] < target / 3 + 1) {
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {
                if (array[j] + array[k] == target - array[i]) {
                    result.add(Arrays.asList(array[i], array[j], array[k]));
                    while (j + 1 < k && array[j++] == array[j + 1]) {
                        j++;
                    }
                    j++;
                } else if (array[j] + array[k] < target - array[i]) {
                    j++;
                } else {
                    k--;
                }
            }
            while (i < array.length - 2 && array[i] < target / 3 + 1 && array[i] == array[i + 1]) {
                i++;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Sum3 test = new Sum3();
        List<List<Integer>> result = test.solve(new int[] {1, 1, 1, 2, 2, 2, 3}, 5);
        for (List<Integer> curr : result) {
            System.out.println(curr.toString());
        }
    }
}


/**
public class Solution {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        int k = 2;
        while (k < array.length) {
            while (k + 1 < array.length && array[k] == array[k + 1]) {
                k++;
            }
            findSum(array, k - 1, target - array[k], result);
            k++;
        }
        return result;
    }

    private void findSum(int[] array, int end, int target, List<List<Integer>> result) {
        int start = 0;
        int kValue = array[end + 1];
        while (start < end) {
            if (array[start] + array[end] == target) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(array[start]);
                subResult.add(array[end]);
                subResult.add(kValue);
                result.add(subResult);
                while (start + 1 < end && array[start] == array[start + 1]) {
                    start++;
                }
                start++;
            } else if (array[start] + array[end] < target) {
                start++;
            } else
                end--;
        }
    }
}
 **/