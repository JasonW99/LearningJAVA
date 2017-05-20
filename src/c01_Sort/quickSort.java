package c01_Sort;

import java.util.Arrays;

public class quickSort {
    public int[] solve(int[] array){
        if(array == null || array.length <= 1){
            return array;
        }
        solve(array, 0, array.length - 1);
        return array;
    }

    private void solve(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int p = pivital(array, start, end);
        solve(array, start, p - 1);
        solve(array, p + 1, end);
    }

    private int pivital(int[] array, int start, int end){
        int left = start;
        int right = end - 1;
        while(left <= right){
            if(array[left] <= array[end]){
                left++;
            }else{
                swap(array, left, right);
                right--;
            }
        }
        swap(array, left, end);
        return left;
    }

    private void swap(int[] array, int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args){
        quickSort test = new quickSort();
        int[] input = {2, -2, 31, 0, 1};
        input = test.solve(input);
        System.out.println(Arrays.toString(input));
    }
}





