package c47_RandomLeetC;

public class AllSubArraySum {
    public int solve(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = array.length;
        int[] preSum = new int[n];
        preSum[0] = array[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = array[i] + preSum[i - 1];
        }

        int result = 0;
        for (int diff = 0; diff < n; diff++) {
            for (int i = 0; i < n - diff; i++) {
                int j = i + diff;
                result += preSum[j] - preSum[i] + array[i];
            }
        }
        return result;
    }

    public int solve2(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = array.length;
        int k = (n + 1) / 2;
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (i != n - 1 - i) {
                result += (array[i] + array[n - 1 - i]) * ((n + n - 2 * i) * (i + 1) / 2);
            } else {
                result += array[i] * ((n + n - 2 * i) * (i + 1) / 2);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AllSubArraySum test = new AllSubArraySum();
        int[] input = new int[] {1, 4, 2};
        System.out.println(test.solve(input));
        System.out.println(test.solve2(input));
    }
}
