package c03_BinarySearch;

import java.util.Arrays;

public class kclosestBS {
    public int[] solve(int[] array, int target, int K){
        if (array == null || array.length == 0){
            return array;
        }
        if(K == 0) {
            return new int[0];
        }
        int size = Math.min(K, array.length);
        int[] result =new int[size];
        int initial = closest(array, target);
        int left = initial - 1;
        int right = initial + 1;
        result[0] = array[initial];
        for (int i = 1; i < size; i++){
            if(left < 0 || (right < array.length && closer(array, target, right, left))) {
                result[i] = array[right++];
            }else {
                result[i] = array[left--];
            }
        }
        return result;
    }

    private int closest(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                end = mid;
            }else if (array[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        return closer(array, target, start, end) ? start : end;
    }

    private boolean closer(int[] array, int target, int i, int j) {
        return Math.abs(array[i] - target) <= Math.abs(array[j] - target);
    }

    public static void main(String[] args) {
        kclosestBS test = new kclosestBS();
        int[] input = {1,3,3,6,9,9,12,15};
        int T = 10;
        int K = 5;
        int[] result = test.solve(input, T, K);
        System.out.println(Arrays.toString(result));
    }
}
