package c01_Sort;

import java.util.Arrays;

public class rainbowSort {
    public int[] solve(int[] array) {
        if(array == null || array.length <= 1) {
            return array;
        }
        int red = 0;    // the points on the left side of the red pointer are all red(-1).
        int green = 0;  // the points between red pointer(included) and green pointer(excluded) are all green(0).
        int blue = array.length - 1; // the points on the right side of the blue pointer are all blue(1).
        while (green <= blue) {
            if(array[green] == -1){
                swap(array, green, red);
                green++;
                red++;
            }else if(array[green] == 1) {
                swap(array, green, blue);
                blue--;
            }else {
                green++;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        rainbowSort test = new rainbowSort();
        int[] input = {1, 0, -1, -1, 0, 0, 1};
        input = test.solve(input);
        System.out.println(Arrays.toString(input));
    }
}
