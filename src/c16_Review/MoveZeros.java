package c16_Review;

public class MoveZeros {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] != 0) {
                array[slow++] = array[fast];
            }
        }
        while (slow < array.length) {
            array[slow++] = 0;
        }
        return array;
    }
}
