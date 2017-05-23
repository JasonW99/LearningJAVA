package c03_BinarySearch;

public class oneclosestBS {
    public int solve(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.abs(array[start] - target) < Math.abs(array[end] - target) ? start : end;
    }

    public static void main(String[] args) {
        oneclosestBS test = new oneclosestBS();
        int[] input = {1, 3, 3, 4};
        int T = 2;
        System.out.println(test.solve(input, T));
    }
}
