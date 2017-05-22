package c02_BinarySearch;

public class lastoccurrenceBS {
    public int solve(int[] array, int target) {
        if (array == null || array.length == 0){
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (array[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return array[end] == target ? end : array[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        lastoccurrenceBS test = new lastoccurrenceBS();
        int[] input = {1, 2, 2, 2, 3};
        int T = 2;
        System.out.println(test.solve(input, T));
    }
}
