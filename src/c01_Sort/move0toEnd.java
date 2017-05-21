package c01_Sort;

import java.util.Arrays;

public class move0toEnd {
    public int[] solve(int[] array) {
        if(array == null || array.length <=1) {
            return array;
        }
        // integers between start0 and end0 are all zeros
        int start0 = 0;
        for(int end0 = 0; end0 < array.length; end0++){
            if(array[end0] != 0){
                swap(array, end0, start0);
                start0++;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        move0toEnd test = new move0toEnd();
        int[] input = {1, 1, 0, 0, 3, 2};
        input = test.solve(input);
        System.out.println(Arrays.toString(input));
    }
}

/**
public class move0toEnd {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int start0 = 0;
        for (int end0 = 0; end0 < array.length; end0++) {
            if (array[end0] != 0) {
                array[start0++] = array[end0];
            }
        }
        while (start0 < array.length) {
            array[start0++] = 0;
        }
        return array;
    }

    public static void main(String[] args) {
        move0toEnd test = new move0toEnd();
        int[] input = {1, 1, 0, 0, 3, 2};
        input = test.solve(input);
        System.out.println(Arrays.toString(input));
    }
}
**/