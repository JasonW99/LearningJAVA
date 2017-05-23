package c03_BinarySearch;

public class classicalBS {
    public int solve(int[] array, int target) {
        if (array == null || array.length == 0){
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] > target) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        classicalBS test = new classicalBS();
        int[] input = {1, 2, 2, 2, 2, 4, 5};
        int T = 2;
        System.out.println(test.solve(input, T));
    }
}
