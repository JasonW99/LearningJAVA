package c21_AdvString;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public int solve(int[] array) {
        int result = 0;
        Deque<Integer> leftIndexStack = new LinkedList<>();
        int right = 0;
        while (right <= array.length) {
            if (leftIndexStack.isEmpty()) {
                leftIndexStack.push(right++);
            } else if (right != array.length && array[right] >= array[leftIndexStack.peek()]) {
                leftIndexStack.push(right++);
            } else {
                int height = array[leftIndexStack.pop()];
                int left = leftIndexStack.isEmpty() ? 0 : leftIndexStack.peek() + 1;
                result = Math.max(result, (right - left) * height);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.solve(new int[] {2,5,6,4,3,4,1}));
    }
}
/**
public class LargestRectangleInHistogram {
    public int solve(int[] array) {
        int result = 0;
        Deque<Integer> leftIndexStack = new LinkedList<>();
        leftIndexStack.push(0);
        int right = 1;
        while (!leftIndexStack.isEmpty()) {
            while (!leftIndexStack.isEmpty() && (right >= array.length || array[right] <= array[leftIndexStack.peek()])) {
                int height = array[leftIndexStack.pop()];
                int left = leftIndexStack.isEmpty() ? 0 : leftIndexStack.peek() + 1;
                result = Math.max(result, (right - left) * height);
            }
            if (right < array.length) {
                leftIndexStack.push(right++);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.solve(new int[] {2,5,6,4,3,4,1}));
    }
}
 **/
/**
public class LargestRectangleInHistogram {
    public int solve(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int height = array[i];
            for (int j = i; j < array.length; j++) {
                height = Math.min(height, array[j]);
                result = Math.max((j - i + 1) * height, result);
            }
        }
        return result;
    }
}
**/