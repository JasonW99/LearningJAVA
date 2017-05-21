package c02_BinarySearch;

public class firstoccurrenceBS {
    public int solve(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(array[mid] < target) {
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        return array[start] == target? start: -1;
    }

    public static void main(String[] args){
        firstoccurrenceBS test = new firstoccurrenceBS();
        int[] input = {1, 2, 2, 2, 3};
        int T = 2;
        System.out.println(test.solve(input, T));
    }
}
