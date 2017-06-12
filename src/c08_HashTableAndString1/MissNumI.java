package c08_HashTableAndString1;

import java.util.HashSet;
import java.util.Set;

public class MissNumI {
    public int solve(int[] array) {
        int n = array.length + 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int element : array) {
            set.add(element);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MissNumI test = new MissNumI();
        int[] input = {1, 3, 4};
        System.out.print(test.solve(input));
    }

}


/**
public class Solution {
    public int missing(int[] array) {
        int n = array.length + 1;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result ^= i;
        }
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }
}
**/