package c16_Review;

import java.util.*;

public class LargestAndSecond {
    public int[] solve(int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        int start = 0;
        int end = array.length - 1;

        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            for (int i = start; i <= mid; i++) {
                if (array[i] > array[end - i + start]) {
                    swap(array, i, end - i + start);
                }
                if (i != end - i + start) {
                    setMap(array[end - i + start], array[i], map);
                }
            }
            start = mid;
        }
        int max = 0;
        if (array[start] > array[end]) {
            setMap(array[start], array[end], map);
            max = array[start];
        } else {
            setMap(array[end], array[start], map);
            max = array[end];
        }
        int second = findMax(map.get(max));
        return new int[]{max, second};
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void setMap(int curr, int compare, Map<Integer, List<Integer>> map) {
        if (map.get(curr) == null) {
            List<Integer> comparedNum = new ArrayList<Integer>();
            comparedNum.add(compare);
            map.put(curr, comparedNum);
        } else {
            map.get(curr).add(compare);
        }
    }

    private int findMax(List<Integer> input) {
        int result = Integer.MIN_VALUE;
        for (Integer curr : input) {
            result = Math.max(result, curr);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestAndSecond test = new LargestAndSecond();
        System.out.print(Arrays.toString(test.solve(new int[]{5, 4, 3, 2, 1})));
    }
}
