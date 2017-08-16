package c01_Sort;

import java.util.Arrays;

public class mergeSort {
    public int[] divide(int[] array){
        if(array == null || array.length <= 1){
            return array;
        }
        int[] helper = new int[array.length];
        divide(array, helper, 0, array.length - 1);
        return array;
    }

    private void divide(int[] array, int[] helper, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(array, helper, start, mid);
        divide(array, helper, mid + 1, end);
        merge(array, helper, start, end, mid);
    }

    private void merge(int[] array, int[] helper, int start, int end, int mid){
        for(int i = start; i <= end; i++){
            helper[i] = array[i];
        }
        int left = start;
        int right = mid + 1;
        while(left <= mid && right <= end){
            if(helper[left] < helper[right]){
                array[start++] = helper[left++];
            }else{
                array[start++] = helper[right++];
            }
        }
        while(left <= mid){
            array[start++] = helper[left++];
        }
    }

    public static void main(String[] args){
        mergeSort test = new mergeSort();
        int[] input = {8, -3, 5, 9, 88, -2};
        input = test.divide(input);
        System.out.println(Arrays.toString(input));
    }
}