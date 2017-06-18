package c09_StringII;

import java.util.Arrays;

public class ShuffleII {
    public int[] solve(int[] array) {
        if (array == null || array.length <= 3) {
            return array;
        }
//        shuffle(array, 0, array.length / 2 * 2 - 1);
        shuffleI(array, 0, array.length / 2 * 2 - 1);
        return array;
    }

    private void shuffle(int[] array, int start, int end) {
        if (end - start <= 1) {
            return ;
        }
        int mid = start + (end  - start + 1) / 2;
        int leftMid = start + (mid - 1 - start + 1) / 2;
        int rightMid = mid + (end - mid + 1) / 2;
        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);
        shuffle(array, start, leftMid - 1 + rightMid - mid);
        shuffle(array, leftMid + rightMid - mid, end);
//        int mid = start + (end - start) / 2;
//        int leftMid = start + (mid - start) / 2;
//        int rightMid = mid + 1 + (end - mid - 1) / 2;
//        reverse(array, mid + 1, rightMid);
//        reverse(array, leftMid + 1, mid);
//        reverse(array, leftMid + 1, rightMid);
//        shuffle(array, start, leftMid + rightMid - mid);
//        shuffle(array, leftMid + rightMid - mid + 1, end);
    }

    private void shuffleI(int[] array, int start, int end) {
        int len = end - start + 1;
        if (len <= 2) {
            return;
        }
        int mid = start + len / 2;
        int leftMid = start + len / 4;
        int rightMid = start + len * 3 / 4;
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, mid - 1);
        reverse(array, leftMid, rightMid - 1);
        shuffleI(array, start, leftMid - 1 + rightMid - mid);
        shuffleI(array, leftMid + rightMid - mid, end);
    }

    private void reverse(int[] array, int i, int j) {
        while (i < j) {
            int temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }
    }

    public static void main(String[] args) {
        ShuffleII test = new ShuffleII();
        System.out.println(Arrays.toString(test.solve(new int[] {0, 1, 2, 3, 4, 5})));
    }
}
