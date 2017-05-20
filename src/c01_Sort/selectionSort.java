package c01_Sort;

public class selectionSort {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]){
                    swap(array, i, j);
                }
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
        selectionSort test = new selectionSort();
        int[] input = {0, -2, 0, 100, 0, 9};
        input = test.solve(input);
        for(int i : input){
            System.out.print(i + " ");
        }
    }
}
